<%@page import="com.news.entity.NewType"%>
<%@page import="com.news.service.impl.NewTypeServiceImpl"%>
<%@page import="com.news.service.NewTypeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	NewTypeService newTypeService = new NewTypeServiceImpl();
	String tName = request.getParameter("t_name");
	int t_id = Integer.parseInt(request.getParameter("t_id"));
	NewType nt = new NewType();
	nt.settName(tName);
	nt.settId(t_id);
	int temp = newTypeService.updateNewType(nt);
	
	if(temp > 0)
		out.print("<script>alert('修改成功');location.href='queryNewSB.jsp'</script>");
	else
		out.print("<script>alert('修改失败');location.href='queryNewSB.jsp'</script>");
%>