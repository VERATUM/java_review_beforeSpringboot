package com.collection;
//商品管理类

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
	Scanner input = new Scanner(System.in);
	public List<Product> list = new ArrayList<Product>();
	public void menu() {
		this.title();
		System.out.print("请选择功能:");
		String num = input.next();
		switch (num) {
			case "1":
				System.out.println(">>添加商品");
				this.addProduct();
				break;
			case "2":
				System.out.println(">>删除商品");
				this.removeProduct();
				break;
			case "3":
				System.out.println(">>查询商品单价");
				this.checkPrice();
				break;
			case "4":
				System.out.println(">>显示所有商品");
				this.showAllProduct();
				break;
			default:
				System.out.println("输入数字不对,请重新输入");
				this.menu();
				break;
		}
	}
	public void title() {
		System.out.println("*** *** *** *** *** ***");
		System.out.println("欢迎进入商品管理平台");
		System.out.println("1.添加商品 \n2.删除商品  \n3.查询商品单价 \n4.显示所有商品");
		System.out.println("*** *** *** *** *** ***");
	}
	public void addProduct() {
		Product product = new Product();
		System.out.println("  >>请输入添加商品的信息");
		System.out.print("请输入商品的编号:");
		if (list.size() == 0) {
			product.setSerial(input.next());
		}else {
			String a = input.next();
			int count =0;
			for (Product p : list) {
				if (p.getSerial().equals(a))
					count =1;
			}
			if (count == 0) {
				product.setSerial(a);
			}else {
				System.out.println("输入商品编号重复，请重新录入");
				this.addProduct();
			}
		}
		System.out.print("请输入商品的名称:");
		product.setName(input.next());
		System.out.print("请输入商品的单价:");
		product.setPrice(input.nextDouble());
		System.out.print("请输入商品的数量:");
		product.setNumber(input.nextInt());
		list.add(product);
		System.out.print("要继续吗(y-继续|其他任意键返回)？:");
		String ans = input.next();
		if (ans.equalsIgnoreCase("y"))
			this.addProduct();
		else
			this.menu();
	}
	public void removeProduct() {
		if (list.size() ==0) {
			System.out.println("您还没有添加商品,请在主菜单添加");
			this.menu();
		}else {
			System.out.print("  >>请输入要删除商品的编号:");
			String ans = input.next();
			int count = 0;
			for (Product product : list) {
				if (ans.equals(product.getSerial())) {
					list.remove(product);
					System.out.println("删除成功,删除商品如下");
					product.show();
					count = 1;
					break;
				}
			}
			if (count == 0) {
				System.out.println("商品不存在");
			}
			System.out.print("要继续吗(y-继续|其他任意键返回)？:");
			String ans1 = input.next();
			if (ans1.equalsIgnoreCase("y"))
				this.removeProduct();
			else
				this.menu();
		}
	}
	public void checkPrice() {
		if (list.size() ==0) {
			System.out.println("您还没有添加商品,请在主菜单添加");
			this.menu();
		}else {
			System.out.print("  >>请输入要查询商品的编号:");
			String ans = input.next();
			int count = 0;
			for (Product product : list) {
				if (ans.equals(product.getSerial())) {
					System.out.println("查询成功，查询的商品是:"+product.getName());
					System.out.println("查询的商品单价是:"+product.getPrice());
					count = 1;
					break;
				}
			}
			if (count == 0)
				System.out.println("商品不存在");
			System.out.print("要继续吗(y-继续|其他任意键返回)？:");
			String ans1 = input.next();
			if (ans1.equalsIgnoreCase("y"))
				this.checkPrice();
			else
				this.menu();
		}
	}
	public void showAllProduct() {
		if (list.size() ==0) {
			System.out.println("您还没有添加商品,请在主菜单添加");
			this.menu();
		}else {
			for (Product product : list) {
				product.show();
			}
		}
		System.out.print("要继续吗(y-继续|其他任意键返回)？:");
		String ans1 = input.next();
		if (ans1.equalsIgnoreCase("y"))
			this.checkPrice();
		else
			this.menu();
	}
}