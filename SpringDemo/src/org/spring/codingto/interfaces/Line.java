package org.spring.codingto.interfaces;

import org.spring.javabrains.Point;

public class Line implements Shape{
	private Point pointA;
	private Point pointB;
	@Override
	public void draw() {
		System.out.println(toString());
		
	}
	public Point getPointA() {
		return pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	@Override
	public String toString() {
		return "Line [pointA=" + pointA + ", pointB=" + pointB + "]";
	}

}
