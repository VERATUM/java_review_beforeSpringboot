<%@page import="com.news.service.impl.NewTypeServiceImpl"%>
<%@page import="com.news.service.NewTypeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    int t_id = Integer.parseInt(request.getParameter("t_id"));
	NewTypeService newTypeService = new NewTypeServiceImpl();
	int temp = newTypeService.delNewType(t_id);
	if(temp > 0)
		out.print("<script>alert('删除成功');location.href='queryNewSB.jsp';</script>");
	else
		out.print("<script>alert('删除失败');locaton.href='queryNewSB.jsp'</script>");
%>