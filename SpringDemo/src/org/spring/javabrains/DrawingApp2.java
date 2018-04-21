package org.spring.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp2 {

	public static void main(String[] args) {
	// BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context=new ClassPathXmlApplicationContext("spring5.xml");
		//Point point1=context.getBean();
		TriangleList tri=(TriangleList) context.getBean("triangle1");
		tri.draw();
	}

}
