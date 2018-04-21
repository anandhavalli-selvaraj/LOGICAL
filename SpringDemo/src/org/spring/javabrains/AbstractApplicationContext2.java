package org.spring.javabrains;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AbstractApplicationContext2 {

	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring6.xml");
		context.registerShutdownHook();
		TriangleLifeCycle tri=(TriangleLifeCycle) context.getBean("triangle");
		tri.draw();

	}

}
