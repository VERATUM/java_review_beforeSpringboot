<%@page import="com.news.entity.NewType"%>
<%@page import="com.news.service.impl.NewTypeServiceImpl"%>
<%@page import="com.news.service.NewTypeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String tName = request.getParameter("t_name");
	NewType nt = new NewType();
	nt.settName(tName);
	NewTypeService newTypeService = new NewTypeServiceImpl();
	int temp = newTypeService.addNewType(nt);
	if(temp > 0)
		out.print("<script>alert('添加成功');location.href='addNewType.jsp'</script>");
	else
		out.print("<script>alert('添加失败');location.href='addNewType.jsp'</script>");
%>