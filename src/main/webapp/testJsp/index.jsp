<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>testJsp 测试</title>
</head>
<body>
	<p>jsp九大内置对象:<br/>
		1. out<br/>
		2. request<br/>
		3. response<br/>
		4. session<br/>
		5. application<br/>
		6. page<br/>
		7. pageContext<br/>
		8. config<br/>
		9. exception<br/>
		使用
	</p>
	<p>getRequestURI: <%=request.getRequestURI()%></p>
	<p>getProtocol: <%=request.getProtocol()%></p>
	<p>getDispatcherType: <%=request.getDispatcherType()%></p>
	<p>getAuthType: <%=request.getAuthType()%></p>
	<br/>
	<p>getLocalAddr: <%=request.getLocalAddr()%></p>
	<p>getRemoteAddr: <%=request.getRemoteAddr()%></p>
	<p>getCharacterEncoding: <%=request.getCharacterEncoding()%></p>
	<p>getContentLength: <%=request.getContentLength()%></p>
	<br/>
	<p>getLocale: <%=request.getLocale()%></p>
	<p>getContextPath: <%=request.getContextPath()%></p>
	<p>getLocalName: <%=request.getLocalName()%></p>
	<p>getLocalPort: <%=request.getLocalPort()%></p>
	<br/>
	<p>getMethod: <%=request.getMethod()%></p>
	<p>getPathInfo: <%=request.getPathInfo()%></p>
	<p>getPathTranslated: <%=request.getPathTranslated()%></p>
	<p>getQueryString: <%=request.getQueryString()%></p>
	<br/>
	<p>getRemoteHost: <%=request.getRemoteHost()%></p>
	<p>getRemotePort: <%=request.getRemotePort()%></p>
	<p>getRemoteUser: <%=request.getRemoteUser()%></p>
	<p>getRequestURL: <%=request.getRequestURL()%></p>
	<br/>
	<p>getScheme: <%=request.getScheme()%></p>
	<p>getServerName: <%=request.getServerName()%></p>
	<p>ServerPort: <%=request.getServerPort()%></p>
	<p>getUserPrincipal: <%=request.getUserPrincipal()%></p>
	<br/>
	<p>getServletPath: <%=request.getServletPath()%></p>
	<p>getRequestedSessionId: <%=request.getRequestedSessionId()%></p>
	<p>isSecure: <%=request.isSecure()%></p>
	<%
		out.print("<table border = 2");
		for(int i = 1;i<=9;i++){
			out.print("<tr style='border: 1px solid red'>");
				for(int j = 1;j<=i;j++){
					out.print("<td>");
					out.print(j+"×"+i+"="+i*j);
					out.print("</td>");
				}
			out.print("</tr>");
		}
		out.print("</table>");
	%>
</body>
</html>