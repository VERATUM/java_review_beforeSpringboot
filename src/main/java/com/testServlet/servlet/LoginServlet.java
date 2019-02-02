package com.testServlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testServlet.util.MD5Utils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/testServlet/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		switch (action) {
		case "login":
			this.login(request, response);
			break;
		case "add":
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String validate = request.getParameter("validate");
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute("randomCode");
		if (code.equals(validate)) {
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			request.setAttribute("login_info", "账号或密码有误");
			String encrypt = MD5Utils.md5Encrypt("123");
			if ("admin".equals(user)&&encrypt.equals(MD5Utils.md5Encrypt(password))) {
				session.setAttribute("user", user);
				session.setAttribute("password", encrypt);
				request.getRequestDispatcher("success.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("login_info", "验证码有误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
