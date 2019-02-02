package com.oop.util;

public class Sum {
	/**
	 * 求和
	 * @param num1
	 * @param num2
	 * @return sum
	 */
	public int out(int num1, int num2) {
		int sum=0;
		if (num1<=num2) {
			for (int i=num1; i<=num2; i++) {
				sum=i+sum;
			}
		}else {
			for (int i=num2; i<=num1; i++) {
				sum=i+sum;
			}
		}
		return sum;
	}
	
	public int out1(int num1, int num2) {
		int sum=0;
		for (int i=num1; i<=num2; i = i+1) {
			sum=i+sum;
			}
		return sum;
	}
}
