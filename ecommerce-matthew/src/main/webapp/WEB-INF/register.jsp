
<%@page import="java.util.ResourceBundle"%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matthew Retail Store</title>
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
<link rel="stylesheet" href="./css/style.css">
</head>
<%
	ResourceBundle rb=(ResourceBundle)application.getAttribute("rb");
%>
<body>
	
	
	<div class="login-form">
  <form action="register.do" method="post">
    <h1>Login</h1>
    <div class="content">
    <input type="hidden" name="formid" value="register">
      <div class="input-field">
      	
        <input type="text" name="uname" placeholder="<%=rb.getString("username") %>" autocomplete="nope">
      </div>
      <div class="input-field">
        <input type="password" name="upass" placeholder="<%=rb.getString("password") %>" autocomplete="new-password">
      </div>
      
    </div>
    <div class="action">
      <button>Register</button>
      
    </div>
  </form>
</div>
<!-- partial -->
  <script  src="./js/script.js"></script>
	
</body>

</html>