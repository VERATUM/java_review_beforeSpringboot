package com.oop.pg;

public class Bus {
	// 
	private String name;
	private int seat;
	private int fee;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.equals("客车"))
			this.name = name;
		else{
			this.name ="轿车";
		}
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	//
	public void show() {
		if (name.equals("客车")) {
			System.out.println("车是："+name+",车座位是："+seat);
			fee = seat*2;
			System.out.println("收费是:"+fee+"元");
			System.out.println();
		}
	}
}
