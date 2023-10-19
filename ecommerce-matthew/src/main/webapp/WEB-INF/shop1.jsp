<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="red" style="align:center">
<hr>
	<jsp:include page="logout.jsp"/>
	<hr>
<h1><marquee>Fruit Shop</marquee></h1>
	<form action="shopping.do">
		<input type="hidden" name="formid" value="shop">
		<input type="hidden" name="shopid" value="shop1">
		
		<input type="checkbox" name="c1" value="apple">Apple
		<input type="checkbox" name="c2" value="banana">Banana
		<input type="checkbox" name="c3" value="orange">Orange
		
		<input type="submit" value="Next Shop...eee">
	</form>
</body>
</html>