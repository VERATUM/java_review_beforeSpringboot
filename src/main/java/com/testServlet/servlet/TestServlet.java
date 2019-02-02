package com.testServlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name="TestServlet",value="/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Override
	public void init() throws ServletException {
		// init初始化,第一次调用servlet时执行,后续调用不执行
		System.out.println("init初始化");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.响应编码格式
		response.setCharacterEncoding("UTF-8");
		// 2.响应返回格式设置
		response.setContentType("text/html");
		// 3.创建out输出对象
		PrintWriter out = response.getWriter();
		// 4.输出语句到网页
		out.print("hello 用servlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@Override
	public void destroy() {
		// 服务器关闭时执行
		System.out.println("destroy销毁");
	}

}
