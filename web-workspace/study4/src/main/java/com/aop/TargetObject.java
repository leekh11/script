package com.aop;

import org.springframework.stereotype.Component;

@Component("mytarget")
public class TargetObject {
	public int add(int a, int b) {
		return a+b;
	}

	
}