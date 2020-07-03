package com.ioc.step2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//@Component = @Service, @Controller, @Rspository, // @Bean
@Component // 이름이 없으면 클래스명
public class Human {
	
	//@Autowire[스프링] ,@Resource, @Inject [표준]  , @Value
	
	@Autowired
	private IPhone phone;
	@Value("밀키스")
	private String user;
	
	@PostConstruct
	public void myInit() {
		System.out.println("세상에 태어남");
	}

	@PreDestroy
	public void myDestroy() {
		System.out.println("하늘나라로");
	}
	
	public void calling(String tel) {
		System.out.println(phone.getAddressName(tel)+ "님 연락왔어요!");
	}
	
	public String getUser() {
		return user;
	}
	
	public void myPhone() {
		phone.info();
	}
	
	
}
