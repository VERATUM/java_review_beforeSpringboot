package com.oop.util;

public class Product {
	// 属性
	// 商品id
	public int id;
	// 商品名称
	public String name;
	// 商品单价
	public double price;
	
	// 方法
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	// 计算
	public double calculator(double num1, String flag, double num2) {
		double res = 0;
		switch (flag) {
			case "+":
				res = num1 + num2;
				break;
			case "-":
				res = num1 - num2;
				break;
			case "*":
				res = num1 * num2;
				break;
			case "/":
				if (num2!=0)
					res = num1 / num2;
				else
					System.out.println("输入有误，除数不能为0");
				break;
			default:
				System.out.println("请输入正确的符号");
				break;
		}
		return res;
	}

}
