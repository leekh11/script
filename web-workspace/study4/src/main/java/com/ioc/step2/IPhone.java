package com.ioc.step2;

import java.util.Map;

public interface IPhone {
	void call();
	void info();
	void setAddress(Map<String, String> address);
	String getAddressName(String tel);
}
