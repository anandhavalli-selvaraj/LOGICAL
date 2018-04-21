package org.anandh.javabrains.messengerapp.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.anandh.javabrains.messengerapp.model.Comment;
import org.anandh.javabrains.messengerapp.service.CommentService;

@Path("/")
public class CommentResource {
	
	private CommentService commentService=new CommentService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List< Comment> getComment(@PathParam("messageId")Long messageId)
	{
		return commentService.getAllComments(messageId);
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment addComment(@PathParam("messageId")Long messageId,Comment comment)
	{
		return commentService.addComment(messageId, comment);
		}
	
	@GET
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment getComment(@PathParam("messageId")Long messageId,@PathParam("commentId")Long commentId)
	{
		System.out.println("The messageId is "+messageId+" and The Comment Id "+commentId);
		return commentService.getComment(messageId, commentId) ;
	}

}
