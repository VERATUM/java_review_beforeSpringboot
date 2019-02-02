<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax异步请求</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function checkName() {
		// 获取传输对象值
// 		var uname = document.getElementById("uname").value;
		var uname = $("#uname").val();
		/* var usp = $("#uname").val();
		alert("123:"+usp);  */
		// 1.创建ajax 异步对象
		var req = new XMLHttpRequest();
		// 2.指定请求方式与地址
		req.open("get","ajaxAction.jsp?uname="+uname,true);
		// 3.设置回调函数
		req.onreadystatechange=function(){
			// a 判断是否有返回请求
			if(req.readyState == 4 && req.status ==200){
				// 4.接收返回数据
				var data = req.responseText;
				/* alert("data是:"+data); */
				if(data == 1)
					document.getElementById("notice").innerHTML="1-repeat";
				else
					document.getElementById("notice").innerHTML="1-fail";
			}
		}
		// 5.发送请求
		req.send();
	}
	$(function() {
		// 加载
		$("#button2").click(function() {
			var uname = $("#uname").val();
			$.ajax({ 
				type: "get",
				url: "ajaxAction.jsp", 
				data: "uname="+uname, 
				success: function(msg){
			    	if (msg == 1) 
						$("#notice").html("2-repeat").css("color","red");
					else 
						$("#notice").html("2-fail").css("color","green");
			}});
		});
		$("#button3").click(function() {
			var uname = $("#uname").val();
			$.post("ajaxAction.jsp",{"uname":uname}, function(msg){
				if (msg == 1) 
					$("#notice").html("3-repeat").css("color","red");
				else 
					$("#notice").html("3-fail").css("color","green");
		          });
		});
	})
</script>
</head>
<body>
<h2>ajax用户名验证</h2>
<p>用户名:<input name="uname" id="uname"> <span id="notice"></span></p>
<p><input type="button" value="validate1" onclick="checkName()" /></p>
<p><input type="button" id="button2" value="validate2" /></p>
<p><input type="button" id="button3" value="validate3" /></p>
</body>
</html>