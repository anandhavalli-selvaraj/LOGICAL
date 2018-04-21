package org.spring.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TriangleApplicationContextAware implements ApplicationContextAware,BeanNameAware {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context=null;
	public TriangleApplicationContextAware(Point pointA, Point pointB,
			Point pointC) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}
	private String beanName;
	public Point getPointA() {
		return pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	public void draw()
	 {
		System.out.println(toString());
		 
	 }
	@Override
	public String toString() {
		return "Triangle [pointA=" + pointA + ", pointB=" + pointB
				+ ", pointC=" + pointC + "]";
	}@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		
		this.context=context;
	}
	@Override
	public void setBeanName(String beanName) {
		this.beanName=beanName;
		System.out.println(beanName);
	}

}
