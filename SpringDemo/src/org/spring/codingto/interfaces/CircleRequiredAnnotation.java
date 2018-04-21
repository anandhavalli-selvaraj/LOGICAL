package org.spring.codingto.interfaces;

import org.spring.javabrains.Point;
import org.springframework.beans.factory.annotation.Required;

public class CircleRequiredAnnotation implements Shape {

	private Point center;
	@Override
	public void draw() {
		System.out.println("Circle (x "+center.getX()+" ) y "+center.getY());

	}
	public Point getCenter() {
		return center;
	}
	@Required
	public void setCenter(Point center) {
		this.center = center;
	}
	@Override
	public String toString() {
		return "Circle [center=" + center + "]";
	}

}
