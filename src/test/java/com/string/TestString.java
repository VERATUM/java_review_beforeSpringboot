package com.string;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestString {
	Scanner input;
	@Before
	public void before() {
		input = new Scanner(System.in);
	}
	@Test
	public void ts() {
		// equals and equalsIgnoreCase
		System.out.print("请输入用户名：");
		String username = input.next();
		System.out.print("请输入密码：");
		String password = input.next();
		if (username.equalsIgnoreCase("admin") && password.equals("123")) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
		
		// indexOf
		System.out.println("请输入邮箱：");
		String yourMail = input. next();
		int atPosition = yourMail.indexOf("@");
		int dotPosition = yourMail.lastIndexOf(".");
		if (atPosition != -1 && dotPosition != -1 && (dotPosition-atPosition) > 1) {
			System.out.println("输入的邮箱正确");
		}else {
			System.out.println("输入有误");
			if (atPosition == -1)
				System.out.println("缺少@符号");
			if (dotPosition == -1)
				System.out.println("缺少.符号");
			if (atPosition != -1 && dotPosition != -1 && (dotPosition-atPosition) <= 1)
				System.out.println("@符号与.符号位置错误");
		}
	}
	@Test
	public void ts2() {
		// 查找字符串中某个字符出现的个数
		// charAt
		String str="fqowoeqouofoih";
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (a =='o') {
				count = count + 1;
			}
		}
		System.out.println("o的出现次数是："+count);
		
		// StringBuffer类append
		// split 分割
		str = "2018-8-17";
		StringBuffer sb = new StringBuffer();
		String[] arr = str.split("-");
		for (int i = 0; i < arr.length; i++) {
			StringBuffer a = new StringBuffer(arr[i]);
			if (i == 0) {
				a.append("haha");
			}
			if (i == 1) {
				a.append("o^o");
			}
			if (i == 2) {
				a.append("-_-");
			}
			arr[i] = a.toString();
			sb = sb.append(a);
			System.out.println(sb.toString());
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	@Test
	public void ts3() {
		// == 与 .equals的区别
		// ==作用于两个String字符串时，是判断是否为同一对象
		// .equals是比较字符串的内容是否相同
		String str = new String ("abcd");
		String str1 = "abcd";
		System.out.println("str.hash="+str.hashCode());
		System.out.println("str1.hash="+str1.hashCode());
		if (str == str1) {
			System.out.println("相等");
		}else {
			System.out.println("不相等");
		}
		if (str.equals(str1)) {
			System.out.println("相等");
		}else {
			System.out.println("不相等");
		}
		// 输入姓名，显示姓和名
		// 默认姓是单字
		System.out.print("请输入姓名：");
		String inputName = input.next();
		// char xing = inputName.charAt(0);
		String xing = inputName.substring(0, 1);
		String ming = inputName.substring(1);
		System.out.println("姓："+xing+",名："+ming);
		
		// 截取id,默认为18位
		System.out.println("请输入身份证号");
		String id = input.next();
		String birthdayYear = id.substring(6, 10);
		String birthdayMonth = id.substring(10, 12);
		String birthdayDay = id.substring(12, 14);
		System.out.println("出生年是："+birthdayYear+"年");
		System.out.println("生日是："+birthdayMonth+"月"+birthdayDay+"日");
	}
	@Test
	public void ts4() {
		// ”2016-11-26”转化为****/**/**格式
		// 使用replace方法与split方法
		String str = "2016-11-26";
		String str1 = str.replace("-", "/");
		System.out.println("replace 方法："+str1);
		
		String[] str2 = str.split("-");
		String str3 = "";
		for (int i = 0; i < str2.length; i++) {
			if (i == str2.length-1)
				str3 = str3+str2[i];
			else
				str3 = str3+str2[i] + "/";
		}
		System.out.println("split 方法："+str3);
	}
	@Test
	public void ts5() {
		// 实现字符串反转
		String str = "abcdefgh";
		System.out.println("原始："+str);
		
		// 1.使用StringBuffer中的reverse方法 
		StringBuffer strb = new StringBuffer(str);
		String str1 = strb.reverse().toString();
		System.out.println("反转："+str1);
		
		// 2.使用字符数组中的toCharArray,转化成字符数组后，进行反转算法
		char[] cha = new char[str.length()];
		/*for (int i = 0; i < cha.length; i++) {
			cha[i] = str.charAt(i);
		}*/
		str = "kjlshdyu";
		cha = str.toCharArray();
		// 换位(字符串,前面一半与后面一半进行换位，执行长度为总长度的一半)
		for (int i = 0; i < cha.length/2; i++) {
			char temp = cha[i];
			cha[i] = cha[cha.length -1 -i];
			cha[cha.length -1 -i] = temp;
		}
		String str2 = new String(cha);
		System.out.println("字符："+str2);
		
		// 3.赋值时就反转
		char[] cha1 = new char[str.length()];
		for (int i = 0; i < cha1.length; i++) {
			cha1[i] = str.charAt(cha1.length-1-i);
		}
		String str3 = new String(cha1);
		System.out.println("反转："+str3);
	}
	@After
	public void after() {
		input.close();
	}
}
