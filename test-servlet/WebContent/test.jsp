<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-2.1.0.js"></script>
</head>
<body>
	<form action="/testServlet">
		<input type="text" name="content">
		<input type="submit" value="提交">
	</form>
	<input type="button" value="点击试试" onclick="testSend()"/>
	<span id="console">
	</span>
</body>
</html>

<script>
	function testSend() {
		$.ajax({  
            type : "GET",  //提交方式  
            async: true ,
            url : "http://localhost:8080/test-servlet/testServlet",//路径  
            success : function(result) {//返回数据根据结果进行相应的处理  
            	$("#console").append(result);
            }  
        });  
	}
</script>