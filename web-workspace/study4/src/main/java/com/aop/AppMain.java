package com.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/aop/aop2.xml");

		TargetObject t = context.getBean("mytarget", TargetObject.class);
		int res = t.add(15,  35);
		System.out.println("res = " + res);		
		context.close();
		
	}
	
}