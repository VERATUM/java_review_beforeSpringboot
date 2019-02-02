package com.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.service.NewInfoService;
import com.news.service.impl.NewInfoServiceImpl;

/**
 * Servlet implementation class DelNewInfoServlet
 */
@WebServlet("/news/DelNewInfoServlet")
public class DelNewInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// DelNewInfoServlet
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelNewInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String n_id = request.getParameter("n_id");
		NewInfoService newInfoService = new NewInfoServiceImpl();
		int temp = newInfoService.delNewInfo(Integer.parseInt(n_id));
		// 返回json格式
		out.print("{\"res\":" + temp + "}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
