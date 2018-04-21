package org.spring.codingto.interfaces;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplicationAnnotation {

	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("springcomponent.xml");
		context.registerShutdownHook();
		Shape sh=(Shape) context.getBean("circleComponentAnnotation");
		sh.draw();
	}

}
