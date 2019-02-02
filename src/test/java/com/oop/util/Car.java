package com.oop.util;

public class Car {
	// 定义属性：品牌、颜色、价格
	public String brand;
	public String color;
	public int price;
	
	// 定义方法：行驶、加速
	public void run() {
		System.out.println("车辆正在行驶中");
	}
	public void accelerate() {
		System.out.println("车辆正在加速中");
	}
	public void show() {
		// this关键字代表当前对象
		System.out.println("the car's brand is "+this.brand);
		System.out.println("the car's brand is "+this.color);
		System.out.println("the car's brand is "+this.price);
	}
}
