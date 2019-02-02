<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show new type</title>
<style>
	tr{
		text-indent: 36px;
	}
	ul{
		list-style-type: square;
	}
	ul li:nth-of-type(odd){
		color:red;
	}
	
</style>
</head>
<body>
<c:if test="${list==null}">
	<a href="ShowNewTypeServlet">显示</a>
</c:if>
<table border=1 style="width:80%;text-align: center">
	<tr>
		<td>新闻编号</td>
		<td>新闻类别</td>
	</tr>
	<c:forEach items="${list}" var="t">
		<tr>
			<td>${t.tId}</td>
			<td>${t.tName}</td>
		</tr>
		<tr>
			<td colspan="2">
				<ul>
					<c:forEach items="${t.newInfos }" var="n">
						<li>${n.n_title}</li>
						<li>${n.n_content} 123</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>