package io.javabrains.unit3;

public class MethodReferenceExample {

	public static void printMessage()
	{
		System.out.println("Hello");
	}
	public static void main(String[] args) {
	Thread t1=new Thread(()->printMessage());
	t1.start();
	Thread t2=new Thread(MethodReferenceExample::printMessage);
	t2.start();

	}

}
