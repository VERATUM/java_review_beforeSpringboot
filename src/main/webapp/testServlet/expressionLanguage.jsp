<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl</title>
</head>
<body>
<c:if test="${list==null }">
	<a href="ELServlet">查询</a>
</c:if>
<p>通过servlet将request对象的属性传递给jsp显示</p>
<p>通过EL与JSTL显示结果</p>
<p>String字符串str=${str}</p>
<ul>
	<li>user对象:</li>
	<li>id=${requestScope.user.id}=${user["id"]}</li>
	<li>name=${user.name }</li>
	<li>password=${user.password}</li>
	<li>mail=${user.mail}</li>
</ul>
<p>list集合:${list[0].name }</p>
<h2>jstl:Javascript Standrad Tag Library</h2>
<table>
	<tr>
		<td>序号</td>
		<td>id</td>
		<td>用户名</td>
		<td>密码</td>
		<td>mail</td>
	</tr>

	<c:forEach items="${list }" var="user" varStatus="u_state">
	<tr>
		<td>${u_state.index+1 }</td>
		<td>${user.id }</td>
		<td>${user.name }</td>
		<td>${user.password }</td>
		<td>${user.mail }</td>
	</tr>
	</c:forEach>
</table>
<c:if test="${list[0].id>0}">
<p>姓名= ${list[0].name }</p>
</c:if>
</body>
</html>