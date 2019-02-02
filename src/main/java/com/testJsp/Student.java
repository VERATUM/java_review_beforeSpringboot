package com.testJsp;
/**
 * 学生实体类
 * @author Administrator
 */
public class Student {
	/**
	 * 属性:学号xh，姓名name，年龄age，电话tel
	 */
	private int xh;
	private String name;
	private int age;
	private String tel;
	public int getXh() {
		return xh;
	}
	public void setXh(int xh) {
		this.xh = xh;
	}
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
