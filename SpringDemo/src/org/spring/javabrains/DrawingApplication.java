package org.spring.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
	// BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring3.xml");
		//Point point1=context.getBean();
		TriangleApplicationContextAware tri=(TriangleApplicationContextAware) context.getBean("triangle");
		tri.draw();
	}

}
