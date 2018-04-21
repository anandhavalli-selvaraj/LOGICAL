package org.spring.javabrains;

public class SetterAndConstructorDependencyInjectionTriangle {
	private String type;
	private int height;
	
//	public void setHeight(int height) {
//		this.height = height;
//	}
	public SetterAndConstructorDependencyInjectionTriangle(int height)
	{
		this.height=height;
	}
	public SetterAndConstructorDependencyInjectionTriangle(String type)
	{
		this.type=type;
	}
	public SetterAndConstructorDependencyInjectionTriangle(String type,int height)
	{
		this.type=type;
		this.height=height;
	}
	public String getType() {
		return type;
	}
	public int getHeight() {
		return height;
	}
//	public void setType(String type) {
//		this.type = type;
//	}
 public void draw()
 {
	 System.out.println(getType()+" Triangle drawn "+ getHeight());
	 
 }


}
