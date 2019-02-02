package com.oop.util;

import java.util.Scanner;

public class StudentManage {
	// properties
	Scanner input = new Scanner(System.in);
	public Student[] students = new Student[10];
	public int pos = 0;
	// remember one technique to one function;
	// way-display the first menu
	public void firstMenu() {
		System.out.println("Welcome to the Student Manager System!");
		System.out.println("1.Add student\n2.Query someone of students\n3.Exit");
		System.out.print("Please select the founctoin:");
		int number = input.nextInt();
		System.out.println();
		switch (number) {
			case 1:
				System.out.println("add student");
				this.addStudent();
				break;
			case 2:
				this.secondMenu();
				break;
			case 3:
				// exit first menu
				System.exit(1);
				break;
			default:
				System.out.println("Input is wrong, please enter the exact number");
				break;
			}
	}
	// way-display the second menu
	public void secondMenu() {
		System.out.println("Welcome to use the Quary student:");
		System.out.println("1.Display all students\n2.Search student\n3.Return to first menu");
		System.out.print("Please select the founctoin:");
		int number = input.nextInt();
		System.out.println();
		switch (number) {
			case 1:
				System.out.println("Display all students");
				this.display();
				break;
			case 2:
				System.out.println("Search student");
				this.query();
				break;
			case 3:
				this.firstMenu();
				break;
			default:
				break;
			}
	}
	// way-add student 
	public void addStudent() {
		if (pos ==10) {
			System.out.println("Students are full");
		}else {
			Student student = new Student();
			System.out.println("input student's information");
			System.out.print("input student's card NO.:");
			student.cardNo = input.nextInt();
			System.out.print("input student's name:");
			student.name = input.next();
			System.out.print("input student's age:");
			student.age = input.nextInt();
			System.out.print("input student's gender:");
			student.gender = input.next();
			students[pos] = student;
			pos++;
		}
		System.out.println("Want to continue?(y-continue|other key-back to first menu)");
		String ans = input.next();
		if (ans.equals("y")) {
			this.addStudent();
		}else {
			this.firstMenu();
		}
	}
	// way-display all students
	public void display() {
		// count the numbers of students
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				System.out.println("学号\t姓名\t年龄\t性别\t状态");
				System.out.println(students[i].cardNo+"\t"+students[i].name+"\t"+students[i].age+
						"\t"+students[i].gender+"\t"+(students[i].state == 1?"在读":"休学"));
				count++;
			}
		}
		if (count ==0)
			System.out.println("You hasn't to add any one student");
		else
			System.out.println("display all over, the total is:"+count);
		System.out.println("Wanna continue:(y-second menu|other key-first menu)");
		String ans = input.next();
		if (ans.equals("y"))
			this.secondMenu();
		else
			this.firstMenu();
	}
	// way-Query someone of students
	public void query() {
		// count the numbers of students
		System.out.print("Please enter your search name:");
		String inputName = input.next();
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].name.equals(inputName)) {
				System.out.println("学号\t姓名\t年龄\t性别\t状态");
				System.out.println(students[i].cardNo+"\t"+students[i].name+"\t"+students[i].age+
						"\t"+students[i].gender+"\t"+(students[i].state == 1?"在读":"休学"));
				count++;
			}
		}
		if (count ==0)
			System.out.println("There is no one student's name you've inputted");
		else
			System.out.println("display all over");
		System.out.println("Wanna continue:(y-second menu|other key-first menu)");
		String ans = input.next();
		if (ans.equals("y"))
			this.secondMenu();
		else
			this.firstMenu();
	}
}
