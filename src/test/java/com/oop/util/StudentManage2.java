package com.oop.util;

import java.util.Scanner;

public class StudentManage2 {
	// properties
	Scanner input = new Scanner(System.in);
	public Student[] students = new Student[10];
	public int pos = 0;
	// remember one technique to one function;
	// way-display the first menu
	public void firstMenu() {
		System.out.println("Welcome to the Student Manager System!");
		System.out.println("1.Add student\n2.Query someone of students\n3.General services\n4.Exit");
		System.out.print("Please select the founctoin:");
		int number = input.nextInt();
		System.out.println();
		switch (number) {
			case 1:
				System.out.println("Welcome to use Add student");
				this.addStudent();
				break;
			case 2:
				System.out.println("Welcome to use Query someone of students:");
				this.secondMenu();
				break;
			case 3:
				System.out.println("Welcome to use General services:");
				this.thirdMenu();
				break;
			case 4:
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
	// way-display the third menu
	public 	void thirdMenu() {
		System.out.println("1.Deal with absence from school\n2.Deal with resuming study\n3.Return to second menu");
		System.out.print("Please select the service you need:");
		int number = input.nextInt();
		System.out.println();
		switch (number) {
			case 1:
				System.out.println("Welcome to Deal with absence from school");
				this.absenceFromSchool();
				break;
			case 2:
				System.out.println("Welcome to Deal with resuming study");
				this.resumingStudy();
				break;
			case 3:
				System.out.println("Return to second menu");
				this.secondMenu();
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
				students[i].show();
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
				students[i].show();
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
	// way-absence from school
	public void absenceFromSchool() {
		System.out.print("Please enter the card No. of student:");
		int inputNo = input.nextInt();
		for (int i = 0; i < students.length; i++) {
			if (students[i] !=null && inputNo == students[i].cardNo) {
				students[i].state = 0;
				students[i].show();
			}
		}
		System.out.println("Success to deal with absence from school");
		System.out.println("Return to third menu");
		this.thirdMenu();
	}
	// way-resuming study
	public void resumingStudy() {
		System.out.print("Please enter the card No. of student:");
		int inputNo = input.nextInt();
		for (int i = 0; i < students.length; i++) {
			if (students[i] !=null && inputNo == students[i].cardNo) {
				students[i].state = 1;
				students[i].show();
			}
		}
		System.out.println("Success to deal with resuming study");
		System.out.println("Return to third menu");
		this.thirdMenu();
	}
}
