package com.thread;
//多线程任务类
public class TicketSale implements Runnable{
	// 属性：总票数count 购票序号step
	private int count = 500;
	private int step = 0;
	private boolean flag = false;
	@Override
	public void run() {
		// 实现买票
		while(!flag) {
			this.show();
			/*synchronized(this) {
				if (count <= 0) {
					flag =true;
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
			}*/
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
}
