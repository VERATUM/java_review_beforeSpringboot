package com.process;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestProcessSum {
	Scanner input;
	@Before
	public void before() {
		input = new Scanner(System.in);
	}
	
	@Test
	public void tps() {
		// 有3个班各有4个同学参赛；计算每个班的平均分
		int [][]arr=new int[3][2];
		int []sum=new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("请输入第"+(i+1)+"的班级成绩：");
			for(int j=0;j<arr[i].length;j++) {
				System.out.print("\t请输入第"+(j+1)+"名同学的成绩：");
				arr[i][j]=input.nextInt();
				sum[i]=sum[i]+arr[i][j];
				sum[i]=sum[i]/arr[i].length;
			}
//			System.out.println("平均分是："+sum[i]/arr[i].length);
		}
		
		for (int i = 0; i < sum.length; i++) {
			System.out.println("sum"+i+"="+sum[i]);
		}
		
		// 今有稚兔同笼，上有三十五头，下有九十四足，问鸡兔各几只？
		// 使用双重循环解决此类问题
		for(int i=1;i<=35;i++) {
			for(int j=1;j<=35;j++) {
				if(2*i+4*j==94&&i+j==35)
					System.out.println("鸡的数量是："+i+"\n兔的数量是:"+j);
			}
		}
	}
	
	@Test
	public void tps2() {
		// 请输入行数，就显示多少行的以*号代表的菱形
		// 行数要为奇数行
        /*
        ---
	         *
	        ***
	       *****
	      *******
	       *****
	        ***
	         *
        ---
         */
		int n=7;// 行数
		int a=(n+1)/2;
		// 上半部分图形
		for(int i=1;i<=a;i++) {
			for(int k=1;k<=a-i;k++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		//下半部分图形？？重点理解
		for(int i=1;i<=a-1;i++) {
			for(int k=1;k<=i;k++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*((a-1)+1-i)-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	@Test
	public void tps3() {
		// 输入行数，显示
		/**
		  ---
		      *
			 ***
			*****
			--- ---
			*****
			 ***
			  *
		  ---
		 */
		int n=4;//行数
		// 三角形朝上的等腰三角形
		for(int i=1;i<=n;i++) {
			for(int k=1;k<=n-i;k++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 三角形朝下的等腰三角形
		System.out.println("--- ---");
		for(int i=1;i<=n;i++) {
			for(int k=1;k<=i-1;k++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*(n+1-i)-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	@Test
	public void tps4() {
		// 冒泡算法
		// int arr[]={45,34,22,76,99,23}排序
		int arr[]= {45,34,22,76,99,23};
		
		System.out.print("原始数组：");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		
		for(int i=1;i<arr.length;i++) {// 从1开始,外层循环arr.length-1次
			for(int j=0;j<arr.length-i;j++) {// 从0开始,内存比较arr.length-i次
				if(arr[j]>arr[j+1]) {//从小到大排序
				// 换位
					int a=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=a;
				}
			}
		}
		
		System.out.print("\n排序后是：");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
	}
	
	@Test
	public void tps5() {
		/**
		 *- *
		   ***
		  *****
		 *******
		*********
		 */
		int row=5;
		for(int i=1;i<=row;i++) {  //行
			 //循环控制空格 
			 for(int k=1;k<=row-i;k++) {
				 System.out.print(" ");
			 }
			 //循环控制行的*号
			 for(int j=1;j<=2*i-1;j++) {
				 System.out.print("*");
			 }
			 System.out.println();
		}
	}
	
	@Test
	public void tps6() {
		// 幸运抽奖程序
		// step1 实现菜单的输出
		String ans;
		String name=null,name1=null;
		String password=null,password1=null;
		int cardNo=0;
		int control=0;// 控制确保注册与登录
		int card[]=new int[5];
		int max=9999,min=1000;
		do {
			System.out.println("***欢迎进入奖客富翁系统***");	
			System.out.println("\t1.注册；");
			System.out.println("\t2.登录；");
			System.out.println("\t3.抽奖；");
			System.out.println("********************");
			System.out.print("请选择功能：");
			int n=input.nextInt();
		
			switch(n) {
			    case 1:
					System.out.println("奖客富翁系统>>注册；");
					System.out.println("请填写注册信息：");
					System.out.print("用户名：");
					name=input.next();
					System.out.print("密码：");
					password=input.next();
					
					cardNo=(int)(Math.random()*(max-min)+min);//生成四位数随机卡号
					System.out.println("注册成功，请记住您的会员卡号："+cardNo);
					System.out.println("用户名\t密码\t会员卡号");
					System.out.println(name+"\t"+password+"\t"+cardNo);
					control=1;
					break;
				case 2:
					if(control!=1) {
						System.out.println("未注册");
					}else {					
						System.out.println("奖客富翁系统>>登录；");
						for(int i=1;i<=3;i++) {
							System.out.print("请输入用户名：");
							name1=input.next();
							System.out.print("请输入密码：");
							password1=input.next();
						if(name1.equals(name)&&password1.equals(password)) {
							System.out.println("登录成功，欢迎您："+name);
							break;
						}else {
							if(i!=3)
								System.out.println("输入错误,您还有"+(3-i)+"次机会");
							else
								System.out.println("对不起，3次机会用完");
						}
					}
					control=2;
					}
					break;
				case 3:
					if(control==2) {
						System.out.println("奖客富翁系统>>抽奖；");
						/*System.out.print("请输入会员卡号：");
						cardNo=input.nextInt();*/
						System.out.println("今日的幸运数字是：");
						for(int i=0;i<=4;i++) {
							card[i]=(int)(Math.random()*(max-min))+min;
							System.out.print(card[i]+"\t");
						}
						System.out.println("您的会员号是:"+cardNo);
						System.out.println();
						for(int i=0;i<card.length;i++) {
							if(cardNo==card[i]) {
								System.out.println("您是幸运会员：");
							}else {
								if(i==card.length-1)
									System.out.println("抱歉，你不是幸运会员");
							}
						}
					}else {
						System.out.println("请先登录");
					}
					break;
				default:
					System.out.println("您的输入有误");
						break;
			}
			System.out.println("继续吗？(y|n)");
			ans=input.next();
		}while(ans.equals("y"));
		if(!ans.equals("y")) {
			System.out.println("系统退出，谢谢使用");
		}
	}
	
	@Test
	public void tps7() {
		// 幸运抽奖程序设计
		// 重新设计，按照一定格式注释
		// 功能说明--此次程序，只支持单个用户的注册与登录
		
		String ask;//循环是否进行的询问
		int max= 9999;// 随机产生4位数的最大与最小值
		int min= 1000;
		int uCardNo = 0;// 初始会员卡号
		String uName = "";// 用户名、密码初始化
		String uPsd = "";
		int flag = 0;// 标识符，用于控制用户注册、登录、抽奖的先后顺序
		// 使用do-while循环，执行用户选择功能操作
		do {
		// step 1:显示欢迎界面，并提供选项
		    System.out.println("*** 欢迎进入大富翁抽奖系统  ***");
			System.out.println("\t1.注册\n\t2.登录\n\t3.抽奖");
			System.out.println("***** ***** ***** *****");

		// 选择功能
			int selector = 0;// 用户输入功能选择数字
			System.out.print("请选择所需要的功能：");
			selector = input.nextInt();
		// step 2:根据选择的功能，提示欢迎进入所选择的功能
		// 如果输入错误，则给出相应的提示
			switch (selector) {
				case 1:
					System.out.println("[大富翁抽奖系统>>注册]");
					System.out.print("请输入您的用户名：");
					uName = input.next();
					System.out.print("请输入您的密码：");
					uPsd = input.next();
					System.out.print("您的会员卡号是：");
					uCardNo = (int)(Math.random()*(max-min))+min;
					System.out.println(uCardNo);
					System.out.println("用户名\t密码\t会员卡号");
					System.out.println(uName+"\t"+uPsd+"\t"+uCardNo);
					flag = 1;
					break;
				case 2:
					if (flag == 1) {
						System.out.println("[大富翁抽奖系统>>登录]");
						for (int i = 1; i<=3;i++) {
							System.out.print("请输入您要登入的用户名：");
							String inputName = input.next();
							System.out.print("请输入相应的密码：");
							String inputPsd = input.next();
								if (inputName.equals(uName) && inputPsd.equals(uPsd)) {
									System.out.println("登入成功");
									System.out.println("欢迎您"+inputName);
									flag = 2;
									break;
								}else {
									if (i == 3) 
										System.out.println("登入失败，您的3次机会用完");
									else
										System.out.println("登入失败，您还有"+(3-i)+"次机会");
								}
						}	
					}else {
						System.out.println("您还没有注册，请先注册");
					}
					break;
				case 3:
					if (flag == 2) {
						System.out.println("[大富翁抽奖系统>>抽奖]");
						System.out.print("请输入会员卡号：");
						int inputCardNo = input.nextInt();
						int []luckNo = new int[5];// 生成5个4位数的幸运数字
						int count = 0;// 标识符，判断是否是幸运会员
						if (inputCardNo == uCardNo) {
							System.out.println("幸运数字是：");
							for (int i = 0;i<luckNo.length;i++) {
								luckNo[i] = (int)(Math.random()*(max-min))+min;
								System.out.print(luckNo[i]+"\t");
							}
							System.out.println();
							for (int i = 0; i<luckNo.length;i++) {
								if (inputCardNo == luckNo[i]) {
									count = 1;
									break;
								}
							}
							if (count == 1) {
								System.out.println("恭喜您是幸运会员");
							}else {
								System.out.println("很遗憾，您不是幸运会员");
							}
						}else {
							System.out.println("会员卡号输入有误");
						}
					}else {
						System.out.println("您还未登录，请先登录");
					}
					break;
				default:
					System.out.println("请输入正确的数字");
					break;
			}
		// 循环执行以上功能
			System.out.println("继续吗？(y-继续|其他任意键退出)");
			ask = input.next();
		} while (ask.equals("y"));
	}
	
	@Test
	public void tps8() {
		// 幸运抽奖程序设计
		// 重新设计，按照一定格式注释
		// 功能说明--此次程序，只支持多个用户[10]的注册与登录
		
		String ask;//循环是否进行的询问
		int max=9999;// 随机产生4位数的最大与最小值
		int min=1000;
		int []uCardNo = new int[10];// 初始会员卡号
		String []uName = new String[10];// 用户名、密码初始化
		String []uPsd = new String[10];
		int getCardNo = 0;// 获取登录用户的会员卡号
		int pos = 0;// 控制输入人数
		int flag = 0;// 标识符，用于控制用户注册、登录、抽奖的先后顺序
		// 使用do-while循环，执行用户选择功能操作
		do {
		// step 1:显示欢迎界面，并提供选项
		    System.out.println("*** 欢迎进入大富翁抽奖系统  ***");
			System.out.println("\t1.注册\n\t2.登录\n\t3.抽奖");
			System.out.println("***** ***** ***** *****");

		// 选择功能
			int selector=0;// 用户输入功能选择数字
			System.out.print("请选择所需要的功能：");
			selector = input.nextInt();
		// step 2:根据选择的功能，提示欢迎进入所选择的功能
		// 如果输入错误，则给出相应的提示
			switch (selector) {
				case 1:
					System.out.println("[大富翁抽奖系统>>注册]");
					System.out.print("请输入您的用户名：");
					uName[pos] = input.next();
					System.out.print("请输入您的密码：");
					uPsd[pos] = input.next();
					System.out.print("您的会员卡号是：");
					uCardNo[pos] = (int)(Math.random()*(max-min))+min;
					System.out.println(uCardNo[pos]);
					System.out.println("用户名\t密码\t会员卡号");
					System.out.println(uName[pos]+"\t"+uPsd[pos]+"\t"+uCardNo[pos]);
					flag = 1;
					pos++;
					break;
				case 2:
					if (flag != 0) {
						System.out.println("[大富翁抽奖系统>>登录]");
						for (int j = 1;j <= 3;j++) {
							if(flag != 2) {
								System.out.print("请输入您要登入的用户名：");
								String inputName = input.next();
								System.out.print("请输入相应的密码：");
								String inputPsd = input.next();
								for (int i = 0;i<uName.length;i++) {
									if (inputName.equals(uName[i]) && inputPsd.equals(uPsd[i])) {
										System.out.println("登入成功");
										System.out.println("欢迎您"+inputName);
										flag = 2;
										getCardNo = uCardNo[i];
										break;
									}else {
										if (i == uName.length-1) {
											if (j == 3) 
												System.out.println("登入失败，您还有"+j+"次机会用完");
											else
												System.out.println("登入失败，您还有"+(3-j)+"次机会");
										}
									}
								}
							} else {
								// 登录正确则退出
								break;
							}
						}
					}else {
						System.out.println("您还没有注册，请先注册");
					}
					break;
				case 3:
					if (flag == 2) {
						System.out.println("[大富翁抽奖系统>>抽奖]");
						System.out.print("请输入会员卡号：");
						int inputCardNo = input.nextInt();
						int []luckNo = new int[5];// 生成5个4位数的幸运数字
						int count = 0;// 标识符，判断是否是幸运会员
						// 会员卡号只能判断最后一个登录，也只能判断最后一个
						if (inputCardNo == getCardNo) {
							System.out.println("幸运数字是：");
							for (int i = 0;i<luckNo.length;i++) {
								luckNo[i] = (int)(Math.random()*(max-min))+min;
								System.out.print(luckNo[i]+"\t");
							}
							System.out.println();
							for (int i = 0;i<luckNo.length;i++) {
								if (inputCardNo == luckNo[i]) {
									count = 1;
									break;
								}
							}
							if (count == 1) {
								System.out.println("恭喜您是幸运会员");
							}else {
								System.out.println("很遗憾，您不是幸运会员");
							}
						}else {
							System.out.println("会员卡号输入有误");
						}
					}else {
						System.out.println("您还未登录，请先登录");
					}
					break;
				default:
					System.out.println("请输入正确的数字");
					break;
			}
		// 循环执行以上功能
			System.out.println("继续吗？(y-继续|其他任意键退出)");
			ask = input.next();
		} while (ask.equals("y"));
	}
	
	@After
	public void after() {
		input.close();
	}
}
