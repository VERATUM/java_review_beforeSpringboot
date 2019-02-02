<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>success</title>
</head>
<body>
<%--
	${param.uname}等价于<%=request.getParameter("uname")%> 
	${paramValues.uhobbies}等价于<%=request.getParameterValues("uhobbies")%> 
--%>
<p>登陆成功，欢迎 <b>${param.uname}</b></p>
<p>age=<i>${param.age}</i></p>
<p>爱好: <br/>
	${paramValues.uhobbies[0]}<br/>
	${paramValues.uhobbies[1]}<br/>
	${paramValues.uhobbies[2]}<br/>
</p>
</body>
</html>