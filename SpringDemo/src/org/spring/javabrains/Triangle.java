package org.spring.javabrains;



public class Triangle  {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	public Triangle()
	{
		
	}
	public Triangle(Point pointA, Point pointB, Point pointC) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}
	public void draw()
	{
		System.out.println(toString());

	}
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
	/*public void myInit()
	{
		System.out.println("Initializing  My init method called for  triangle");
		
	}
	public void myDisposable()
	{
		System.out.println("My Disposable method called for triangle");
	}*/
	@Override
	public String toString() {
		return "Triangle [pointA=" + pointA + ", pointB=" + pointB
				+ ", pointC=" + pointC + "]";
	}
	/*@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing  init method called for  triangle");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying the Bean ");
	}*/
	
}
