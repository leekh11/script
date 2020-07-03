package com.ioc.step2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
//		Human man = new Human();
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring/di/step2.xml");
		Human man = context.getBean("human", Human.class);
		man.myPhone();
		man.calling("042-719-8850");
		System.out.println(man.getUser());
		System.out.println("man : " + man.hashCode());
		
		context.close();
	}
}
