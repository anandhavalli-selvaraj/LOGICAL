package org.anandh.javabrains.messengerapp.database;

import java.util.HashMap;
import java.util.Map;

import org.anandh.javabrains.messengerapp.model.Comment;
import org.anandh.javabrains.messengerapp.model.Message;
import org.anandh.javabrains.messengerapp.model.Profile;

public class DataBaseClass {
	private static Map<Long,Message>messages=new HashMap<>();
	private static Map<Long,Comment>comments=new HashMap<>();
	
	private static Map<String,Profile>profiles=new HashMap<>();
	public static Map<Long,Message> getAllMessages()
	{
		return messages;
		
	}
	public static Map<Long, Comment> getAllComments()
	{
		return comments;
		
	}
	public static Map<String,Profile> getAllProfiles()
	{
		return profiles;
		
	}
}
