<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>个体详情</title>
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
		})
	</script>
</head>
<body>
	<table border=2 cellpadding="5" align="center">
		<tr>
			<td colspan="2">火车车次详情</td>
		</tr>
		<tr>
			<td>车次</td>
			<td>${train.train_no}</td>
		</tr>
		<tr>
			<td>发车--到达</td>
			<td>${train.start_station}--${train.arrival_station}</td>
		</tr>
		<tr>
			<td>发时--到时</td>
			<td>${train.start_time}--${train.arrival_time}</td>
		</tr>
		<tr>
			<td>车型</td>
			<td>${train.type}</td>
		</tr>
		<tr>
			<td>运行时间</td>
			<td>${train.runtime}</td>
		</tr>
		<tr>
			<td>公里</td>
			<td>${train.mile}</td>
		</tr>
	</table>
	<hr/>
	<a href="TrainInfoServlet">返回</a>
</body>
</html>