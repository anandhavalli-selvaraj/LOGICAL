package org.spring.codingto.interfaces;

import org.spring.javabrains.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CircleAutowiredAnnotation implements Shape{
	private Point center;
	@Override
	public void draw() {
		System.out.println("The Circle is drawn");
		System.out.println("Circle (x,y) = ("+center.getX()+","+center.getY()+")");

	}
	public Point getCenter() {
		return center;
	}
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}
	@Override
	public String toString() {
		return "Circle [center=" + center + "]";
	}
}
