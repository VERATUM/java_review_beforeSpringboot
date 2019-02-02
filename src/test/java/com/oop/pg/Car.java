package com.oop.pg;

public class Car extends Bus {
	//
	private String brand;
	//
	public Car(String brand) {
		this.brand = brand;
		super.setName("轿车");
	}
	public Car() {}
	//
	public void show() {
		System.out.println("车类型是："+super.getName());
		if (brand.equals("宝马")) {
			System.out.println("车品牌是："+brand);
			System.out.println("费用是"+20+"元");
		}else {
			System.out.println("车品牌是："+brand);
			System.out.println("费用是"+15+"元");
		}
		System.out.println();
	}
}
