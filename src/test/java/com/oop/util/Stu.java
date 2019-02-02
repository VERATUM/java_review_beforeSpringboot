package com.oop.util;

public class Stu {
	// 学号
	public int xuehao;
	// 姓名
	public String name;
	// 年龄
	public int age;
	// 性别
	public String gender;
	
	@Override
	public String toString() {
		return "Student [xuehao=" + xuehao + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	public Stu(int xuehao, String name, int age, String gender) {
		super();
		this.xuehao = xuehao;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Stu() {
		super();
	}
}
