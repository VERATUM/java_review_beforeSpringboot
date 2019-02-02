package com.oop.util;

public class Student {
	// Property
	public int cardNo;
	public String name;
	public int age;
	public String gender;
	public int state = 1; // 1-在读；0-休学
	
	// 方法show:显示学生的基本信息
	public void show() {
		//三元表达式(state == 1?"在读":"休学")-等同于if-else判断
		System.out.println("学号\tName\tAge\tgender\t状态");
		System.out.println(this.cardNo+"\t"+this.name+"\t"+this.age+"\t"+this.gender+"\t"+(this.state == 1?"At school":"Absence from school"));
	}
}
