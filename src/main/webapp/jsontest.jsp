<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Json test</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
function requestJson() {
	$.ajax({
		url:"${pageContext.request.contextPath }/requestJson.action",
		type:"post",
		contentType:"application/json;charset=utf-8",
		data:'{"name":"笔记本", "price":5888}',
 		success:function(data){
			alert(data.name);
		} 
	});
}

function responseJson(){
	
	$.ajax({
		url:"${pageContext.request.contextPath }/responseJson.action",
		type:"post",
		//contentType:"application/json;charset=utf-8",
		//请求key/value数据
		data:"name=手机&price=1999",
		success:function(data){
			
			alert(data.name);
		}
		
		
	});
	
}
</script>
</head>
<body> 

<input type="button" value="请求json返回json" onclick="requestJson()" />
<input type="button" value="请求key/value,返回json" onclick="responseJson()" />


</body>

</html>