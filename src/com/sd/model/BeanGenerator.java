package com.sd.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanGenerator {
	
	public ApplicationContext getApplication(){
		ApplicationContext factory = new ClassPathXmlApplicationContext("SpringBeanConfiguration.xml");
		return factory;
	}

}
