package com.trainSys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainSys.dao.TrainInfoDao;
import com.trainSys.dao.impl.TrainInfoDaoImpl;
import com.trainSys.entity.TrainInfo;

/**
 * Servlet implementation class TrainInfoServlet
 */
@WebServlet("/testTrain/TrainInfoServlet")
public class TrainInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 公用dao层
	TrainInfoDao trainInfoDao = new TrainInfoDaoImpl();
	/* 数据库配置为mysql8.0，jar包为8.0的
	 配置driver不同为com.mysql.cj.jdbc.Driver
	 若是mysql5.0版本，请更改jar包以及jdbc.properties配置文件*/
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 设置格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// 2. 挑选
		String action = request.getParameter("action");
		if (action==null) {
			action = "showAllTrain";
		}
		switch (action) {
			case "checkOneTrain":
				this.checkOneTrain(request, response);
				break;
			case "delTrain":
				this.delTrain(request, response);
			break;
			case "showAllTrain":
				this.showAllTrain(request, response);
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
	// 显示所有信息
	protected void showAllTrain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.查询所有车次
		List<TrainInfo> allTrain = trainInfoDao.getAllTrain();
		request.setAttribute("allTrain", allTrain);
		// 2.返回数据
		request.getRequestDispatcher("TrainList.jsp").forward(request, response);
	}
	// 查单条
	protected void checkOneTrain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取id
		String id = request.getParameter("id");
		// 查单条
		TrainInfo train = trainInfoDao.finTrain(Integer.valueOf(id));
		request.setAttribute("train", train);
		request.getRequestDispatcher("ShowTrain.jsp").forward(request, response);
	}
	// 删除
	protected void delTrain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] strs = request.getParameterValues("del");
		PrintWriter out = response.getWriter();
		if (strs ==null) {
			out.print("<script>alert('请选择车次');window.location.href='TrainInfoServlet';</script>");
		}else {
			for (int i = 0; i < strs.length; i++) {
				String str = strs[i];
				// 删除选中的数据
				int row = trainInfoDao.delTrain(Integer.valueOf(str));
				if (row>0) {
					out.print("<script>alert('删除成功');window.location.href='TrainInfoServlet';</script>");
				}else {
					out.print("<script>alert('删除失败');window.location.href='TrainInfoServlet';</script>");
				}
			}
		}
	}

}
