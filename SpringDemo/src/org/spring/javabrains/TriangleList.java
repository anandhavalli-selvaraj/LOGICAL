package org.spring.javabrains;

import java.util.List;

public class TriangleList {
private List<Point>points;

public List<Point> getPoints() {
	return points;
}

public void setPoints(List<Point> points) {
	this.points = points;
}
public void draw()
{
	System.out.println(toString());
	 
}

@Override
public String toString() {
	return "TriangleList [points=" + points + "]";
}
}
