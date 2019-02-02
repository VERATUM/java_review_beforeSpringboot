<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
<i>
<% Object o = request.getAttribute("info");
	if(o !=null) out.print(o);
%>
</i>
<form action="uploadAction.jsp" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <p>文件名称:
    <input type="text" name="pname" id="textfield" />
  </p>
  <p>文件:
    <input type="file" name="fileField" id="fileField" />
    <input type="submit" name="button" id="button" value="提交" />
  </p>
</form>
<a href="fileupload.jsp">刷新</a>
</body>
</html>