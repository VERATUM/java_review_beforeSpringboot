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
<title>add news</title>
</head>
<body>
<form action="addNewsServlet" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <p>类型:
    <select name="select" id="select">
     <%
        NewTypeService ns=new NewTypeServiceImpl();
        List<NewType> types=ns.queryNewType();
        for(NewType nt:types){
        	%>
        	<option value="<%=nt.gettId()%>"><%=nt.gettName() %></option>
        	<%
        }
     %>
    </select>
  </p>
<p>标题:
  <input type="text" name="textfield" id="textfield" />
</p>
  <p>内容:
    <textarea name="textarea" id="textarea" cols="45" rows="5"></textarea>
  </p>
  <p>作者 :
    <input type="text" name="textfield2" id="textfield2" />
  </p>
  <p>图片;
    <input type="file" name="fileField" id="fileField" />
  </p>
  <p>
    <input type="submit" name="button" id="button" value="提交" />
  </p>
  <p>&nbsp;</p>
</form>
</body>
</html>