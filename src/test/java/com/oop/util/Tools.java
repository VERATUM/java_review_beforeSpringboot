package com.oop.util;

public class Tools {
	// 定义一个方法，将数组作为参数，返回数组所有元素之和
	public int getSum(int[]arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}
	// 定义一个方法，将数组作为参数，返回数组所有奇数之和
	public int getSum1(int[]arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				sum = sum + arr[i];
			}
		}
		return sum;
	}
	
	// 调用方法
	public static void main(String[] args) {
		Tools tool = new Tools();
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		int s = tool.getSum1(arr);
		System.out.println("和是：" + s);
	}
}
