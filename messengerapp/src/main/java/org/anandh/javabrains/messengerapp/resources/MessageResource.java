package org.anandh.javabrains.messengerapp.resources;

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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.anandh.javabrains.messengerapp.model.Message;
import org.anandh.javabrains.messengerapp.resources.beans.MessageFilterBean;
import org.anandh.javabrains.messengerapp.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
   private MessageService messageService=new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Message> getJSONMessages(@BeanParam MessageFilterBean messageFilterBean)
	{
		System.out.println("JSON Method called");
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
		System.out.println("JSON Method called");

		return messageList;
	}
	@GET
	@Produces(MediaType.TEXT_XML)
    public List<Message> getXMLMessages(@BeanParam MessageFilterBean messageFilterBean)
	{
		System.out.println("XML Method called");
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
		System.out.println("JSON Method called");
		return messageList;
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage (@PathParam("messageId") Long messageId,@Context UriInfo uriInfo)
	{
		Message message=messageService.getMessage(messageId) ;
		message.addLink(getURISelf(messageId, uriInfo), "self");
		String profileURI=getURIProfile(message,uriInfo);
		message.addLink(profileURI, "profile");
		String commentURI=getCommentURI(message,uriInfo);
		message.addLink(commentURI, "comment");
		return message;
	}

	private String getCommentURI(Message message, UriInfo uriInfo) {
		String commentUri=uriInfo.getBaseUriBuilder().path(MessageResource.class).path(MessageResource.class,"getCommentResource").resolveTemplate("messageId", message.getId()).build().toString();
		return commentUri;
	}

	private String getURIProfile(Message message, UriInfo uriInfo) {
		String profileURL=uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(message.getAuthor()).toString();
		return profileURL;
	}

	private String getURISelf(Long messageId, UriInfo uriInfo) {
		String uri=uriInfo.getBaseUriBuilder().path(MessageResource.class).path(String.valueOf(messageId)).build().toString();
		return uri;
	}
	
	
	@POST
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
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
