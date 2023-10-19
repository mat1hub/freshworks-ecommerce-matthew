<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow" style="align:center">
<hr>
	<jsp:include page="logout.jsp"/>
	<hr>
<h1><marquee>Gold Shop</marquee></h1>
	<form action="shopping.do">
		<input type="hidden" name="formid" value="shop">
		<input type="hidden" name="shopid" value="shop3">
		
		<input type="checkbox" name="c7" value="gold chain">Gold Chain
		<input type="checkbox" name="c8" value="gold ring">Gold Ring
		<input type="checkbox" name="c9" value="gold bracelet">Gold Bracelet
		
		<input type="submit" value="Invoice...">
	</form>
</body>
</html>