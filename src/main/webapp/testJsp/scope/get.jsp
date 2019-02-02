<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%@ include file = "set.jsp" %> --%>
<%
	// 1. session接收
	Object o1 = session.getAttribute("s_info");
	// 2. application接收
	Object o2 = application.getAttribute("a_info");
	// 3. request接收
	Object o3 = request.getAttribute("r_info");
	String s = request.getParameter("varname");
	// 4. page接收
	Object o4 = pageContext.getAttribute("p_info");
%>
get 页面
<hr/>
session:<%=o1 %><br/>
application:<%=o2 %><br/>
request:<%=o3 %><br/>
page:<%=o4 %><br/>
request参数:<%=s %><br/>
cookie的取出:<%
// 5. 获取cookie
Cookie[] cookies = request.getCookies();
String cv = null;
if(cookies != null){
	for(Cookie c:cookies){
		//out.print("键:"+c.getName()+";值:"+c.getValue()+"<br/>");
		if(c.getName().equals("ver")){
			cv = c.getValue();
			break;
		}
	}
		
}
if(cv == null ){
	out.print("cookie不存在");
}else{
	out.print(cv);
}
%>
</body>
</html>