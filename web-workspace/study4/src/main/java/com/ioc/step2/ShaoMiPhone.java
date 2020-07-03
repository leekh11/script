package com.ioc.step2;

import java.util.Map;

public class ShaoMiPhone implements IPhone {
	
	private Map<String,String> address;

	@Override
	public void call() {
		System.out.println("[샤오미]전화왔어요");
	}

	@Override
	public void info() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~기기정보 : 샤오미 S9~~~~~");
		System.out.println("~~~~~~~~버전 : 12.00~~~~~~~~~");
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
