package com.io;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


// 学生的姓名管理系统类
public class NameOfStudentManageSystem {
	Scanner input = new Scanner(System.in);
	private String sys = System.getProperty("user.dir");
	String path = sys+"/src/main/webapp/testFile/tio9.txt";
	public void menu() {
		System.out.println("欢迎来到学生姓名管理系统");
		System.out.println("*** *** *** *** *** ***");
		System.out.println("1.保存姓名(写入文件)\n2.读取所有学生姓名(读文件)");
		System.out.println("*** *** *** *** *** ***");
		System.out.print("请选择功能:");
		String str =input.next();
		switch (str) {
			case "1":
				System.out.println(">>保存姓名(写入文件)");
				this.save();
				this.menu();
				break;
			case "2":
				System.out.println(">>读取所有学生姓名(读文件)");
				this.read();
				this.menu();
				break;
			default:
				System.out.println("输入数字有误,请重新输入");
				this.menu();
				break;
		}
	}
	public void save() {
		try {
			FileOutputStream file = new FileOutputStream(path,true);
			System.out.print("请输入学生姓名:");
			String name = input.next();
			file.write(name.getBytes());
			System.out.println("写入成功！是否继续输入？");
			file.write('\n');
			System.out.print("输入y继续，其他任意键返回主菜单:");
			String ans = input.next();
			if (ans.equals("y"))
				this.save();
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void read() {
		try {
			FileInputStream fis = new FileInputStream(path);
			byte[] bs = new byte[fis.available()];
			fis.read(bs);
			String str = new String(bs);
			String[] names = str.split("\n");
			System.out.println("序号\t姓名");
			for (int i = 0; i < names.length; i++) {
				System.out.println((i+1)+"\t"+names[i]);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
