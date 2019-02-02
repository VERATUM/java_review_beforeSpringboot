<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>delete NewInfos</title>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("input[value='delete']").click(function() {
				//异步请求
				//　删除数据库当前的行，同时删除页面中的当前行显示
				// ?取值--通过隐藏域
				var n_id = $(this).next().val();
				var rowNum = $(this).parent().parent();
				if (confirm("要删除"+n_id+"吗")){
					$.post("DelNewInfoServlet",{"n_id":n_id},function(data){
						if (data.res > 0) {
							// 删除页面显示行
							rowNum.remove();
						} else {
							alert("请联系管理员，暂不支持此功能");
						}
					},"json");
				}
			});
		});
	</script>
</head>
<body>
<c:if test="${list==null}">
	<a href="../ShowNewInfosServlet">显示</a>
</c:if>
	<div>
		<table border=1>
			<tr>
				<td>编号nid</td>
				<td>标题ntitle</td>
				<td>作者nauthor</td>
				<td>时间ntime</td>
				<td>图片</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="ni">
				<tr>
					<td>${ni.n_id }</td>
					<td>${ni.n_title }</td>
					<td>${ni.n_author }</td>
					<td>${ni.n_time }</td>
					<td><img src="upload/${ni.n_pic}"/></td>
					<td>
						<input type="button" id="but1" value="delete">
						<input type="hidden" value="${ni.n_id}"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>