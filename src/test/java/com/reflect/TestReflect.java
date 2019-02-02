package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.io.Student;

public class TestReflect {
	Scanner input;
	@Before
	public void before() {
		input = new Scanner(System.in);
	}
	@Test
	public void tr() {
		// reflect
		String ans= "";
		do {
			System.out.print("请输入方法名[eat,run,bark,rest]:");
			String methodName = input.next();
			
			@SuppressWarnings("rawtypes")
			Class c;
			try {
				c = Class.forName("com.reflect.Dog");
				Object o = c.newInstance();
				
				@SuppressWarnings("unchecked")
				Method method = c.getDeclaredMethod(methodName);
				method.invoke(o);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			System.out.print("是否继续?(y-继续|其他任意键退出)");
			ans = input.next();
			if (ans.equals("y")) {
				System.out.println("继续>>");
			}else {
				System.out.println("退出>>Exit");
			}
		}while(ans.equals("y"));
	}
	@Test
	public void tr2() {
		// Class<?> c = Class.forName("com.io.Student");
		Class<Student> c = Student.class;
		try {
			// 创建对象
			Object o = c.newInstance();
			// 获取属性
			Field[] fields= c.getDeclaredFields();
			for (Field field : fields) {
				System.out.println("属性:"+field.getName());
			}
			// 获取方法
			Method[] methods= c.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println("方法:"+method.getName());
			}
			// 操作属性 -- 若是private报异常
			/*Field f1 = c.getDeclaredField("gender");
			f1.set(o, "男");
			Field f2 = c.getDeclaredField("name");
			f2.set(o, "ver");
			Field f3 = c.getDeclaredField("age");
			f3.set(o, 25);*/
			
			// 操作方法-- 若是不存在报异常
			/*Method method = c.getDeclaredMethod("show"); // 获取方法名,不带参数
			Object returnvalue = method.invoke(o); // 执行方法,不带返回值
			System.out.println(returnvalue);*/
			
			// 利用封装方法对私有属性进行赋值
			/*Method method = c.getDeclaredMethod("setName",String.class);
			method.invoke(o, "ver");*/
			c.getDeclaredMethod("setName",String.class).invoke(o, "ver");
			c.getDeclaredMethod("setAge",String.class).invoke(o, "20");
			c.getDeclaredMethod("setGender",String.class).invoke(o, "male");

			Method method2 = c.getDeclaredMethod("toString"); // 获取方法名,不带参数
			Object returnvalue = method2.invoke(o); // 执行方法,不带返回值
			System.out.println(returnvalue);
			
			// 通过构造实例化
			Constructor<Student> constructor = c.getConstructor(String.class, String.class, String.class);
			Student newInstance = constructor.newInstance("atum","22","male");
			System.out.println(newInstance);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void tr3() {
		// 输入不能有空格
		LeaveAMessage lam = new LeaveAMessage();
		lam.menu();
	}
	@After
	public void after() {
		input.close();
	}
}
