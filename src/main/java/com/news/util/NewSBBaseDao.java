package com.news.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class NewSBBaseDao {
    /**
     * 连接属性
     */
    private static String driverClass = null;
    private static String url = null;
    private static String name = null;
    private static String password = null;
    /**
     *  JDBC连接对象
     */
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * 加载属性配置
     */
    static {
        InputStream is =null;
        try {
            Properties properties = new Properties();
            //is = new FileInputStream("trainJdbc.properties");
            is = NewSBBaseDao.class.getClassLoader().getResourceAsStream("trainJdbc.properties");
            properties.load(is);
            driverClass = properties.getProperty("driver");
            url = properties.getProperty("url");
            name = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 建立连接
     * @return
     */
    private Connection getCon(){
        try {
            Class.forName(driverClass);
            con = DriverManager.getConnection(url,name,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 增、删、改的方法
     * @param sql
     * @param paras
     * @return 返回影响行数
     */
    public int exeUpdate(String sql,Object paras[]){
        int temp = 0;
        try {
            con = this.getCon();
            ps = con.prepareStatement(sql);
            if (paras != null){
                for (int i = 0; i < paras.length; i++) {
                    ps.setObject((i+1),paras[i]);
                }
            }
            temp = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("输入有误");
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return temp;
    }

    /**
     * 查询的方法
     * @param sql
     * @param paras
     * @return 返回结果集
     */
    public ResultSet exeQuery(String sql,Object paras[]){
        try {
            con = this.getCon();
            ps = con.prepareStatement(sql);
            if (paras != null){
                for (int i = 0; i < paras.length; i++) {
                    ps.setObject(i+1,paras[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 资源释放，关闭所有
     */
    public void closeAll(){
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (ps!=null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps = null;
        }
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = null;
        }
    }
}
