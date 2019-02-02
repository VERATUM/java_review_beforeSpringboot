<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>列车信息</title>
	<style type="text/css">
		table{
			text-align: center;
		}
		tr:nth-of-type(even){
			background-color:lightgray;
		}
		tr:nth-of-type(odd) {
			background-color:aqua;
		}
	</style>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		$(function () {
			// 实现表格隔行换色
			$("tr:even").each(function (i,obj) {
				// each函数
                $(obj).bind({"mouseenter":function () {
                        $(this).css("background-color","lightyellow");
                    },"mouseleave":function () {
                        $(this).css("background-color","aqua");
                    }
                });
            });
            $("tr:odd").each(function (i,obj) {
                // each函数
                $(obj).bind({"mouseenter":function () {
                        $(this).css("background-color","lightyellow");
                    },"mouseleave":function () {
                        $(this).css("background-color","lightgray");
                    }
                });
            });
            //实现删除
		})
	</script>
</head>
<body>
<c:if test="${allTrain==null}">
	<p align="center"><a href="TrainInfoServlet">查看所有详情</a></p>
</c:if>
<form action="TrainInfoServlet2?action=delTrain" method="post">
<c:if test="${allTrain!=null}">
	<table border=2 cellpadding="5" align="center">
		<tr>
			<td><input type="submit" value="删除"/></td>
			<td>车次</td>
			<td>发车--到达</td>
			<td>发时--到时</td>
			<td>车型</td>
			<td>运行时间(小时)</td>
		</tr>
		<c:forEach items="${allTrain}" var="u">
			<tr>
				<td><input type="checkbox" name="del" value="${u.train_no}"/></td>
				<td><a href="TrainInfoServlet?action=checkOneTrain&id=${u.train_no}">${u.train_no}</a></td>
				<td>${u.start_station}--${u.arrival_station}</td>
				<td>${u.start_time}--${u.arrival_time}</td>
				<td>${u.type}</td>
				<td>${u.runtime}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</form>
</body>
</html>