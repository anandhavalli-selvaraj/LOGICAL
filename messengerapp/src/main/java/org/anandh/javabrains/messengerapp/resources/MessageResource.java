package org.anandh.javabrains.messengerapp.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.anandh.javabrains.messengerapp.model.Message;
import org.anandh.javabrains.messengerapp.resources.beans.MessageFilterBean;
import org.anandh.javabrains.messengerapp.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
   private MessageService messageService=new MessageService();
	
	@GET
    public List<Message> getMessages(@BeanParam MessageFilterBean messageFilterBean)
	{
		if(messageFilterBean.getYear()>0)
		{
			return messageService.getAllMessagesForYear(messageFilterBean.getYear());
		}
		if(messageFilterBean.getIndex()>=0&messageFilterBean.getLimit()>0)
		{
			return messageService.getAllMessagesPagination(messageFilterBean.getIndex(), messageFilterBean.getLimit());
		}
		List<Message>messageList=messageService.getAllMessages();
		System.out.println(messageList);
		return messageList;
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage (@PathParam("messageId") Long messageId,@Context UriInfo uriInfo)
	{
		Message message=messageService.getMessage(messageId) ;
		String uri = getURISelf(messageId, uriInfo);
		message.addLink(uri, "self");
		return message;
	}

	private String getURISelf(Long messageId, UriInfo uriInfo) {
		String uri=uriInfo.getBaseUriBuilder().path(MessageResource.class).path(String.valueOf(messageId)).build().toString();
		return uri;
	}
	
	
	@POST
	public Response addMessage(Message message,@Context UriInfo uriInfo) 
	{
		 System.out.println(uriInfo.getAbsolutePath());
		Message messageResp= messageService.addMessage(message);
		return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(messageResp.getId())).build()).entity(messageResp).build();
	}
	
	@PUT
	@Path("{messageId}")
	public Message updateMessage(@PathParam("messageId") Long id ,Message message)
	{
		message.setId(id);
		return messageService.update(message);
	}
	
	@DELETE
	@Path("{messageId}")
	public void deleteMessage(@PathParam("messageId")Long id)
	{
		messageService.remove(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
	
	
	
}
