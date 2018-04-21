package org.spring.codingto.interfaces;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.spring.javabrains.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class CircleMessageSource implements Shape  {

	private Point center;
	
	@Autowired
	private MessageSource messageSource;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	@Override
	public void draw() {
		
		//System.out.println("The Circle is drawn");
		System.out.println(this.messageSource.getMessage("drawing.circle",null, "Default Circle drawn", null));
		System.out.println(this.messageSource.getMessage("drawing.point",new Object[]{center.getX(),center.getY()}, "Default Line drawn", null));

	}
	public Point getCenter() {
		return center;
	}
//	
	@Resource()
	public void setCenter(Point center) {
		this.center = center;
	}
	@Override
	public String toString() {
		return "Circle [center=" + center + "]";
	}
	@PostConstruct
	public void initialization()
	{
		System.out.println("Initializtaion of circle ");
	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("Destroying the circle Bean ");
	}
	
}
