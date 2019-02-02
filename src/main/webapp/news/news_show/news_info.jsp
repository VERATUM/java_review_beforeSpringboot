<%@page import="com.news.entity.NewInfo"%>
<%@page import="com.news.service.impl.NewInfoServiceImpl"%>
<%@page import="com.news.service.NewInfoService"%>
<%@page import="com.news.entity.NewType"%>
<%@page import="java.util.List"%>
<%@page import="com.news.service.impl.NewTypeServiceImpl"%>
<%@page import="com.news.service.NewTypeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻主页</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<div id="news_show">
		<div class="title">
			<p class="p_title">新闻类别</p>
			<ul id="ul_title">
			<%
				// 新闻标题显示
				NewTypeService newTypeService = new NewTypeServiceImpl();
				List<NewType> list = newTypeService.queryNewType();
				for(NewType nt:list){
			%>
				<li><a href="news_info.jsp?t_id=<%=nt.gettId() %>"><%=nt.gettName()%></a></li>
				<%} %>
			</ul>
		</div>
		<div class="content">
			<p>最新新闻</p>
			<ul id="ul_content_top">
				<li>新闻标题</li>
				<li>作者</li>
				<li>时间</li>
			</ul>
			<ul id="ul_content">
			<%
				//request.setCharacterEncoding("UTF-8");
				String t_id = request.getParameter("t_id");
				NewInfoService newInfoService = new NewInfoServiceImpl();
				List<NewInfo> list1 = newInfoService.queryNewInfos(Integer.parseInt(t_id));
				for(NewInfo ni:list1){
			%>
				<li><a href="news_info_s.jsp?n_id=<%=ni.getN_id()%>"><%=ni.getN_title()%></a></li>
				<li><%=ni.getN_author()%></li>
				<li><%=ni.getN_time()%></li>
				<%}%>
			</ul>
			<p><a href="index.jsp"><span>返回主页</span></a></p>
		</div>
	</div>
</body>
</html>