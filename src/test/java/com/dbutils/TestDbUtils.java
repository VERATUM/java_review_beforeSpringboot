package com.dbutils;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDbUtils {
	// 测试c3p0数据源,以及dbutils工具
	// 获取QueryRunner对象
	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	Scanner input;
	String sql;
	int temp;
	List<Grade> gradeList;
	Grade grade;
	@Before
	public void before() {
		input = new Scanner(System.in);
		gradeList = null;
		grade = null;
		temp = 0 ;
	}
	@Test
	public void gradeInsert() {
		try {
			System.out.print("输入要添加的年级编号:");
			int gid = input.nextInt();
			input.nextLine();
			System.out.print("输入要添加的年级名称:");
			String gname = input.nextLine();
			
			sql = "INSERT INTO grade (gid,gname) VALUES (?,?)";
			temp = qr.update(sql,new Object[]{gid,gname});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String res = (temp != 0)?"insert ok":"insert fail";
		System.out.println(res);
	}
	@Test
	public void gradeSelectAll() {
		sql  = "SELECT gid,gname FROM grade";
		try {
			gradeList = qr.query(sql,new BeanListHandler<>(Grade.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < gradeList.size(); i++) {
			System.out.println(gradeList.get(i));
		}
	}
	@Test
	public void gradeSelectOne() {
		sql = "SELECT gid,gname FROM grade where gid = ?";
		try {
			grade = qr.query(sql, new BeanHandler<>(Grade.class),1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(grade);
	}
	@Test
	public void studentInsert() {
		sql =  "INSERT INTO student(id,name,age,birthday,state,gid)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			System.out.print("输入学生id(int<=11):");
			int id = input.nextInt();
			input.nextLine();
			System.out.print("输入学生name(string<=20):");
			String name = input.nextLine();
			System.out.print("输入学生age(int<=3):");
			int age = input.nextInt();
			input.nextLine();
			
			System.out.print("输入学生birthday(date 2019/1/12):");
			String time = input.nextLine();
			@SuppressWarnings("deprecation")
			Date birthday = new Date(time);
			
			System.out.print("输入学生state(int<=1):");
			int state = input.nextInt();
			input.nextLine();
			System.out.print("输入学生gid(int<=11):");
			int gid = input.nextInt();
			input.nextLine();
			
			Object[] objects = new Object[] {id,name,age,birthday,state,gid};
			temp = qr.update(sql,objects);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String res = (temp != 0)?"insert ok":"insert fail";
		System.out.println(res);
	}
	@After
	public void after() {
		input.close();
	}
}
