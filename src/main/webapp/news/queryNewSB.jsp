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
<title>新闻查询结果</title>
<link rel="stylesheet" type="text/css" href="css/queryNewType.css">
</head>
<body>
查询结果如下:<hr/>
<div id="show_info">
	<div class="layer01">
		<table border=1><!-- cellspacing=0 cellpadding=5 -->
			<tr>
				<td>新闻编号</td>
				<td>新闻类别</td>
				<td colspan="2">操作</td>
			</tr>
			<%
				String number = request.getParameter("number");
				int curPage = number==null?1:Integer.parseInt(number);
				int pageSize = 6;
				NewTypeService newTypeService = new NewTypeServiceImpl();
				List<NewType> list = newTypeService.queryNewType(curPage, pageSize);
				int total = newTypeService.queryNewTypePage(pageSize);
				for(NewType nt:list){
			%>
			<tr align="center">
				<td><%=nt.gettId() %></td>
				<td><%=nt.gettName() %></td>
				<td><a href="#" onclick="if(confirm('确定要删除吗？')){location.href='queryNewSBcheck.jsp?t_id=<%=nt.gettId()%>'};">删除</a></td>
				<td><a href="showUpdateNewType.jsp?t_id=<%=nt.gettId() %>">修改</a></td>
				</tr>
				<%}%>
		</table>
		<p> 导航栏:当前页面是第<%=curPage %>页,每页信息为<%=pageSize %>条,共<%=total %>页</p>
		<p>
			<a href="queryNewSB.jsp?number=1">首页</a> 
			<%if(curPage-1 != 0) {%>
				<a href="queryNewSB.jsp?number=<%=curPage-1==0?1:(curPage-1)%>">上一页 </a>
			<%}else {%>
				<a>上一页 </a>
			<%} %>
			<%if(curPage+1 <= total) {%>
				<a href="queryNewSB.jsp?number=<%=curPage+1>total?total:(curPage+1)%>">下一页</a>
			<%}else{ %>
				<a>下一页 </a>
				<%} %>
			<a href="queryNewSB.jsp?number=<%=total%>">尾页</a> 
		</p>
		<p>
			请选择页码:<select onchange="location.href='queryNewSB.jsp?number='+this.value;">
				<!--<option>选择页码</option> -->
			<%
				for(int i=1;i<=total;i++){
			%>
				<option <%=i==curPage?"selected":"" %> value="<%=i %>"><%="第"+i+"页" %></option>
				<%} %>
			</select>
		</p>
	</div>
	<div class="layer02">
		<select>
		<%
			for(NewType nt:list){
		%>
			<option value=<%=nt.gettName()%>><%=nt.gettName()%></option>
		<%}%>
		</select>
	</div>
	<div class="layer03">
		<p>类别:</p>
		<ul id="ul1">
		<%
			for(NewType nt:list){
		%>
			<li><%=nt.gettName()%><li>
		<%}%>
		</ul>
		<p>新闻要闻:</p>
		<ul id="ul2">
			<li>标题</li>
			<li>作者</li>
			<li>时间</li>
		<%
			NewInfoService newInfoService = new NewInfoServiceImpl();
			List<NewInfo> list_ni = newInfoService.queryNewInfo();
			for(NewInfo ni:list_ni){
		%>
			<li><%=ni.getN_title() %></li>
			<li><%=ni.getN_author() %></li>
			<li><%=ni.getN_time() %></li>
			<%} %>
		</ul>
	</div>
</div>

</body>
</html>