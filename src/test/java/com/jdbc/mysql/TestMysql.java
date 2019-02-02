package com.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMysql {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/test_java?useSSL=false&serverTimezone=GMT%2B8";
	private String username = "root";
	private String password = "0504";
	
	private Scanner input;
	private String sql;
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	@Before
	public void before() throws Exception {
		input = new Scanner(System.in);
		// 1.加载驱动
		Class.forName(driver);
		// 2.建立连接对象
		con = DriverManager.getConnection(url,username,password);
	}
	
	@Test
	public void insert() throws Exception {
		// sql语句--insert
		sql = "insert into grade (gid,gname) values (?,?)";
		// 3.建立Statement对象
		ps = con.prepareStatement(sql);
		// 4. 设置参数 使用ps.setxxx(位置,设置值)方法 ,position从1开始
		System.out.print("输入年级编号:");
		ps.setInt(1,input.nextInt());
		System.out.print("输入年级名称:");
		input.nextLine();// 占用上次的回车
		ps.setString(2,input.nextLine());
		// 5. 执行sql语句
		int row = ps.executeUpdate();
		// 6. 得到返回结果
		if (row > 0) 
			System.out.println("insert完成");
		else
			System.out.println("insert异常");
	}
	@Test
	public void delete() throws Exception {
		sql = "delete from grade where gid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.print("输入要删除的年级编号:");
		ps.setInt(1, input.nextInt());
		int row = ps.executeUpdate();
		String res = (row!= 0)?"成功":"失败";
		System.out.println("delete"+res);
	}
	@Test
	public void update() throws Exception {
		sql = "update grade set gname = ? where gid = ?";
		ps = con.prepareStatement(sql);
		System.out.print("输入年级编号:");
		ps.setInt(2,input.nextInt());
		System.out.print("输入年级名称:");
		input.nextLine();// 占用上次的回车
		ps.setString(1,input.nextLine());
		int row = ps.executeUpdate();
		String res = (row!= 0)?"成功":"失败";
		System.out.println("update"+res);
	}
	@Test
	public void selectAll() throws Exception {
		sql = "select gid,gname from grade";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		// --显示结果,rs为结果集对象，内部为指针，指向数据库数据
		boolean flag = false;
		if(flag = rs.next()) {
			System.out.println("查询结果存在:如下");
			System.out.println("年级编号\t年级名称");
			while(flag) {
				System.out.println(rs.getInt("gid")+"\t"+rs.getString("gname"));
				flag = rs.next();
			}
		} else
			System.out.println("查询结果不存在");
	}
	@After
	public void after() throws Exception {
		input.close();
		// 关闭资源
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
		if (con != null)
			con.close();
	}
}
