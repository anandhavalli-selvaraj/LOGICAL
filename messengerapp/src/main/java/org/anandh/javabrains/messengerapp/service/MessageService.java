package org.anandh.javabrains.messengerapp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.anandh.javabrains.messengerapp.database.DataBaseClass;
import org.anandh.javabrains.messengerapp.exceptions.DataNotFoundException;
import org.anandh.javabrains.messengerapp.model.Message;

public class MessageService {

	
	private Map<Long,Message>messages=DataBaseClass.getAllMessages();

	public MessageService() {
		  Message m1=new Message(1L, "Hello World", new Date(),"Anandh");
		  messages.put(m1.getId(),m1);
		  Message m2=new Message(2L, "Hello World", new Date(),"Anandh");
		  
		  messages.put(2L,m2);
	}
	
//	  public List<Message> getAllMessages()
//	  {
//		  List<Message>messageList=new ArrayList<>();
//		  Message m1=new Message(1L, "Hello World", new Date(),"Anandh");
//		  messageList.add(m1);
//		  messageList.add(m1);
//		  return messageList;
//	  }
	
	public List<Message> getAllMessagesForYear(int year)
	{
		List<Message>messageList=new ArrayList<Message>();
		Calendar calendar=Calendar.getInstance();
		for(Message message:messages.values())
		{
			calendar.setTime(message.getDate());
			if(calendar.get(Calendar.YEAR)==year)
			{
				messageList.add(message);
			}
		}
		return messageList;
	}
	public List<Message> getAllMessagesPagination(int index,int limit)
	{
		List<Message>messageList=new ArrayList<>(messages.values());
		if(index+limit>messages.values().size())
		{
			return new ArrayList<>();
		}
		return messageList.subList(index, index+limit);
	}
			
	public List<Message> getAllMessages()
	  {
		return new ArrayList<>(messages.values());
	  }
	public Message addMessage(Message message)
	  {
			message.setId(messages.size()+1);
			messages.put(message.getId(), message);
		  return message;
	  }
	  public Message getMessage(long id)
	  {
		  Message messageResponse= messages.get(id);  
		  if(messageResponse==null)
		  {
			  throw new DataNotFoundException("The Message with ID "+id +" not found.");
		  }
		  return messageResponse;
	  }
	  public Message remove(long id)
	  {
		 return messages.remove(id);
	  }
	  public Message update(Message message)
	  {
		  if(message.getId()<=0)
		  {
			  return null;
		  }
		  messages.put(message.getId(), message);
		  return message;
	  }
}
