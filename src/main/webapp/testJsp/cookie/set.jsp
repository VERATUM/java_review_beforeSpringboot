<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="get.jsp">a href to get.jsp</a>
<% 
	Cookie[] cookies = new Cookie[3];
	cookies[0] = new Cookie("msg","hello");
	cookies[1] = new Cookie("name","ver");
	cookies[2] = new Cookie("age","25");
	for(int i = 0; i < cookies.length ; i++)
		response.addCookie(cookies[i]);
%>
</body>
</html>