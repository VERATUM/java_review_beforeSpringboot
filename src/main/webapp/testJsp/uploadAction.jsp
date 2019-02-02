<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
try{
	// 1.创建FileItemFactory对象
	FileItemFactory fif = new DiskFileItemFactory();
	// 2.创建ServletFileUpload
	ServletFileUpload sf = new ServletFileUpload(fif);
	sf.setSizeMax(800*1024);
	
	// 3.解析请求 
	List<FileItem> items=sf.parseRequest(request);
	// 获取普通表单的名称--中文乱码？String pname = items.get(0).getString();
	// 获取文件的对象
	FileItem fi = items.get(1);
	String savePath=application.getRealPath("upload");
	/*try{
		File f = new File(savePath);
		if(!f.exists()){
			f.mkdir();
		}
		String fileName = fi.getName();
		File savefile=new File(savePath+"\\"+fileName);
		fi.write(savefile);
	}catch(Exception e){
		e.printStackTrace();
	}*/
	String fileName = fi.getName();
	String extName=fileName.substring(fileName.lastIndexOf(".")); 
	List<String> uploadFiles = Arrays.asList(".jpg",".jpeg",".gif");
	if(uploadFiles.contains(extName)){
		String saveFileName=System.currentTimeMillis()+extName;
		File savefile=new File(savePath+"\\"+saveFileName);
		fi.write(savefile);
		request.setAttribute("info", "上传成功");
	} else{
		request.setAttribute("info", "上传文件格式不正确，只支持:.jpg,.jpeg,.gif");
	}
	request.getRequestDispatcher("fileupload.jsp").forward(request, response);
} catch(Exception e){
	request.setAttribute("info", "文件太大，不能超过800kb");
	request.getRequestDispatcher("fileupload.jsp").forward(request, response);
}
%>