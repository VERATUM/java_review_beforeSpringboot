package com.oop.test;

import java.util.Scanner;

import org.junit.Test;

import com.oop.util.Calculator;
import com.oop.util.Car;
import com.oop.util.Computer;
import com.oop.util.MathAreas;
import com.oop.util.Product;
import com.oop.util.Stu;
import com.oop.util.StudentManage;
import com.oop.util.StudentManage2;
import com.oop.util.Sum;

public class TestOOP {
	
	@Test
	public void t1() {
		MathAreas m = new MathAreas();
		m.r = 2.0;
		m.outputAreas();
	}
	@Test
	public void t2() {
		Calculator c = new Calculator();
		c.number1 = 10;
		c.number2 = 15.0;
		c.operator = "+";
		c.show();
	}
	@Test
	public void t3() {
		// 引用Computer
		Computer computer = new Computer();
		computer.computermodel = "GE5S 笔记本电脑";
		computer.operatingsystem = "window 10 64位";
		computer.processor = "英特尔 Core i7-6700HQ @ 2.60GHz 四核";
		computer.mainboard = "英特尔 SKYBAY";
		computer.memory = "8 GB ( 三星 DDR4 2133MHz )";
		computer.harddrive = "建兴 CV3-8D128 ( 128 GB / 固态硬盘 )";
		computer.videocard = "Nvidia GeForce GTX 1060 ( 6 GB )";
		computer.display = "京东方 BOE06A9 ( 15.3 英寸  )";
		computer.soundcard = "瑞昱 ALC269 @ 英特尔 High Definition Audio 控制器";
		computer.networkcard = "瑞昱 RTL8168/8111/8112 Gigabit Ethernet Controller / 10251D05";
		computer.show();
	}
	@Test
	public void t4() {
		// 使用Car类
		// 使用类
		// 创建对象
		Car car1 = new Car();
		car1.brand = "Porsche";
		car1.color = "red";
		car1.price = 150;
		System.out.println("the car's brand is "+car1.brand);
		System.out.println("the car's color is "+car1.color);
		System.out.println("the car's price is "+car1.price);
		// 使用方法
		car1.run();
		car1.accelerate();
		car1.show();
	}
	@Test
	public void t5() {
		Stu student = new Stu(101,"ver",20,"male");
		System.out.println(student);
		
		Stu student2 = new Stu();
		student2.name = "JoJo";
		student2.age = 18;
		System.out.println(student2);
	}
	@Test
	public void t6() {
		// 添加商品信息
		Product []ps = new Product[3];
		Scanner input =new Scanner(System.in);
		
		for (int i = 0; i < ps.length; i++) {
			Product p = new Product();
			System.out.println("请输入第"+(i+1)+"个商品");
			System.out.print("请输入商品的id：");
			p.id = input.nextInt();
			System.out.print("请输入商品的名称：");
			p.name = input.next();
			System.out.print("请输入商品的单价：");
			p.price = input.nextDouble();
			ps[i] = p;
		}
		// 查看所有商品信息
		for (int i = 0; i < ps.length; i++) {
			System.out.println("第"+(i+1)+"个商品");
			System.out.println(ps[i]);
		}
		input.close();
	}
	@Test
	public void t7() {
		// 计算器方法的调用
		Scanner input = new Scanner(System.in);
		Product p = new Product();
		// 继续确认
		String str;
		do {
			System.out.print("请输入第一数:");
			double a = input.nextDouble();
			System.out.print("请输入运算符:");
			String flag = input.next();
			System.out.print("请输入第二个数:");
			double b = input.nextDouble();
			double s = p.calculator(a, flag, b);
			System.out.println(s);
			System.out.println("继续吗？y|任意键退出");
			str = input.next();
			if ("y".equals(str)) {
				System.out.println(">>继续");
			} else {
				System.out.println(">>结束");
			}
		} while(str.equals("y"));
		input.close();
	}
	@Test
	public void t8() {
		Sum s = new Sum();
		int out = s.out(1, 10);
		System.out.println(out);
		System.out.println("----- -----");
		int out1 = s.out1(10, 1);
		System.out.println(out1);
		StudentManage sm = new StudentManage();
		sm.firstMenu();
	}
	@Test
	public void t9() {
		StudentManage2 sm2 = new StudentManage2();
		sm2.firstMenu();
	}
}
