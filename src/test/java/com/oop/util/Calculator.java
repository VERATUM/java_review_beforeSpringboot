package com.oop.util;
/**
 * 计算器
 */
public class Calculator {
	// 定义两个相加的数
	public double number1;
	public double number2;
	// 运算符
	public String operator;
	
	// 方法
	public void show() {
		switch(operator) {
			case "+":
				System.out.println("结果是:"+(number1+number2));
				break;
			case "-":
				System.out.println("结果是:"+(number1-number2));
				break;
			case "*":
				System.out.println("结果是:"+(number1*number2));
				break;
			case "/":
				if (number2!=0) {
					System.out.println("结果是:"+(number1/number2));
				} else {
					System.out.println("除数不能为0");
				}
				break;
			default:
				System.out.println("您的输入符号有误");
				break;
		}
	}
}
