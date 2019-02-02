<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		var notice = $("#notice").html();
		if (!notice.equals("")) {
			$("input").val("");
		}
	});
</script>
</head>
<body>
<form action="UploadServlet" method="post" enctype="multipart/form-data" name="form1">
	用户:<input type="text" name="user"><br/>
	编号:<input type="text" name="uid"><br/>
	文件:<input type="file" name="upic"><br/>
	<input type="submit" value="提交">
</form>
<p id="notice">
	<c:if test="${msg!=null}">
		${msg}
	</c:if>
</p>
<a href="DownloadServlet?filename=湖北ver.jpg">ver</a>
</body>
</html>