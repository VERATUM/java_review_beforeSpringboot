<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆测试 附带验证码</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("img[name='code']").click(function() {
			$(this).attr("src","code.jsp?a="+Math.random());
		});
	})
</script>
</head>
<body>
	<form action="LoginServlet?action=login" method="post" name="form1" id="form1">
		用户:<input type="text" name="user" ><br/>
		密码:<input type="text" name="password" ><br/>
		验证:<input type="text" name="validate" size="5"> <img name="code" src="code.jsp" title="换一张" style="vertical-align: middle">
		<input type="submit" value="登录">
	</form>
	<div>${login_info }</div>
</body>
</html>