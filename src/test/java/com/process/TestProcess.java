package com.process;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestProcess {
	Scanner input;
	@Before
	public void before() {
		input = new Scanner(System.in);
	}
	
	@Test
	public void t1() {
		// char cast to show ascii
		int a = (int)'0';
		System.out.println(a);
		String res = null;
		do {
			System.out.print("enter a char to show it's ascii code(enter NO. 0 to end):");
			res = input.next();
			System.out.println((int)res.toCharArray()[0]);
			System.out.println("--- --- ---");
			if (res.equals("0")) {
				System.out.println("input is over");
			}
		} while (!res.equals("0"));
	}
	
	@Test
	public void t2() {
		// compare ths size of three numbers
		System.out.print("first NO. :");
		int n1 = input.nextInt();
		System.out.print("second NO. :");
		int n2 = input.nextInt();
		System.out.print("third NO. :");
		int n3 = input.nextInt();
		if (n1 >= n2) {
			if (n2 >= n3) {
				System.out.println("from big to small order is :"+n1+","+n2+","+n3);
			} else {
				if (n1 >= n3) {
					System.out.println("from big to small order is :"+n1+","+n3+","+n2);
				} else {
					System.out.println("from big to small order is :"+n3+","+n1+","+n2);
				}
			}
		} else {
			if (n1 >= n3) {
				System.out.println("from big to small order is :"+n2+","+n1+","+n3);
			} else {
				if (n2 >= n3) {
					System.out.println("from big to small order is :"+n2+","+n3+","+n1);
				} else {
					System.out.println("from big to small order is :"+n3+","+n2+","+n1);
				}
			}
		}
	}
	
	@Test
	public void t3() {
		// change the value of two numbers
		System.out.print("Enter a key(s1):");
		String s1 = input.next();
		System.out.print("Enter a key(s2):");
		String s2 = input.next();
		String temp;
		// process
		temp = s1;
		s1 = s2;
		s2 = temp;
		System.out.print("res :s1="+s1+",s2="+s2);
	}
	
	@Test
	public void t4() {
		// Conversion between Fahrenheit and Centigrade
		System.out.print("enter a number:");
		double t = input.nextDouble();
		double c = 5*(t-32)/9.0;
		double f = 1.8*t+32;
		System.out.println("temperature now t="+t);
		System.out.println("f="+f);
		System.out.println("c="+c);
	}
	
	@Test
	public void t5() {
		System.out.println("请输入您的选项：存款（请输入1），取款（请输入2）");
		int num=input.nextInt();
		//设定用户原来账户金额为5000
		int money=5000;
		if(num==1) {
			System.out.print("请输入您的存款金额：");
				int num1=input.nextInt();
				int num2=num1+money;
			System.out.println("存款成功!");
			System.out.print("您的存款余额为："+num2);
		}
		if(num==2) {
			System.out.print("请输入您的取款金额：");
				int num3=input.nextInt();
			if(num3<=money) {
				int num4=money-num3;
				System.out.print("取款成功!");
				System.out.print("您的存款余额为："+num4);
			}else {
				System.out.print("您的余额不足，取款失败!");
			}
		}
		/*switch(a) {
			case 1:
				System.out.println("请输入您存入金额：");
					int p=input.nextInt();
						money=money+p;
				System.out.println("存入成功");
				System.out.println("您的余额为："+money);
				break;
			case 2:
				System.out.println("请输入您取款金额：");
					int p1=input.nextInt();
				if(p1<=money){
					money=money-p1;
					System.out.println("取款成功");
					System.out.println("您的余额为："+money);
				}else{
					System.out.println("余额不足，取款失败");
				}
				break;
			default:
					System.out.println("请输入正确的数字");
					break;
		}*/
		System.out.println("请输入总的行数：");
		int rank=input.nextInt();
		int a=(int)rank/3;
		int b=rank-3*a;
		int c=a+1;
		//System.out.println("总的页数为："+(++a));
		if(b==0) {
			System.out.println("总的页数为："+a);
		}else {
			System.out.println("总的页数为："+c);
		}
	}
	
	@Test
	public void t6() {
		// 根据用户购物金额
		// 金额超过1000,打7折；800~1000，打8折
		// 500~800打9折，500以下打98折
		// 输出用户打折后的所需金额
		System.out.print("请输入您的购物金额:");
			double num=input.nextDouble();
		if(num>=1000) {
			System.out.println("您的折扣为七折：");
				double num1=num*0.7;
			System.out.println("您的购物金额为："+num);
			System.out.println("您的实际支付金额为："+num1);
		}else if(num>=800) {
			System.out.println("您的折扣为八折：");
				double num2=num*0.8;
			System.out.println("您的购物金额为："+num);
			System.out.println("您的实际支付金额为："+num2);				
		}else if(num>=500) {
			System.out.println("您的折扣为九折：");
				double num3=num*0.9;
			System.out.println("您的购物金额为："+num);
			System.out.println("您的实际支付金额为："+num3);
		}else {
			System.out.println("您的折扣为九八折：");
				double num4=num*0.98;
			System.out.println("您的购物金额为："+num);
			System.out.println("您的实际支付金额为："+num4);
		}
	}
	
	@Test
	public void t7() {
		// 分别输入两个数，
		// 输入运算符号
		// 输出计算的结果
		System.out.print("请输入数字：");
				double num1=input.nextDouble();
		System.out.print("请输入符号(+、-、*、/):");
				String num2=input.next();
		System.out.print("请输入另外的数字：");
				double num3=input.nextDouble();
				
		if(num2.equals("+")) {
				double num=num1+num3;
			System.out.print("计算显示："+num1+num2+num3);
			System.out.print("="+num);
		} else if(num2.equals("-")) {
			double num=num1-num3;
			System.out.print("计算显示："+num1+num2+num3);
			System.out.print("="+num);
		} else if(num2.equals("*")) {
			double num=num1*num3;
			System.out.print("计算显示："+num1+num2+num3);
			System.out.print("="+num);
		} else if(num2.equals("/")) {
			if (num3 == 0) {
				System.out.println("除数为0");
			} else {
				double num=num1/num3;
				System.out.print("计算显示："+num1+num2+num3);
				System.out.print("="+num);
			}
		} else {
			System.out.println("输入的符号异常");
		}
	}
	
	@Test
	public void t8() {
		// 根据当天上网的时间
		// 6~8提示早上好，12~14提示中午好，20~22提示晚上好
		// 8~12及14~17提示安心上网，无人打扰
		// 其余时间提示睡觉啦
//		Date date=new Date(System.currentTimeMillis());
		// 获取当前时间的小时
//			int t=date.getHours();
		Calendar cd = Calendar.getInstance();
		int t = cd.get(Calendar.HOUR);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cd.getTime()));
		
		System.out.println("当前时间"+t+"点");
		if(t>=6) {
			if(t<8) {
				System.out.println("早上好");
			}else if(t<12) {
				System.out.println("安心上网，无人打扰");
			}else if(t<14) {
				System.out.println("中午好");
			}else if(t<17) {
				System.out.println("安心上网，无人打扰");
			}else if(t<20) {
				System.out.println("睡觉啦");
			}else if(t<22) {
				System.out.println("晚上好");
			}else {
				System.out.println("睡觉啦");
			}
		}
	}
	
	@Test
	public void t9() {
		// 输入语文和数学成绩，只有两门成绩都达到60分以上，考试通过
		// 否则不能通过
		System.out.print("请输入语文成绩：");
		int yw=input.nextInt();
		System.out.print("请输入数学成绩：");
		int math=input.nextInt();
		if(math>=60&&yw>=60) {
			System.out.println("考试通过");
		}else {
			System.out.println("考试没有通过");
		}
		System.out.print("数学成绩-->");
		if(math>=80) {
			System.out.println("优。。");
		} else if(math>=60) {
			System.out.println("中。。");
		} else {
			System.out.println("差。。");
		}
	}
	
	@After
	public void after() {
		input.close();
	}
}

