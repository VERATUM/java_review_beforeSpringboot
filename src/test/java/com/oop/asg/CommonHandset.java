package com.oop.asg;

public class CommonHandset extends Handset implements PlayWiring {
	public void play(String s) {
		System.out.println("您正在播放"+s+"...");
	}
	
	public void sendInfo() {
		System.out.println("发短信功能启动...");
	}
	public void call() {
		System.out.println("打电话...");
	}
	public void info() {
		System.out.println("显示手机信息...");
		System.out.println("品牌："+this.getBrand()+",型号："+this.getType());
		System.out.println("--- --- ---");
	}
}
