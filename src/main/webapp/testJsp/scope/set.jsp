<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四大作用域</title>
</head>
<body>
<%
	String str = "hello";
	// 1.session
	session.setAttribute("s_info", str);
	// 2.application
	application.setAttribute("a_info", str);
	// 3.request
	request.setAttribute("r_info", str);
 	Cookie cookie = new Cookie("ver",str);
	cookie.setMaxAge(15);
	response.addCookie(cookie); 
	//request.getRequestDispatcher("get.jsp").forward(request, response);
	// 4.page
	pageContext.setAttribute("p_info", str);
%>
<a href="get.jsp?varname=<%=str%>">进入get界面</a>
</body>
</html>