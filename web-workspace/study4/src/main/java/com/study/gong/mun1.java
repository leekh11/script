package com.study.gong;

public class mun1 {
	public static void main(String[] args) {
		String[] numArr = {"1","2","3","4","5","6","7","8","9","10"};
		
		int sum = 0;
		for (String arr : numArr) {
			int i = Integer.parseInt(arr);
			if(i%2 != 1) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}

 
 
 
 
 
 
 
 
 
 
 

