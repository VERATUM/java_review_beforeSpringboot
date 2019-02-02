package com.thread;

public class Thread02 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			if (i == 5) {
				try {
					// 在main线程中测试
					// 线程休眠1s
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		System.out.println(Thread.currentThread().getName()+">>end");
	}
}
