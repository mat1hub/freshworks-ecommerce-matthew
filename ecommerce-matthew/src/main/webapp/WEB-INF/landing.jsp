<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Matthews Ecommerce site</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

/* Style the body */
body {
  font-family: Arial;
  margin: 0;
}

/* Header/logo Title */
.header {
  padding: 20px;
  text-align: center;
  background: #1abc9c;
  color: white;
}

/* Style the top navigation bar */
.navbar {
  display: flex;
  background-color: #333;
}

/* Style the navigation bar links */
.navbar a {
  color: white;
  padding: 14px 20px;
  text-decoration: none;
  text-align: center;
}

/* Change color on hover */
.navbar a:hover {
  background-color: #ddd;
  color: black;
}

/* Column container */
.row {  
  display: flex;
  flex-wrap: wrap;
}

/* Create two unequal columns that sits next to each other */
/* Sidebar/left column */
.side {
  flex: 30%;
  background-color: #f1f1f1;
  padding: 20px;
}

/* Main column */
.main {
  flex: 70%;
  background-color: white;
  padding: 20px;
}

/* Fake image, just for this example */
.fakeimg {
  background-color: #aaa;
  width: 100%;
  padding: 20px;
}

/* Footer */
.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
}

/* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 700px) {
  .row, .navbar {   
    flex-direction: column;
  }
}
</style>
</head>
<body>



<!-- Header -->
<div class="header">
  <h1>Matthew's Ecommerce Site</h1>
  
</div>

<!-- Navigation Bar -->
<div class="navbar">
  <a href="./landing.do?page=profile">Profile</a>
  <a href="./landing.do?page=orders">Orders</a>
  <a href="./landing.do?page=shoppingcart">Shopping Cart</a>
  <a href="./landing.do?page=products">Products</a>
   <a href="./logout.do">Logout</a>
</div>

<!-- The flexible grid (content) -->
<div class="row">
  <div class="side">
    <h2>About Me</h2>
    <h5>Photo of me:</h5>
    <img src="./images/store.png" class="fakeimg" style="height:200px;"/>
    <p>An Online Retail store to meet all your fashion needs</p>
    <h3>Best Price</h3>
    <p>We always work to provide the products in best prize</p>
    <!-- <div class="fakeimg" style="height:60px;">Image</div><br>
    <div class="fakeimg" style="height:60px;">Image</div><br>
    <div class="fakeimg" style="height:60px;">Image</div>-->
  </div>
  <div class="main">
  ${requestScope.page}
  
  <c:choose>  
    <c:when test="${requestScope.page == 'profile'}">  
       <jsp:include page="profile.jsp"/> 
    </c:when>  
    <c:when test="${requestScope.page == 'shoppingcart'}">  
        <jsp:include page="shoppingcart.jsp"/>
    </c:when>  
    <c:when test="${requestScope.page == 'orders'}">  
        <jsp:include page="orders.jsp"/>
    </c:when> 
    <c:otherwise>  
       <jsp:include page="products.jsp"/> 
    </c:otherwise>  
</c:choose>
  
  </div>
</div>

<!-- Footer -->
<div class="footer">
  <h2>Copyright 2023 rights reserved</h2>
</div>



</body>
</html>


