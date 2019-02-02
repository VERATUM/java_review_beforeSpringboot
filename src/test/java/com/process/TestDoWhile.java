package com.process;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDoWhile {
	Scanner input;
	@Before
	public void before() {
		input = new Scanner(System.in);
	}
	@Test
	public void tdw() {
		// 使用do-while求1~100的和；
		int i=1,sum=0;
		do {
			sum=sum+i;
			i++;
		} while(i<=100);
		System.out.println("1到100的和是sum="+sum);
	}
	@Test
	public void tdw2() {
		// 使用do-while循环输入商品价格，输入0结束
		// 计算出总的商品价格，并计算商品件数
		double i,sum=0;
		int count=0;
		do {
			System.out.print("请输入商品价格(输入0退出)：");
			i=input.nextDouble();
			sum=sum+i;
			count=count+1;
		}
		while(i!=0);
		System.out.println("您购入"+(count-1)+"件，商品价格是："+sum);
	}
	@Test
	public void tdw3() {
		// 输入一个数，写出这个数的加法数；
		// 如：6
		//	0+6=6;1+5=6;2+4=6;
		//	3+3=6;4+2=6;5+1=6;
		//  6+0=6;
		System.out.println("请输入一个正整数：");
		if(input.hasNextInt()) {
			int n=input.nextInt();
			if(n>0) {
				System.out.println("数"+n+"的加法方式如下：");
				for(int i=0,j=n;i<=n;i++,j--) {
					System.out.println(i+"+"+j+"="+n);
				}
			} else {
				System.out.println("输入有误，请输入大于0的数");
			}
		} else {
			System.out.println("输入有误，请输入整数");
		}
	}
	@Test
	public void tdw4() {
		// 输入用户名与密码，提示登入成功与失败
		// 如果输入错误超过三次，则提示无输入次数
		for(int i=1;i<=3;i++) {
			System.out.print("请输入您的用户名：");
			String yourname=input.next();
			System.out.print("请输入您的密码：");
			String psd=input.next();
			if(yourname.equals("admin")&&psd.equals("123")) {
				System.out.print("登入成功");
				break;
			}else {
				System.out.println("登入失败,您还有"+(3-i)+"次机会");
				if(3-i==0)
					System.out.println("对不起，您的3次机会输入错误，完毕");
			}
		}
	}
	@Test
	public void tdw5() {
		// 使用3种循环语句求1到100的和；
		// while循环
		int i=1;
		int s=0;
		while(i<=100) {
			s=s+i;
			i++;
		}
		System.out.println("while循环求1到100的和是："+s);
		
		// do-while循环
		int j=1,s1=0;
		do {
			s1=s1+j;
			j++;
		}while(j<=100);
		System.out.println("do-while循环求1到100的和是："+s1);
		
		// for循环
		int s2=0;
		for(int a=1;a<=100;a++) {
			s2=s2+a;
		}
		System.out.println("for循环求1到100的和是："+s2);
	}
	@Test
	public void tdw6() {
		// 输入星期一到星期五，每天的学习时间
		// 使用for循环
		// 计算每天的平均学习时间
		int avg=0,s=0;
		for(int i=1;i<=5;i++) {
			System.out.println("今天是星期(星期一到星期五):"+i);
			System.out.print("请输入学习的时间：(以小时为单位，输入0~24):");
			int t=input.nextInt();
			// 判断输入的时间的合理性 |-_-
			while (t > 24 || t < 0) {
				System.out.print("输入时间有误,请输入学习的时间：(以小时为单位，输入0~24):");
				t=input.nextInt();
			}
			s=s+t;
		}
		avg=s/5;
		System.out.println("每天平均学习时间是："+avg);
	}
	@Test
	public void tdw7() {
		// 开发一个标题为FlipFlop的游戏
		// 它从1到100开始计数
		// 遇到3的倍数输出Flip；遇到5的倍数输出Flop;
		// 即是3和5的倍数输出FlipFlop
		// 其余情况输出当前数字
		System.out.println("欢迎来到FlipFlop游戏！");
		System.out.println("是否开始游戏：y|n");
		String ans=input.next();
		while(ans.equals("y")) {
		for(int i=1;i<=100;i++) {
			if(i%3==0) {
				if(i%5==0) {
					System.out.println("FlipFlop");
				}else {
					System.out.println("Flip");
				}
				continue;
			}
			if(i%5==0&&i%3!=0) {
				System.out.println("Flop");
				continue;
			}
			System.out.println(i);
		}
		System.out.println("是否继续开始游戏：y|n");
			ans=input.next();
		}
		if(!ans.equals("y")) {
			System.out.println("游戏结束");
		}
	}
	@Test
	public void tdw8() {
		// 输入一个正整数；输出这个数的阶乘
		// 限制输入数为1~10
		System.out.print("请输入一个正整数:");
		int n=input.nextInt();
		if(n>=1&&n<=10) {
			int s=1;
			for(int i=1;i<=n;i++) {
				s=s*i;
			}
			System.out.println("输入正整数"+n+"!="+s);
		}else {
			System.out.println("无效程序");
		}
		
		// 输入固定人数的年龄，计算年龄大于某个数的比例
		int cus=7,count=0;
		for(int i=1;i<=cus;i++) {
			System.out.print("第"+i+"位顾客年龄是：");
			int age=input.nextInt();
			if(age>30) {
				count=count+1;
			}
		}
		double rat=100*count/cus;
		System.out.println("30岁以下顾客的比例是："+(100-rat)+"%");
		System.out.println("30岁以上顾客的比例是："+rat+"%");
	}
	@Test
	public void tow9() {
		// 编写java程序，实现输出1~100中所有不能被7整除的数 ，并求其和。
		// 每输出4个数据换行显示
		int sum=0,count=0;
		for(int i=1;i<=100;i++) {
			if(i%7!=0) {
				count=count+1;
				sum=sum+i;
				if(count%4!=0) {
					System.out.print(i);
					System.out.print("\t");
				}else {
					System.out.print(i);
					System.out.print("\n");
				}
			}
		}
		System.out.print("\n"+"count="+count);
		System.out.println("\n"+"输出"+"\t"+"从1~100中所有不能被7整除的数 ，和是："+sum);
		System.out.println("输出"+"\t"+"从");
		System.out.println("你"+"\t"+"我");
		
		// 今有稚兔同笼，上有三十五头，下有九十四足，问鸡兔各几只？
		// 用for循环，求出鸡与兔的数量
		// 设鸡的数量为i只
		// 头数2*i+4*(35-i)=140-2i
		System.out.println("--- --- === --- ---");
		int downLegs = 94;
		int upTops = 35;
		for(int i=1;i<=upTops;i++) {
			if((2*i+4*(upTops-i))==downLegs ){
				System.out.println("鸡的数量是："+i);
				System.out.println("兔的数量是："+(upTops-i));
				break;
			}
		}
	}
	
	@After
	public void after() {
		input.close();
	}
}
