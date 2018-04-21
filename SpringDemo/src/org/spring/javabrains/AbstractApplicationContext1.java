package org.spring.javabrains;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AbstractApplicationContext1 {

	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring4.xml");
		context.registerShutdownHook();
		TriangleAAC tri=(TriangleAAC) context.getBean("triangle");
		tri.draw();
	}

}
