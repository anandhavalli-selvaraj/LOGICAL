package org.anandh.javabrains.messengerapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.anandh.javabrains.messengerapp.database.DataBaseClass;
import org.anandh.javabrains.messengerapp.model.Comment;
import org.anandh.javabrains.messengerapp.model.ErrorMessage;
import org.anandh.javabrains.messengerapp.model.Message;

public class CommentService {
   private Map<Long,Comment>comments=DataBaseClass.getAllComments();
   //that is not pointing to the same messageService class.
   private Map<Long,Message>messages=DataBaseClass.getAllMessages();
   public List<Comment> getAllComments(Long messageId)
	  {
		return new ArrayList<>(messages.get(messageId).getCommentMap().values());
	  }
	public Comment addComment(Long messageId,Comment comment)
	  {
		
		comment.setId(messages.get(messageId).getCommentMap().size()+1);
		messages.get(messageId).getCommentMap().put(comment.getId(), comment);
		return comment;
	  }
	  public Comment getComment(long messageId,long commentId)
	  {ErrorMessage errorMessge=new ErrorMessage("Not Found", 404, "http://javabrains.koushik.org");
		Response reponse= Response.status(Status.NOT_FOUND).entity(errorMessge).build();
		
//		  if(messages.get(messageId)==null)
//		  {
//			  throw new WebApplicationException(reponse);
//		  }
		//  System.out.println(messages.get(messageId).getCommentMap().get(commentId));
		  if(messages.get(messageId).getCommentMap().get(commentId)==null)
		  {
			  throw new NotFoundException(reponse);
		  }
		  return messages.get(messageId).getCommentMap().get(commentId);
	  }
	  public Comment remove(long messageId,long commentId)
	  {
		  messages.get(messageId).getCommentMap().remove(commentId);
		 return comments.remove(commentId);
	  }
	  public Comment update(long messageId ,Comment comment)
	  {
		  if(comment.getId()<=0)
		  {
			  return null;
		  }
		  comments.put(comment.getId(), comment);
		  messages.get(messageId).getCommentMap().put(comment.getId(), comment);
		  return comment;
	  }	
}
