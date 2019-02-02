<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 使用request对象
// 设置编码,使用setCharacterEncoding(String arg1)
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("uname");
String upwd = request.getParameter("upwd");
String age = request.getParameter("age");
String []uhobbies = request.getParameterValues("uhobbies");

// 登录验证
if(name.equals("admin") && upwd.equals("123")){
	// 1.重定向
	// response.sendRedirect("success.jsp");
	// 2.请求转发 涉及作用域参数获取问题
	request.getRequestDispatcher("success.jsp").forward(request,response);
}else{
	//提示
	out.print("<script>alert('登录失败');location.href='login.jsp'</script>");
}
%>