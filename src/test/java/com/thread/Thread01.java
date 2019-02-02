package com.thread;

public class Thread01 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
				System.out.println(Thread.currentThread().getName()+":thread01-->"+i);
		}
		System.out.println(Thread.currentThread().getName()+">>end");
	}
}
