<%@page import="java.util.ArrayList"%>
<%@page import="com.testJsp.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp01作业</title>
<script type="text/javascript">
	window.onload=function(){
		setInterval("linkWeb.innerHTML='现在时刻:'+new Date().toLocaleString()+" +
		        "' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
		setInterval("linkWeb2.innerHTML=new Date().toLocaleString()",1000);
	}
</script>
</head>
<body style="width:800px;margin:0 auto">
	<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");%>
	<div style="color:gray">
		<h3>1.显示时间:</h3>
		<p><%out.print(sdf.format(new Date()));%></p>
		<div id="linkWeb" style="font-size: 16px">
		现在时刻:2018/11/2 下午8:09:31 星期五
		</div>
		<div id="linkWeb2" style="font-size: 16px">
		<% out.print(sdf.format(new Date())); %>
		</div>
	</div>
	<div style="color:lightgray">
		<h3>2.年月日的下拉列表:</h3>
		<p><%
			out.print("<select>");
				for(int i = 1950; i <= 2050; i++){
					if(i == 2018)
						out.print("<option selected='selected' value = "+i+">"+i+"</option>");
					else
						out.print("<option value = "+i+">"+i+"</option>");
				} 
			out.print("</select> 年 ");
			out.print("<select>");
				for(int i = 1; i <= 12; i++){
					if(i == 11)
						out.print("<option selected='selected' value = "+i+">"+i+"</option>");
					else
						out.print("<option value = "+i+">"+i+"</option>");
				} 
			out.print("</select> 月 ");
			out.print("<select>");
				for(int i = 1; i <= 31; i++){
					if(i == 2)
						out.print("<option selected='selected' value = "+i+">"+i+"</option>");
					else
						out.print("<option value = "+i+">"+i+"</option>");
				}
			out.print("</select> 日");
		%></p>
	</div>
	<div style="color:red">
		<h3>3.在网页中显示学生信息</h3>
		<p><% 
			List<Student> list = new ArrayList<Student>();
			Student stu = null;
			for(int i = 1; i <= 5 ; i++){
				stu = new Student();
				stu.setXh(i);
				stu.setName("张"+i);
				stu.setAge(20+i);
				stu.setTel("159-xxxx-101"+i);
				list.add(stu);
			}
		request.setAttribute("list", list);
		out.print("<table border = 2 cellpadding = '5'>");
		out.print("<tr align='center'><td>学号</td><td>姓名</td><td>年龄</td><td>电话</td></tr>");
		for(Student s:list){
			out.print("<tr><td>"+s.getXh()+"</td><td>"+s.getName()+"</td><td>"+s.getAge()+"</td><td>"+s.getTel()+"</td></tr>");
		}
		out.print("</table>");
		%></p>
		<p>EL:==${list[0].xh }==${list[0].name }==${list[0].age }==${list[0].tel }</p>
		<table>
			<caption>JSTL输出流</caption>
			<tr>
				<td>序号</td>
				<td>学号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>电话</td>
			</tr>
			<c:forEach items="${list}" var="u" begin="1" end="3" step="1" varStatus="state">
				<tr>
					<td>${state.index }</td>
					<td>${u.xh }</td>
					<td>${u.name }</td>
					<td>${u.age }</td>
					<td>${u.tel }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>