package com.oop.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.oop.asg.AptitudeHandset;
import com.oop.asg.CommonHandset;
import com.oop.pg.Bus;
import com.oop.pg.Car;
import com.oop.pg.ChargeStation;
import com.oop.pg.Emp;
import com.oop.pg.Keyboard;
import com.oop.pg.Manage;
import com.oop.pg.Person;
import com.oop.pg.StudentInfo;
import com.oop.pg.Usb;

public class TestPEI {
	private Logger logger = LogManager.getLogger(TestPEI.class);
	@Test
	public void tp() {
		StudentInfo si = new StudentInfo("1022","vee");
		System.out.println(si);
		System.out.println(si.getName());
	}
	@Test
	public void tp2() {
		// 收费站类型测试
		ChargeStation charge = new ChargeStation();
		Bus bus =new Bus();
		bus.setName("客车");
		bus.setSeat(20);
		
		Bus bus1 = new Car("宝马");
		charge.show(bus);
		
		charge.show(bus1);
	}
	@Test
	public void tp3() {
		// Person类的测试
		// 存3个人
		Person[] personList = new Person[3];
		StudentInfo stu1 = new StudentInfo();
		stu1.setName("ver");
		stu1.setCardNo("101");
		personList[0] = stu1; // 向上转型,父类引用指向子类对象upcasting
		
		// 把指向子类对象的父类引用赋给子类引用叫向下转型(downcasting)，要强制转换
		StudentInfo stu2 = new StudentInfo();
		stu2.setName("veratum");
		stu2.setCardNo("102");
		personList[1] = stu2; // 向上转型
		
		Emp emp = new Emp();
		emp.setName("Veratum");
		emp.setAge(22);
		emp.setGh(154001);
		personList[2] = emp; // 向上转型
		// 显示
		for (int i = 0; i < personList.length; i++) {
			System.out.println(personList[i]);
		}
		System.out.println("--- --- --- --- --- ---");
	}
	@Test
	public void tp4() {
		Manage m = new Manage();
		m.menu();
	}
	@Test
	public void tp5() {
		Usb usb = new Keyboard();
		usb.work();
		usb.show();
		System.out.println(Usb.name);
	}
	@Test
	public void tp6() {
		// 创建智能手机对象
		AptitudeHandset phone1 = new AptitudeHandset();
		phone1.setBrand("iphone");
		phone1.setType("8 plus");
		
		phone1.info();
		phone1.networkConnect();
		phone1.play("视频《盗梦空间》");
		phone1.takePicture();
		phone1.sendInfo();
		phone1.call();
		
		System.out.println("*** *** *** *** *** ***");
		// 创建普通手机对象
		CommonHandset phone2 = new CommonHandset();
		phone2.setBrand("HuaWei");
		phone2.setType("10 pro");
		
		phone2.info();
		phone2.play("音乐《有何不可》");
		phone2.sendInfo();
		phone2.call();
	}
	@Test
	public void tp7() {
		logger.info("这是一个日志测试文件");
		logger.error("哈哈哈哈哈哈---error");
		try {
			int i = 1/0;
			System.out.println(i);
		} catch (Exception e) {
			logger.debug("出现错误:"+e);
		}
	}
	@Test
	public void tp8() {
		// 除法运算
		Scanner input = new Scanner(System.in);
		int res=0;
		try {
			int[] arrs = new int[5];
			System.out.println("--- --- ---");
			arrs[10] = 0;
			System.out.print("请输入被除数:");
			int num1 = input.nextInt();
			System.out.print("请输入除数:");
			int num2 = input.nextInt();
			// 自定义异常
			if (num2 == 5) {
				throw new RuntimeException("除数不能为5");
			}
			// 求商
			res = num1/num2;
		}catch(InputMismatchException e) {
			logger.debug("出现异常"+e);
		}catch(ArithmeticException e) {
			logger.debug("出现异常"+e);
		}catch(Exception e) {
			logger.debug("出现异常"+e);
		}
		finally {
			System.out.println("有错没错都执行");
			input.close();
		}
		System.out.println("商是:"+res);
	}
	
}
