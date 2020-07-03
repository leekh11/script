package com.ioc.step1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
//		Human man = new Human();
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring/di/step1.xml");
		Human man = context.getBean("man2", Human.class);
		Human man2 = context.getBean("man2", Human.class);
		Human man3 = context.getBean("man2", Human.class);
		man.myPhone();
		man.calling("042-719-8850");
		System.out.println(man.getUser());
		System.out.println("man : " + man.hashCode());
		System.out.println("man2 : " + man2.hashCode());
		System.out.println("man3 : " + man3.hashCode());
		
		context.close();
	}
}
