package com.testServlet.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(description = "process of upload.jsp", urlPatterns = { "/testServlet/UploadServlet" })
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int size = 1024*1024*10;
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(!isMultipart) {
				System.out.println("enctype类型有错");
				response.sendRedirect("upload.jsp");
				return;
			}
			FileItemFactory fif = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(fif);
			sfu.setSizeMax(size);
			// 解析
			List<FileItem> items = sfu.parseRequest(request);
			/*FileItem item1 = items.get(0);
			FileItem item2 = items.get(1);
			FileItem item3 = items.get(2);
			
			String user = item1.getString("UTF-8");
			String uid = item2.getString("UTF-8");
			String upic = item3.getName();
			System.out.println(user+"|"+uid+"|"+upic);*/
			// Iterator迭代器
			Iterator<FileItem> iterator = items.iterator();
			String user = null;
			String uid = null;
			String upic = null;
			
			while(iterator.hasNext()) {
				FileItem item = iterator.next();
				String fieldName = item.getFieldName();// 表单名
				if (item.isFormField()) {
					if (fieldName.equals("user")) {
						user = item.getString("UTF-8");// 表单的值
					} else if(fieldName.equals("uid")) {
						uid = item.getString("UTF-8");
					} else {
						System.out.println("no form data");
					}
				} else {
					// 获取文件名
					upic = item.getName();
					if(upic!="") {
						//"F:\\java_fileio"
						String pathname = request.getServletContext().getRealPath("upload");
						String t = user+uid+"t"+System.currentTimeMillis();
						File file = new File(pathname,t+upic);
						item.write(file);
						System.out.println(upic+"上传成功");
						request.setAttribute("msg", upic+"上传成功");
						return;
					} else {
						request.setAttribute("msg", upic+"上传失败");
						System.out.println(upic+"上传失败");
						return;
					}
					
				}
			}
		} catch (Exception e) {
			// 上传文件过大，宕机??
			e.printStackTrace();
			System.out.println("文件过大，超出"+size/1024/1024+"M最大限制");
		} finally {
			request.getRequestDispatcher("upload.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
