<%@page import="com.news.service.impl.NewInfoServiceImpl"%>
<%@page import="com.news.service.NewInfoService"%>
<%@page import="com.news.entity.NewInfo"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
try{
  //实现上传解析请求
   FileItemFactory fif=new DiskFileItemFactory();
   ServletFileUpload sfu=new ServletFileUpload(fif);
   List<FileItem> items=sfu.parseRequest(request);
   //上传文件
   FileItem fitem=items.get(4);
   String savePath=application.getRealPath("upload");  //设置保存路径
   String fileName=fitem.getName();  //获取文件名称
   String extName=fileName.substring(fileName.lastIndexOf("."));  //文件的扩展名
   String saveFileName=System.currentTimeMillis()+extName; //保存文件名
   File savefile=new File(savePath+"\\"+saveFileName);  //创建保存的文件对象
   fitem.write(savefile);  //上传
   
   //创建实体
   NewInfo newinfo=new NewInfo();
   newinfo.setN_title(items.get(1).getString("utf-8"));
   newinfo.setN_content(items.get(2).getString("utf-8"));
   newinfo.setN_author(items.get(3).getString("utf-8"));
   newinfo.setN_type(items.get(0).getString());
   //设置保存图片的路径
   newinfo.setN_pic(saveFileName); //????
   
   //保存数据库
   NewInfoService newInfoService=new NewInfoServiceImpl();
   int temp=newInfoService.addNewInfo(newinfo);
   if(temp>0){
	   response.sendRedirect("addNews.jsp"); 
   }
   else
   {  
	   //失败
	   savefile.delete();  //删除文件
	   response.sendRedirect("addNews.jsp");
   }   
   
}catch(Exception e){
	response.sendRedirect("addNews.jsp");
}
%>