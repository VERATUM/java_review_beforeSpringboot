package com.testServlet.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * Servlet implementation class DownloadServlet
 */
@SuppressWarnings("restriction")//如果在一个方法或类前面加了这个注释,那么将取消方法或类中的编译器警告,不会出现难看的黄色警告
@WebServlet("/testServlet/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.设置请求格式 -- ?文件只能是服务器上已有的？
		request.setCharacterEncoding("UTF-8");
		// 获取文件--中文文件名称会出现乱码
		String filename = request.getParameter("filename");
		// 2.设置相应消息头
		response.addHeader("content-type", "application/octet-stream");
		// a.分浏览器处理中文乱码问题
		// a1.获取浏览器的头信息,User-Agent信息
		String user_agent = request.getHeader("User-Agent");
		// System.out.println(user_agent);
		if (user_agent.indexOf("firefox") !=-1) {
			// ?火狐浏览器
			response.addHeader("content-disposition", "attachment;filename==?UTF-8?B"+new String(Base64.encode(filename.getBytes("UTF-8")))+"?=");
		}else // 其他浏览器
			response.addHeader("content-disposition", "attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
		// 3.servlet通过文件地址，将文件转为输入流读入servlet中
		InputStream in = getServletContext().getResourceAsStream("/testServlet/res/"+filename);
		// 4.通过输出流将将输入流的文件，输出给用户
		ServletOutputStream os = response.getOutputStream();
		byte[] bs = new byte[1024];
		int len = -1;
		while((len=in.read(bs)) != -1) {
			os.write(bs,0,len);
		}
		os.close();
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
