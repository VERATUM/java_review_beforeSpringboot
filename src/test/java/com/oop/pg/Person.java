package com.oop.pg;

public class Person {
	// 属性：姓名、年龄
	private String name;
	private int age;
	// 封装
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// 构造方法
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	// 默认构造
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
