package org.spring.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object obj, String beanName)
			throws BeansException {
		System.out.println("In After Initialization method. Bean Name is  "+beanName);
		return obj ;
	}

	@Override
	public Object postProcessBeforeInitialization(Object obj, String beanName)
			throws BeansException {
		System.out.println("In Before Initialization method. Bean Name is  "+beanName);
		return obj;
	}

	

}
