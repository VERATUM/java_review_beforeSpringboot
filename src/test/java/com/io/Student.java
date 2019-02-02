package com.io;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 实现序列化,进行文件流与对象的数据交互
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String age;
	private String gender;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	public Student() {
		super();
	}
	public Student(String name, String age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
