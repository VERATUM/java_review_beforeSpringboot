package com.oop.pg;

public class StudentInfo extends Person {
	private String cardNo;
	private String name;
	
	@Override
	public String toString() {
		return "StudentInfo [cardNo=" + cardNo + ", name=" + name + ", age=" + this.getAge() + "]";
	}
	
	public StudentInfo(String cardNo, String name) {
		super();
		this.cardNo = cardNo;
		this.name = name;
	}
	
	public StudentInfo() {
		super();
	}

	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
