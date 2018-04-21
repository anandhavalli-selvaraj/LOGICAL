package org.spring.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanPPApp {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring8.xml");
		//Point point1=context.getBean();
		Triangle tri=(Triangle) context.getBean("triangle");
		tri.draw();

	}

}
