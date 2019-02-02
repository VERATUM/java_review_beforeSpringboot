package com.oop.pg;

public class Keyboard implements Usb {
	String name="keyboard";
	@Override
	public void work() {
		System.out.println("keyboard's running");
	}

}
