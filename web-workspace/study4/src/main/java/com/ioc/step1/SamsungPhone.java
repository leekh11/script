package com.ioc.step1;

import java.util.Map;

public class SamsungPhone implements IPhone {

	private Map<String,String> address;
	
	@Override
	public void call() {
		System.out.println("[삼성폰]전화왔어요");
	}

	@Override
	public void info() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~기기정보 : 갤럭시 S9~~~~~");
		System.out.println("~~~~~~~~버전 : 56.90~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void setAddress(Map<String, String> address) {
		this.address = address;
	}

	@Override
	public String getAddressName(String tel) {
		if(address.containsKey(tel)) {
			return address.get(tel);
		}
		return null;
	}

}
