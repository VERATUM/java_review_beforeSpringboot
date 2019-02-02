package com.oop.util;

public class Computer {
	// 创建属性
	// 电脑型号
	public String computermodel;
	// 操作系统
	public String operatingsystem;
	//　处理器
	public String processor;
	//　主板
	public String mainboard;
	//　内存
	public String memory;
	//　主硬盘
	public String harddrive;
	//　显卡
	public String videocard;
	//　显示器
	public String display;
	//　声卡
	public String soundcard;
	//　网卡
	public String networkcard;
	
	// 创建方法
	// 显示信息
	public void show() {
		System.out.println("电脑型号(computer model):"+computermodel);
		System.out.println("操作系统(operating system):"+operatingsystem);
		System.out.println("处理器(processor):"+processor);
		System.out.println("主板(mainboard):"+mainboard);
		System.out.println("内存(memory):"+memory);
		System.out.println("主硬盘(hard drive):"+harddrive);
		System.out.println("显卡(video card):"+videocard);
		System.out.println("显示器(display):"+display);
		System.out.println("声卡(sound card):"+soundcard);
		System.out.println("网卡(network card):"+networkcard);
	}
}
