package com.oop.asg;
//手机类
public abstract class Handset {
	// 属性：品牌、型号
	private String brand;
	private String type;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	// 方法：发消息、打电话、信息
	public abstract void sendInfo();
	public abstract void call();
	public abstract void info();
}
