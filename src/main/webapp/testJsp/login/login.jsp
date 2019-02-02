<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<form action="check.jsp" method="post"> <%--默认为 get方式 --%>
		用户:<input type="text" name="uname"/><br/>
		密码:<input type="password" name="upwd"/><br/>
		年龄:<input type="text" name="age"/><br/>
		爱好:<br/>
			<input type="checkbox" name="uhobbies" value="篮球"/>篮球
			<input type="checkbox" name="uhobbies" value="足球"/>足球
			<input type="checkbox" name="uhobbies" value="羽毛球"/>羽毛球
		<br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>