package com.oop.pg;

public class StudentEx extends StudentInfo {
	
	public static void main(String[] args) {
		StudentEx sEx = new StudentEx();
		sEx.setCardNo("s101");
		sEx.setName("kkl");
		System.out.println(sEx);
		System.out.println(sEx.getName());
	}
}
