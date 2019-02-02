package com.thread;

public class TicketSales02 extends Thread {
	// 属性：总票数count 购票序号step
	private int count = 10;
	private int step = 0;
	private boolean flag = false;
	@Override
	public void run() {
		// 实现买票
		while(!flag) {
			this.show();
		}
	}
	public synchronized void show() {
		if (count <= 0) {
			flag = true;
			return;
		}
		count--;
		step++;
		try {
			// 延时0.01s
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String str =Thread.currentThread().getName();
		System.out.println(str+":购得第"+step+"张票，还剩"+count+"张票");
	}
	public static void main(String[] args) {
		// 购票系统测试
		TicketSales02 t1 = new TicketSales02();
		t1.setName("用户A");
		TicketSales02 t2 = new TicketSales02();
		t2.setName("用户B");
		TicketSales02 t3 = new TicketSales02();
		t3.setName("用户C");
		
		t1.start();
		t2.start();
		t3.start();
		// extends建立的子线程彼此独立,与implements建立的子线程区别
	}
}
