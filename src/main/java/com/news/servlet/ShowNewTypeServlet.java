package com.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.entity.NewType;
import com.news.service.NewTypeService;
import com.news.service.impl.NewTypeServiceImpl;

/**
 * Servlet implementation class ShowNewTypeServlet
 */
@WebServlet("/news/ShowNewTypeServlet")
public class ShowNewTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowNewTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 查询所有新闻以及其所属类别
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		NewTypeService newTypeService = new NewTypeServiceImpl();
		List<NewType> list = newTypeService.queryNewInfosBlongNewType();
		request.setAttribute("list", list);
		request.getRequestDispatcher("showNewType.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
