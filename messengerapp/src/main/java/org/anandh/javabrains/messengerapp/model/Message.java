package org.anandh.javabrains.messengerapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date date;
	private String author;
	private Map<Long,Comment>commentMap=new HashMap<>();
	private List<Link>links=new ArrayList<>();
	
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public Message() {
		
	}
	public Message(long id,String message, Date date,  String author) {
		this.message = message;
		this.date = date;
		this.id = id;
		this.author = author;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlTransient
	public Map<Long,Comment> getCommentMap()
	{
		return commentMap;
	}
	public void setCommentMap(Map<Long,Comment>commentMap)
	{
		this.commentMap=commentMap;
	}
	public void addLink(String url,String rel)
	{
		Link link=new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
		
	}
	}
