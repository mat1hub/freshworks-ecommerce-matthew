<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan" style="align:center">
<hr>
	<jsp:include page="logout.jsp"/>
	<hr>
<h1><marquee>Vegetable Shop</marquee></h1>
	<form action="shopping.do">
		<input type="hidden" name="formid" value="shop">
		<input type="hidden" name="shopid" value="shop2">
		
		<input type="checkbox" name="c4" value="Potato">Potato
		<input type="checkbox" name="c5" value="Tomato">Tomato
		<input type="checkbox" name="c6" value="chillies">Chillies
		
		<input type="submit" value="Next Shop...eee">
	</form>
</body>
</html>