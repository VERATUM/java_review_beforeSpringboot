<%@page import="com.news.entity.NewType"%>
<%@page import="com.news.service.impl.NewTypeServiceImpl"%>
<%@page import="com.news.service.NewTypeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改新闻类别</title>
</head>
<body>
>> 修改新闻类别
<%
	int t_id = Integer.valueOf(request.getParameter("t_id")).intValue();
	// 取修改类别编号
	NewTypeService newTypeService = new NewTypeServiceImpl();
	NewType nt = null;
	nt = newTypeService.getNewType(t_id);
%>
<form method="post" action="updateNewType.jsp?t_id=<%=nt.gettId()%>">
	添加新闻类别: <input type="text" name="t_name" value="<%=nt.gettName()%>"/> 
	<input type="submit" name="s" value="修改"/>
</form>
</body>
</html>