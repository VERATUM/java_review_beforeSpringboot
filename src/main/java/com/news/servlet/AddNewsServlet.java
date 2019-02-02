package com.news.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.news.entity.NewInfo;
import com.news.service.NewInfoService;
import com.news.service.impl.NewInfoServiceImpl;

/**
 * Servlet implementation class addNewsServlet
 */
@WebServlet("/news/addNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileItemFactory fif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fif);
		List<FileItem> items = null;
		try {
			items = sfu.parseRequest(request);
			FileItem fileItem = items.get(4);
			// 得到路径
			ServletContext application = this.getServletContext();
			String savePath = application.getRealPath("upload");
			String fileName = fileItem.getName(); // 获取文件名称
			String extName = fileName.substring(fileName.lastIndexOf(".")); // 文件的扩展名
			String saveFileName = System.currentTimeMillis() + extName;
			//
			File saveFile = new File(savePath + "\\" + saveFileName);
			fileItem.write(saveFile);

			// 创建实体
			NewInfo newinfo = new NewInfo();
			newinfo.setN_title(items.get(1).getString("utf-8"));
			newinfo.setN_content(items.get(2).getString("utf-8"));
			newinfo.setN_author(items.get(3).getString("utf-8"));
			newinfo.setN_type(items.get(0).getString());
			// 设置保存图片的路径
			newinfo.setN_pic(saveFileName); // ????

			// 保存数据库
			NewInfoService newInfoService = new NewInfoServiceImpl();
			int temp = newInfoService.addNewInfo(newinfo);
			if (temp > 0) {
				response.sendRedirect("addNews.jsp");
			} else {
				// 失败
				saveFile.delete(); // 删除文件
				response.sendRedirect("addNews.jsp");
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
