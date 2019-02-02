package com.reflect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LeaveAMessage {
	Scanner input = new Scanner(System.in);
	static int count = 0;
	String path = System.getProperty("user.dir")
			+"/src/main/webapp/testFile/leaveYourMessage.txt";
	public void menu() {
		this.tiltle();
		System.out.print("请选择功能:");
		String select = input.next();
		switch (select) {
			case "0":
				System.out.println(">>退出");
				System.exit(1);
				break;
			case "1":
				System.out.println(">>发布留言");
				this.leave();
				this.menu();
				break;
			case "2":
				System.out.println(">>查询留言");
				this.check();
				break;
			default:
				System.out.println(">>输入数字有误,请重新输入");
				this.menu();
				break;
		}
	}
	public void tiltle() {
		System.out.println("*** *** *** *** *** ***");
		System.out.println("欢迎来到本站点进行留言");
		System.out.println("1.发布留言\n2.查询留言");
		System.out.println("(输入0退出)");
		System.out.println("*** *** *** *** *** ***");
	}
	public void leave() {
		try {
			Message mes =new Message();
			// 获取系统当前时间
			Date date = new Date();
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			mes.setTime(formater.format(date));
			FileWriter fw = new FileWriter(path,true);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.print("请输入留言标题:");
			mes.setTitle(input.next());
			System.out.print("请输入留言内容:");
			mes.setContent(input.next());
			// 写入流
			bw.write(mes.getTitle()+",");
			bw.write(mes.getTime()+",");
			bw.write(mes.getContent());
			bw.newLine();
			// 关闭流
			bw.flush();
			bw.close();
			fw.close();
			System.out.print("要继续吗？(y-继续|其他任意键返回主菜单):");
			String ans = input.next();
			if(ans.equals("y")) {
				System.out.println(">>继续发布留言");
				this.leave();
			}
			else {
				System.out.println(">>返回主菜单");
				this.menu();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void check() {
		FileReader fr;
		try {
			fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String str;
			if ((str = br.readLine())!= null) {
				int count1 = 0;
				while(str!= null) {
					String[] arr = str.split(",");
					count1++;
					System.out.print("序号:"+count1+"\t");
					System.out.println("标题:"+arr[0]+","+"时间:"+arr[1]);
					System.out.println("内容:"+arr[2]);
					System.out.println("------ ------ ------");
					str = br.readLine();
				}
				br.close();
				fr.close();
			}else {
				System.out.println("还没有留言，赶紧回到主菜单留言去吧");
				br.close();
				fr.close();
				System.out.print("输入y返回主菜单，其他任意键退出:");
				String ansc = input.next();
				if (ansc.equalsIgnoreCase("y")) {
					System.out.println(">>返回主菜单");
					this.menu();
				}else {
					System.out.println(">>退出");
					System.exit(1);
				}
			}
			System.out.print("要返回吗？(y-返回主菜单|其他任意键退出):");
			String ans = input.next();
			if(ans.equals("y")) {
				System.out.println(">>返回主菜单");
				this.menu();
			}
			else {
				System.out.println(">>退出");
				System.exit(1);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
