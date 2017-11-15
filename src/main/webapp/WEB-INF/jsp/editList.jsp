<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript">
function updateItems() {
	document.itemsForm.action = "${pageContext.request.contextPath }/item/updatelist.action"
	document.itemsForm.submit();
}
</script>
</head>
<body> 
<form name="itemsForm" action="${pageContext.request.contextPath }/item/query.action" method="post">
查询条件：
<table width="100%" border=1>
	<%-- <tr>
		<td>
			类别
			<select name="itemsType">
			<c:forEach items="${itemsType}" var="itemtype" >
				<option value=${itemtype.key}>${itemtype.value}</option>
			</c:forEach>
			</select>
		</td>
	</tr> --%>
<tr>
<td>
<input type="submit" value="查询"/>
<input type="button" value="批量修改" onclick="updateItems()" />
</td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>选择</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>

</tr>
<c:forEach items="${itemsList}" var="item" varStatus="s">
<tr>
	<td><input type="hidden" name="itemsList[${s.index }].id" value="${item.id}" /></td>
	<td><input type="text" name="itemsList[${s.index }].name" value="${item.name}" /></td>
	<td><input type="text" name="itemsList[${s.index }].price" value="${item.price}" /></td>
	<td><input type="text" name="itemsList[${s.index }].createtime"  value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
	<td>${item.detail }</td>
	
	<td><a href="${pageContext.request.contextPath }/item/edit.action?id=${item.id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>