package com.thread;

import org.junit.Test;

public class TestThread {
	@Test
	public void tt() {
		// 创建子线程对象
		Thread01 t01 = new Thread01();
		// 启动
		t01.start();
		System.out.println("-- -- -- -- -- ");
		// 主线程
		Thread thread = Thread.currentThread();
		System.out.println("当前线程:"+thread.getName());
		System.out.println("Thread.MAX_PRIORITY:"+Thread.MAX_PRIORITY);
		System.out.println("Thread.MIN_PRIORITY:"+Thread.MIN_PRIORITY);
		System.out.println("Thread.NORM_PRIORITY:"+Thread.NORM_PRIORITY);
		System.out.println("Thread.activeCount():"+Thread.activeCount()+"\n");
	}
	@Test
	public void tt2() {
		// 创建线程任务对象
		Thread02 task = new Thread02();
		// 指定任务的线程对象
		Thread thread = new Thread(task);
		thread.start();
		//
		Thread th = Thread.currentThread();
		System.out.println(th.getName());
		System.out.println(thread.getName());
		
		System.out.println("hello");
	}
	@Test
	public void tt3() {
		// 理解线程
		Thread01 task1 = new Thread01();
		Thread t1 = new Thread(task1, "线程1");
		t1.setPriority(Thread.MIN_PRIORITY);
		
		Thread t2 = new Thread02();
		t2.setName("线程2");
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
	}
	@Test
	public void tt4() {
		// 购票系统测试
		// junit测试不能--Thread.sleep(ms)执行后测试结束
		TicketSale ts = new TicketSale();
		Thread t1 = new Thread(ts, "用户1");
		Thread t2 = new Thread(ts, "用户2");
		Thread t3 = new Thread(ts, "用户3");
		Thread t4 = new Thread(ts, "用户4");
		Thread t5 = new Thread(ts, "用户5");
		Thread t6 = new Thread(ts, "用户6");
		Thread t7 = new Thread(ts, "用户7");
		Thread t8 = new Thread(ts, "用户8");
		Thread t9 = new Thread(ts, "用户9");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
	}
	public static void main(String[] args) {
		// 创建线程任务对象
		Thread02 task = new Thread02();
		// 指定任务的线程对象
		Thread thread = new Thread(task);
		thread.start();
		//
		Thread th = Thread.currentThread();
		System.out.println(th.getName());
		System.out.println(thread.getName());
	}
}
