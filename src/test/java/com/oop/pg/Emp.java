package com.oop.pg;

public class Emp extends Person{
	// 属性：工号
	private int gh;
	// 封装:对私有属性就行赋值与取值
	public int getGh() {
		return gh;
	}

	public void setGh(int gh) {
		this.gh = gh;
	}

	@Override
	public String toString() {
		return "emp [name = "+this.getName()+",age = "+this.getAge()+",gh = "+this.gh+"]";
	}
	public static void main(String[] args) {
		Emp emp = new Emp();
		emp.setAge(25);
		emp.setGh(101);
		emp.setName("emp");
		System.out.println(emp);
	}
}
