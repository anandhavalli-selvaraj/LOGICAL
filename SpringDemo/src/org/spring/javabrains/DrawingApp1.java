package org.spring.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp1 {

	public static void main(String[] args) {
	// BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context=new ClassPathXmlApplicationContext("spring4.xml");
		//Point point1=context.getBean();
		TriangleAAC tri=(TriangleAAC) context.getBean("triangle1");
		tri.draw();
	}

}
