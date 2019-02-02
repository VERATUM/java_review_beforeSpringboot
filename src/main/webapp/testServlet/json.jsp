<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSON的格式:数组与对象</title>
</head>
<body>
<script>
	/*JSON的格式:数组与对象*/
	var str = ["湖北","上海","string"];
	var obj = {"name":"ver","age":25,"gender":"male"};
	for (var i = 0; i < str.length; i++) {
		document.write("str:"+str[i]+"<br/>");
	} 
	document.write("name:"+obj.name
			+"<br/> age:"+obj.age
			+"<br/> gender:"+obj.gender);
</script>
</body>
</html>