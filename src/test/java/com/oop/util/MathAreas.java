package com.oop.util;
/**
 * 求圆的面积
 */
public class MathAreas {
	public double r;
	
	public void outputAreas() {
		double areas = Math.PI*this.r*this.r;
		System.out.println("圆的面积是："+areas);
	}
}
