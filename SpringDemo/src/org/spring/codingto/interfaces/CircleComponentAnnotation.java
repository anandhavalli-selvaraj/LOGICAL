package org.spring.codingto.interfaces;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.spring.javabrains.Point;
import org.springframework.stereotype.Service;
//@Component I can declare either component or service spring gonna registers the bean in the container
@Service
public class CircleComponentAnnotation implements Shape  {

	private Point center;
	@Override
	public void draw() {
		System.out.println("The Circle is drawn");
		System.out.println("Circle (x,y) = ("+center.getX()+","+center.getY()+")");
}
	public Point getCenter() {
		return center;
	}
//	@Resource(name="point1")
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
