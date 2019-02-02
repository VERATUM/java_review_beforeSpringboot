package com.process;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestArray {
	Scanner input;
	@Before
	public void before() {
		input = new Scanner(System.in);
	}
	@Test
	public void ta() {
		// 定义一个数组存周围同学的姓名,并输出.  
		// 要求:
		// 先定义，再赋值，输出显示
		String []str;
		str=new String[4];
		str[0]="veratum";
		str[1]="张三";
		str[2]="李四";
		str[3]="老王";
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
		System.out.println("--- ---");
		
		String []one= {"1a","2b","3c","4k"};
		for(int i=0;i<one.length;i++) {
			System.out.println(one[i]);
		}
		
		System.out.println("--- ---");
		int []int1= {1,2,4};
		for(int i=0;i<int1.length;i++) 
			System.out.println(int1[i]);
	}
	@Test
	public void ta2() {
		//以表格形式输出5|4笔购物金额，总金额
		double []pri=new double[5];
		for(int i=0;i<5;i++) {
			System.out.print("请输入第"+(i+1)+"次购物金额:");
			pri[i]=input.nextDouble();
		}
		System.out.println("--- ---");
		// 排序 ascension
		Arrays.sort(pri);
		
		System.out.println("序号\t金额");
		double sum=0;
		for(int i=0;i<pri.length;i++) {
			System.out.print((i+1)+"\t"+pri[i]);
			System.out.println();
			sum=sum+pri[i];
		}
		System.out.println("总金额\t"+sum);
		System.out.println("最大值是："+pri[pri.length-1]);
		System.out.println("最小值是："+pri[0]);
		//计算最大值
		double r=pri[0];
		for(int i=0;i<pri.length;i++) {
			// 依次遍历
			if(r<=pri[i]) {
				r=pri[i];
			} 
		}
		System.out.println(r);
	}
	@Test
	public void ta3() {
		// 向一个数组的固定位置插入一个元素
		int[]arr=new int[6];
		for(int i=0;i<arr.length-1;i++)
			arr[i]=5*(i+1);
		/*arr[0]=5;arr[1]=10;arr[2]=15;arr[3]=20;arr[4]=25;*/
		// 插入位置
		int pos=1;
		for(int i=arr.length-1;i>pos;i--) {
			arr[i]=arr[i-1];
		}
		arr[pos]=100;
		// show original array
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
		// sort the array
		Arrays.sort(arr);
		System.out.println("... ...");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		int a=118400;
		System.out.println("\n"+16.9*a);
	}
	@Test
	public void ta4() {
		// 某班级参加有五名学员参加考试，求出总分，平均分，最高分，最低分
		// 将每个学生分数由到高排序
		int[]arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			System.out.print("请输入第"+(i+1)+"个同学的成绩:");
			arr[i]=input.nextInt();
		}
		Arrays.sort(arr);//默认是升序
		int sum=0;
		System.out.println("序号\t成绩");
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
			System.out.println((i+1)+"\t"+arr[i]);
		}
		System.out.println("最高分是："+arr[arr.length-1]);
		System.out.println("最低分是："+arr[0]);
		System.out.println("总分是："+sum);
		System.out.println("平均分是："+sum/arr.length);
	}
	@Test
	public void ta5() {
		// 输入一组字符进行排序
		// 输出正序和逆序
		char []cha= {'a','c','u','b','e','p','f','z'};
		
		System.out.print("数组是：");
		for(int i=0;i<cha.length;i++) {			
			System.out.print(cha[i]+"\t");
		}
		
		Arrays.sort(cha);
		System.out.print("\n正序是：");
		for(int i=0;i<cha.length;i++) {			
			System.out.print(cha[i]+"\t");
		}
		
		System.out.print("\n逆序是：");
		for(int i=0;i<cha.length;i++) {			
			System.out.print(cha[cha.length-1-i]+"\t");
		}
	}
	@Test
	public void ta6() {
		// 实现数组拷贝
		// 将以下两个数的内容复制到另一个数组
		int arr1[]= {10,90,30,60};
		int arr2[]= {50,20,70,80,40};
		int arr[]=new int[arr1.length+arr2.length];
		// 一个一个填充 |-_-
		for(int i=0;i<arr1.length;i++) {
			arr[i]=arr1[i];
		}
		for(int i=0;i<arr2.length;i++) {
			arr[i+arr1.length]=arr2[i];
		}
		
		System.out.println("拷贝后的数组是：");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		
		Arrays.sort(arr);
		System.out.println("\n升序排序后的数组是：");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
	}
	@Test
	public void ta7() {
		// 给定数组存放了所有的学生姓名
		// 输入一个姓名，判断学生是否存在
		// 如果存在，请输出学生的位置
		String names[]= {"张三","李四","麻子","小林子","无情"};
		System.out.println("已有学生姓名：");
		for(int i=0;i<names.length;i++)
			System.out.print(names[i]+"\t");
		System.out.println("\n请输入要查找的学生姓名：");
		String name=input.next();
		for(int i=0;i<names.length;i++) {
			if(name.equals(names[i])) {
				System.out.println("姓名："+names[i]+"存在");
				System.out.print("该姓名在第"+(i+1)+"位");
				break;
			}else {
				if((i+1)==names.length) 
					System.out.print("该姓名不存在");
			}
		}
	}
	@Test
	public void ta8() {
		/*
		打印*图案 4x6
		******
		******
		******
		******|*/
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=6;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.println("=== === === 九九乘法表 === === ===");
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i+"x"+j+"="+i*j+"\t");
			}
			System.out.print("\n");
		}
		System.out.println("=== === === 金字塔  === === ===");
		int row=3;// 控制行数
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=row-i;j++) // 打印空格
				System.out.print(" ");
			for(int k=1;k<=2*i-1;k++) // 打印关系
				System.out.print("*");
			System.out.print("\n");
		}
	}
	@Test
	public void ta9() {
		// 请输入行数，显示对应行数的倒三角形:
		/*	以5行例:每行*号为:9 7 5 3 1
			效果如下:
			请输入行数:5
			*********
			*******
			*****
			***
			*
		*/
		System.out.print("请输入要显示的倒三角形的行数：");
		int rank=input.nextInt();
		/*for(int i=1;i<=rank;i++) {
			for(int j=1;j<=2*(rank+1-i)-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}*/
		for(int i=1;i<=rank;i++) {
			for(int j=2*(rank+1-i)-1;j>=1;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 打印二维数组
		String [][]str= {
				{"I","a","b","c"},
				{"A","B","C"},
				{"a1","b2","c3"}
		};
		// 二重循环
		for(int i=0;i<str.length;i++) {
			for(int j=0;j<str[i].length;j++) {
				if (j == str[i].length - 1) {
					System.out.println(str[i][j]);
				} else {
					System.out.print(str[i][j]+"\t");
				}
			}
			System.out.println();
		}
	}
	@After
	public void after() {
		input.close();
	}
}
