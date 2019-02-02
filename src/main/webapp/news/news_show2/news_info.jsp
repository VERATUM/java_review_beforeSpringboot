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
				String number = request.getParameter("number");
				int curPage = number == null?1:Integer.parseInt(number);
				int pageSize = 5;
				NewTypeService newTypeService = new NewTypeServiceImpl();
				List<NewType> list = newTypeService.queryNewType(curPage, pageSize);
				int total = newTypeService.queryNewTypePage(pageSize);
				for(NewType nt:list){
			%>
				<li><a href="news_info.jsp?t_id=<%=nt.gettId()%>"><%=nt.gettName()%></a></li>
			<%} %>
			</ul>
			<p class="p1_title">
				请选择页码:<select onchange="location.href='news_info.jsp?number='+this.value;">
					<%--<option>选择页码</option> --%>
				<%
					for(int i=1;i<=total;i++){
				%>
					<option <%=i==curPage?"selected":"" %> value="<%=i %>"><%="第"+i+"页" %></option>
					<%} %>
				</select>
				<a href="news_info.jsp?number=1">首页</a> 
				<%if(curPage-1 != 0) {%>
					<a href="news_info.jsp?number=<%=curPage-1==0?1:(curPage-1)%>">上一页 </a>
				<%}else {%>
					<a style="color:black">上一页 </a>
				<%} %>
				<%if(curPage+1 <= total) {%>
					<a href="news_info.jsp?number=<%=curPage+1>total?total:(curPage+1)%>">下一页</a>
				<%}else{ %>
					<a style="color:black">下一页 </a>
					<%} %>
				<a href="news_info.jsp?number=<%=total%>">尾页</a>
				当前页面是第<%=curPage %>页,每页信息为<%=pageSize %>条,共<%=total %>页
			</p>
		</div>
		<div class="content">
			<p class="p_content">最新新闻</p>
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
				List<NewInfo> list1 = newInfoService.queryNewInfos(Integer.parseInt(t_id==null?(5*curPage-4)+"":t_id));
				for(NewInfo ni:list1){
			%>
				<li><a href="news_info_s.jsp?n_id=<%=ni.getN_id()%>"><%=ni.getN_title()%></a></li>
				<li><%=ni.getN_author()%></li>
				<li><%=ni.getN_time()%></li>
				<%}%>
			</ul>
			<p class="p_content"><a href="index.jsp"><span>返回主页</span></a></p>
		</div>
	</div>
</body>
</html>