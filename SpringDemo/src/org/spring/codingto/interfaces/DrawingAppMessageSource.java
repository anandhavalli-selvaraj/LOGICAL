package org.spring.codingto.interfaces;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingAppMessageSource {

	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("messagesourceautowired.xml");
		context.registerShutdownHook();
		Shape sh=(Shape) context.getBean("circle");
		sh.draw();
		//System.out.println(context.getMessage("greeting", null, "Default Greeting", null));

	}

}
