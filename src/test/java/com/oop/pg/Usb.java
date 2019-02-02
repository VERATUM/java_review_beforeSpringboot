package com.oop.pg;

public interface Usb {
	// 属性：静态
	// (public static final)可以省略
	String name="USB";
	// 方法
	public void work();
	
	public default void show() {
		System.out.println("this is a way to show usb's working on");
	}
}
