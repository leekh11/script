package com.ioc.step2;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SamsungPhone implements IPhone {
//	@Autowired
//	@Qualifier("add")
	@Value("#{add}")
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
