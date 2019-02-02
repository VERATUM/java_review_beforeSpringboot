package com.testServlet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testServlet.entity.User;

/**
 * Servlet implementation class ELServlet
 */
@WebServlet("/testServlet/ELServlet")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = "hello world";
		request.setAttribute("str", str);

		User user = new User(101,"ver","123","ver@123.com");
		request.setAttribute("user", user);
		
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(new User(110,"atum","125","atum@123.com"));
		list.add(new User(121,"vyr","189","vyr@123.com"));
		request.setAttribute("list", list);
		request.getRequestDispatcher("expressionLanguage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
