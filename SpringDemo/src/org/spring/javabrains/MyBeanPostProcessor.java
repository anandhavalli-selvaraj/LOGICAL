package org.spring.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanPostProcessor {

	public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("spring7.xml");
	TriangleLifeCycle tri=(TriangleLifeCycle) context.getBean("triangle");
	tri.draw();
	}

}
