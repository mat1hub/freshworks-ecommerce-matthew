<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
	<jsp:include page="logout.jsp"/>
	<hr>
	<%
		Enumeration e=session.getAttributeNames();
		while(e.hasMoreElements()){
			String name=e.nextElement().toString();
			String value=session.getAttribute(name).toString();
			out.println("<h1>"+name+":"+value+"</h1>");
		}
	
	%>
</body>
</html>