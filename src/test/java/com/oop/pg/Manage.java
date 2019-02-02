package com.oop.pg;

import java.util.Scanner;

public class Manage {
	//
	Scanner input = new Scanner(System.in);
	Person[] personList = new Person[10];
	// 存储位置
	private int pos;
	// 状态显示
	private int flag =0;
	// 方法
	public void menu() {
		System.out.println("欢迎来到人员管理系统：");
		System.out.println("1.添加人员\n2.查询人员信息\n3.退出");
		System.out.println("请输入所需功能：(选择数字)");
		int number = input.nextInt();
		switch (number) {
			case 1:
				System.out.println("添加人员：");
				this.addPerson();
				System.out.println("添加人员成功");
				this.menu();
				break;
			case 2:
				System.out.println("查询人员信息:");
				this.show();
				this.menu();
				break;
			case 3:
				System.out.println("谢谢使用人员管理系统，欢迎下次使用");
				System.exit(1);
				break;
			default:
				System.out.println("输入数字有误，请输入正确的数字");
				this.menu();
				break;
		}
	}
	public void addPerson() {
		System.out.println("请选择输入人员的职称：\n1.学生\n2.员工");
		System.out.println("您选择的是：");
		int number1 = input.nextInt();
		switch (number1) {
			case 1:
				System.out.println("您选择添加类型是学生");
				this.addStudent();
				flag =1;
			break;
			case 2:
				System.out.println("您选择添加类型是员工");
				addEmployee();
				flag =1;
			break;
			default:
				System.out.println("输入数字有误，请输入提示的数字");
				break;
		}
	}
	public void addStudent() {
		StudentInfo stu = new StudentInfo();
		System.out.print("请输入姓名：");
		stu.setName(input.next());
		System.out.print("请输入年龄:");
		stu.setAge(input.nextInt());
		System.out.print("请输入学号：");
		stu.setCardNo(input.next());
		// 赋值
		personList[pos]=stu;
		pos++;
	}
	public void addEmployee() {
		Emp employee = new Emp();
		System.out.print("请输入姓名：");
		employee.setName(input.next());
		System.out.print("请输入年龄:");
		employee.setAge(input.nextInt());
		System.out.print("请输入工号：");
		employee.setGh(input.nextInt());
		// 赋值
		personList[pos]=employee;
		pos++;
	}
	public void show() {
		if (flag ==1) {
			for (int i = 0; i < personList.length; i++) {
				if (personList[i] !=null) {
					System.out.println(personList[i]);
					System.out.println("--- --- ---");
				}
			}
		}else {
			System.out.println("还没添加任何人物，请添加...");
		}
	}
}
