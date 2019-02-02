package com.trainSys.dao;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
/* 数据库配置为mysql8.0，jar包为8.0的
 配置driver不同为com.mysql.cj.jdbc.Driver
 若是mysql5.0版本，请更改jar包以及jdbc.properties配置文件*/
public class BaseDao {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static Connection conn;
	private static QueryRunner qr = new QueryRunner();

	static{
		Properties properties = new Properties();
		InputStream is = null;
		try {
			is = BaseDao.class.getClassLoader().getResourceAsStream("trainJdbc.properties");
			properties.load(is);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(is!=null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection getConn(){
		conn = null;
		try {
			DbUtils.loadDriver(driver);
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 增加、修改、删除单条数据
	 * @param sql 编写的sql语句
	 * @param params 传递的参数
	 * @return 返回影响的行数
	 */
	public static int updateDemo(String sql,Object...params){
		int temp = 0;
		try {
			conn = getConn();
			temp = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDemo(conn);
		}
		return temp;
	}

	/**
	 * 查询所有数据
	 * @param sql 编写的sql语句
	 * @param t 与数据库对应的实体类
	 * @param <T> 实体类
	 * @return 返回查询结果集合
	 */
	public static <T>List<T> selectDemos(String sql, Class<T> t){
		List<T> list = null;
		try {
			conn =getConn();
			list = qr.query(conn, sql, new BeanListHandler<T>(t));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDemo(conn);
		}
		return list;
	}
	public static <T>T selectDemo(String sql,Class<T> t,Object...params){
		T tClass = null;
		try {
			conn = getConn();
			tClass = qr.query(conn, sql, new BeanHandler<T>(t), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDemo(conn);
		}
		return tClass;
	}
	/**
	 * 关闭连接对象
	 * @param conn 连接对象
	 */
	public static void closeDemo(Connection conn){
		try {
			if (conn != null)
				DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
