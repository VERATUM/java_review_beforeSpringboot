<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		/* $("#but1").click(function() {
			$.ajax({
				type: "get",
				//data: ,
				url: "../JsonServlet",
				//dataType: "json",
				success: function(data) {
					$("#show").html(data);
				}
			});
		}); */
		$("#but1").click(function() {
			$.post("../JsonServlet",null,function(data){
				var table = "<table border=2>";
				table += "<tr><td>编号</td><td>标题</td><td>时间</td><td>作者</td><td>操作</td></tr>";
                // alert("sss"); 
				for (var i = 0; i < 10; i++) {
					var obj = data[i];
					table += "<tr><td>"+obj.n_id+"</td><td>"+obj.n_title+"</td>"+
					"<td>"+obj.n_time+"</td><td>"+obj.n_author+"</td>"+
					"<td>"+'<input type="button" value="显示详情" id="but2">'+'<input type="hidden" value="'+i+'"">'+"</td></tr>";
				}
				table += "</table>"; 
				table += '<hr/><p><b>编号:</b> <span id="show_id"></span></p>'+
				'<p><b>标题:</b> <span id="show_title"></span></p>'+
				'<p><b>作者:</b> <span id="show_author"></span></p>'+
				'<p><b>时间:</b> <span id="show_time"></span></p>'+
				'<p><b>内容:</b> <span id="show_content"></span></p>';
				$("#show").html(table);
				$("input[id='but2']").click(function() {
					var i = $(this).next().val();
					var obj_i = data[i]
					$("#show_id").html(obj_i.n_id);
					$("#show_title").html(obj_i.n_title);
					$("#show_author").html(obj_i.n_author);
					$("#show_time").html(obj_i.n_time);
					$("#show_content").html(obj_i.n_content).css("color", "red");
				});
			},"json");
		}) 
	})
</script>
</head>
<body>
	<input type="button" value="validate" id="but1"><br/>
	<hr/>
	<div id="show"></div>
</body>
</html>