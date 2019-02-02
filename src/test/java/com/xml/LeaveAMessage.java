package com.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class LeaveAMessage {
	Scanner input = new Scanner(System.in);
	// path 获取java项目的路径
	String path = System.getProperty("user.dir");// 此处指定为默认获取java project路径
	String pathFile = path+"/src/main/webapp/testFile/leaveAMsg.xml";
	SAXReader saxReader = new SAXReader();
	static int count = 0;
	static String str ="0";
	
	public void menu() {
		this.tiltle();
		System.out.print("请选择功能:");
		String select = input.next();
		input.nextLine();
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
			case "3":
				System.out.println(">>删除留言");
				this.removeMes();
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
		System.out.println("1.发布留言\n2.查询留言\n3.删除留言");
		System.out.println("(输入0退出)");
		System.out.println("*** *** *** *** *** ***");
	}
	public void leave() {
		// 添加留言
		try {
			// 1.创建文本对象
			Document doc = saxReader.read(pathFile);
			// 2.获取根标签
			Element root = doc.getRootElement();
			List<Element> root2list = root.elements();
			for (Element element : root2list) {
				if (element.attributeValue("id").equals(null)) {
					return;
				}else {
					str = element.attributeValue("id");
				}
			}
			// 将字符串转换为int类型
			count = Integer.parseInt(str)+1;
			str = String.valueOf(count);
			System.out.println("根标签名:"+root.getName());
			// 3.添加子标签
			Element addroot = root.addElement("message");
			// 子标签的属性id即为存储序号，序号0位xml的格式,留言从1开始计数
			addroot.addAttribute("id", str);
			// 4.输入留言
			System.out.print("请输入留言标题:");
			addroot.addElement("title").setText(input.nextLine());
			// 获取系统当前时间
			Date date = new Date();
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			addroot.addElement("time").setText(formater.format(date));
			System.out.print("请输入留言内容:");
			addroot.addElement("content").setText(input.nextLine());
			// 5.保存到xml文本
			FileWriter fw = new FileWriter(pathFile);
			OutputFormat opf = OutputFormat.createPrettyPrint();
			opf.setEncoding("gb2312");
			XMLWriter xw = new XMLWriter(fw,opf);
			xw.write(doc);
			//关闭
			xw.close();
			System.out.println("留言成功");
			System.out.print("要继续吗？(y-继续|其他任意键返回主菜单):");
			String ans = input.next();
			input.nextLine();
			if(ans.equals("y")) {
				System.out.println(">>继续发布留言");
				this.leave();
			}
			else {
				System.out.println(">>返回主菜单");
				this.menu();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void check() {
		// 查看留言内容
		try {
			Document doc = saxReader.read(pathFile);
			Element root = doc.getRootElement();
			List<Element> root2list = root.elements();
			if (root2list.size()==0) {
				System.out.println("还没有留言");
			}else {
				// 重新排序
				String stri= "";
				for (int i = 0; i < root2list.size(); i++) {
					stri =i+1+"";
					root2list.get(i).attribute("id").setValue(stri);
				}
				// 查看属性值
				for (Element element : root2list) {
					List<Element> root3list = element.elements();
						System.out.print("序号"+element.attributeValue("id"));
						System.out.print(",主题:"+root3list.get(0).getText());
						System.out.println(",时间:"+root3list.get(1).getText());
						System.out.println("内容:"+root3list.get(2).getText());
						System.out.println("--- --- ---");
				}
				// 保存到xml
				FileWriter fw = new FileWriter(pathFile);
				OutputFormat opf = OutputFormat.createPrettyPrint();
				opf.setEncoding("gb2312");
				XMLWriter xw = new XMLWriter(fw,opf);
				xw.write(doc);
				xw.close();
				System.out.println("总共"+root2list.size()+"条留言,查看所有留言完毕");
			}
			System.out.print("要返回主菜单吗？(y-返回|其他任意键退出):");
			String ans = input.next();
			input.nextLine();
			if(ans.equals("y")) {
				System.out.println(">>返回主菜单");
				this.menu();
			}
			else {
				System.out.println(">>退出");
				System.exit(1);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void removeMes() {
		try {
			Document doc = saxReader.read(pathFile);
			Element root = doc.getRootElement();
			List<Element> root2list = root.elements();
			if (root2list.size()==0) {
				System.out.println("还没有留言");
			}else {
				System.out.print("请输入要删除留言的序号(>=1):");
				String id = input.next();
				input.nextLine();
				int flag = 0;
				for (Element element : root2list) {
					if(element.attributeValue("id").equals(id)) {
						element.getParent().remove(element);
						flag = 1;
					}
				}
				// 保存到xml
				FileWriter fw = new FileWriter(pathFile);
				OutputFormat opf = OutputFormat.createPrettyPrint();
				opf.setEncoding("gb2312");
				XMLWriter xw = new XMLWriter(fw,opf);
				xw.write(doc);
				//关闭
				xw.close();
				if (flag == 1) {
					System.out.println("删除序号为"+id+"的留言成功");
				}
				if (flag == 0) {
					System.out.println("没有此序号的留言");
				}
			}
			System.out.print("要继续吗？(y-继续|其他任意键返回主菜单):");
			String ans = input.next();
			input.nextLine();
			if(ans.equals("y")) {
				System.out.println(">>继续删除留言");
				this.removeMes();
			}
			else {
				System.out.println(">>返回主菜单");
				this.menu();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
