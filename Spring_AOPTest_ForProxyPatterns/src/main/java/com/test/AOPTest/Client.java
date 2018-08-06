package com.test.AOPTest;

import org.aspectj.lang.reflect.Advice;
import org.aspectj.weaver.AjAttribute.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = null;
		context = new AnnotationConfigApplicationContext(AdditionAspect.class);

		
		
		Addition addition = (Addition) context.getBean(Addition.class);
		
		System.out.println("proxy class:"+addition.getClass().getName());
		
//        Aspect aspect; 
		Advice advice;
		
		
		System.out.println(addition.add(10, 20));
		System.out.println(addition.sub(50, 20));

		((AbstractApplicationContext) context).close();
	}
}
