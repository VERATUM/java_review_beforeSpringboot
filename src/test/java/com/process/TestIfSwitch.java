package com.process;

import java.util.Calendar;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIfSwitch {
	Scanner input;
	@Before
	public void before() {
		input = new Scanner(System.in);
	}
	@Test
	public void tis() {
		// 输入对应的月份，计算出对应的天数
		System.out.print("请输入月份：");
		//if(input.hasNextInt()){}判断输入是否与接收输入一致
		if(input.hasNextInt()) {
			int month=input.nextInt();			
			int res=0;
			switch(month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
						res=31;
				System.out.println("对应的天数为："+res);
					break;
				case 2:
					//判断闰年的标准是：1、能整除4且不能整除100 2、能整除400
					int year = Calendar.getInstance().get(Calendar.YEAR);
					if(year % 4== 0 && year % 100 != 0 || year % 400 == 0)
						res = 29;
					else 
						res = 28;
				System.out.println("对应的天数为："+res);
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					res=30;
				System.out.println("对应的天数为："+res);
					break;
				default:
					System.out.println("您的输入有误");
					break;
			}	
		}else {
			System.out.println("输入不匹配");
		}
	}
	@Test
	public void tis2() {
		// 用while语句循环自己的名字十次
		int i=1;
		while(i <= 10) {
			System.out.println("第"+i+"次输出：ver");
			i++;
		}
		System.out.println(i);
	}
	@Test
	public void tis3() {
		// 用while语句求1到100的和
		/*int i=1,s=0;//s为累加器		
		while(i<=100) {
			s=s+i;//循环体
			i++;//i+=n,即是i=i+n
		}
		System.out.println("1到100之和为："+s);
		System.out.println("循环次数"+(i-1));*/
		int i=100,s=0;//s为累加器		
		while(i>=1) {
			s=s+i;//循环体
			i--;//i-=n,即是i=i-n
		}
		System.out.println("1到100之和为："+s);
	}
	@Test
	public void tis4() {
		// 跑圈不固定次数
		System.out.println("是否跑一圈：y|n");
		String ans=input.next();
		int i=0;
		while(ans.equals("y")){
			i=i+1;
			System.out.println("请跑一圈。。。");
			System.out.println("您已跑了"+i+"圈，是否继续跑一圈：y|n");
			ans=input.next();
		}
		if (i == 0) {
			System.out.println("太懒了，懒得动了");
		}
		System.out.println("结束");
	}
	@Test
	public void tis5() {
		//余额
		int money=5000;
		System.out.print("是否登入成功 y|n:");
		String flag=input.next();
		while(flag.equals("y")) {
			System.out.println("欢迎使用ATM取款机系统.");
			System.out.println("功能菜单项:1.存款 \t2.取款 ");
			System.out.print("请选择功能:");
			if(input.hasNextInt()) {  //判断输入的内容是否合法
				int control=input.nextInt();  //接收输入整数
				//处理判断 
				switch (control) {
					case 1:  //存款
						System.out.print("请输入存款金额:");
						int saveMoney=input.nextInt();
						money=money+saveMoney;
						System.out.println("余额是:"+money);
						break;
					case 2: //取款
						System.out.print("请输入取款金额:");
						int getMoney=input.nextInt();
						if(getMoney>=money) {
							System.out.println("卡上余额不足，请充值");
						}else {
							money=money-getMoney;
							System.out.println("余额是:"+money);
						}
						break;
					default:
						System.out.println("无此功能项，等待升级..");
						break;
				}
			}else {
				System.out.println("输入不匹配...");
				// add 重置flag
				flag = input.next();
			}
			//询问
			System.out.print("你想继续操作吗y|n?");
			flag=input.next();
		}
		if(!flag.equals("y")) {
			System.out.println("退卡走人..");
		}
	}
	@Test
	public void tis6() {
		// 求1~100之间5的倍数，数值和
		int i=100;
		int s=0;
		while(i>=1) {
			s=s+i;
			System.out.println("s="+s+";i="+i+"\t");
			i=i-5;
		}
		
		// 用while,计算1~50之间能被7整除的数字之和
		i=1;
		s=0;
		while(i<=50) {
			if((i%7)==0) {
				s=s+i;
				System.out.print(i+"\t");
				}
			i++;
		}
		System.out.println("\n从1到50之间被7整除的数字之和是："+s);
		
		// 1~100之间能同时被3和5同时整除的数
		i=1;
		s=0;
		while(i<=100) {
			if(i%3==0&&i%5==0) {
				s=s+1;
				System.out.println("第"+s+"个数："+i);
			}
			i++;
		}
		System.out.println("1~100之间能同时被3和5同时整除的数，总共有"+s+"个");
	}
	@Test
	public void tis7() {
		// 使用switch语句编写小明的一周学习计划
		System.out.println("请输入星期：（如星期一，星期二等）");
		String week=input.next();
		switch(week) {
			case "星期一":
			case "星期三":
			case "星期五":
				System.out.println("学习编程");
					break;
			case "星期二":
			case "星期四":
			case "星期六":
				System.out.println("学习英语");
					break;
			case "星期日":
				System.out.println("休息");
				break;	
			default:
				System.out.println("请确认输入范围");
			break;	
		}		
	}
	@Test
	public void tis8() {
		int money=5000;
		System.out.println("是否需要存取款：1（需要），2（不需要）");
			int ck=input.nextInt();
		while(ck==1) {
			System.out.println("请输入您的选项：存款（请输入1），取款（请输入2）");
			int num=input.nextInt();
			//设定用户原来账户金额为5000			
			if(num==1) {
				System.out.print("请输入您的存款金额：");
					int num1=input.nextInt();
						money=num1+money;
				System.out.println("存款成功!");
				System.out.print("您的存款余额为："+money);
			}
			if(num==2) {
				System.out.print("请输入您的取款金额：");
				int num3=input.nextInt();
				if(num3<=money) {
					money=money-num3;
					System.out.print("取款成功!");
					System.out.print("您的存款余额为："+money);
				}else {
					System.out.print("您的余额不足，取款失败!");
				}
			}
			System.out.println("\n是否需要存取款：1（需要），2（不需要）");
			ck=input.nextInt();
		}
		if(ck==2) {
			System.out.println("\n请收回您的卡，欢迎下次光临");
		}
	}
	@After
	public void after() {
		input.close();
	}
}
