package com.oop.asg;
//智能手机类
public class AptitudeHandset extends Handset implements TakePictures,Network,PlayWiring{
	public void play(String s) {
		System.out.println("您正在播放"+s+"...");
	}
	public void networkConnect() {
		System.out.println("网络服务已连接...");
	}
	public void takePicture() {
		System.out.println("照相模式启动...");
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
