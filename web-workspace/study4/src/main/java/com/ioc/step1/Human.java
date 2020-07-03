package com.ioc.step1;

public class Human {
	private IPhone phone;
	private String user;
	
	public Human(String user , IPhone phone) {
		this.phone = phone;
		this.user = user;
	}
	
//	초기화
	public void myInit() {
		System.out.println("세상에 태어남");
	}
//	
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
