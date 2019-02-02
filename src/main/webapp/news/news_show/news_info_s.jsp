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
			<%
				String n_id = request.getParameter("n_id");
				NewInfoService newInfoService1 = new NewInfoServiceImpl();
				NewInfo ni = newInfoService1.queryNewInfo(Integer.parseInt(n_id));
			%>
			<div class="show"><span>新闻标题:</span><%=ni.getN_title()%></div>
			<div class="show"><span>发布时间:</span><%=ni.getN_time()%></div>
			<div class="show"><span>作者:</span><%=ni.getN_author()%></div>
			<div class="show"><span>正文:</span><%=ni.getN_content()%></div>
			<p><a href="index.jsp"><span>返回主页</span></a></p>
		</div>
	</div>
</body>
</html>