package com.collection;
//商品类
public class Product {
	// 属性：编号、名称、单价、数量
	private String serial;
	private String name;
	private double price;
	private int number;
	//
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	// 初始化
	public Product(String serial, String name, double price, int number) {
		super();
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.number = number;
	}
	public Product() {
		super();
	}
	// 
	public void show() {
		System.out.println("商品基本信息");
		System.out.println("编号:"+this.serial+",名称:"+this.name+",价格:"+this.price+",数量:"+this.number);
		System.out.println("--- --- --- --- --- ---");
	}
}

