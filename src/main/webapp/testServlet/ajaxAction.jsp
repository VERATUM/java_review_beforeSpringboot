<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uname = request.getParameter("uname");
	if(uname.equals("admin")){
		out.print("1");
	}else{
		out.print("0");
	}
%>