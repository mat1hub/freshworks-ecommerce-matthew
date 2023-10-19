<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
  
  
  flex:30%;
  float: left;
  width: 25%;
  padding: 0 10px;
}

.price {
  color: grey;
  font-size: 22px;
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.card button:hover {
  opacity: 0.7;
}
/* Remove extra left and right margins, due to padding */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .card {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}​

</style>
</head>
<body>

<div class="row">
<c:forEach var="mylist" items="${requestScope.productList}">
<div class="card">


  <img src='<c:out value="${mylist.productImage}"/>'  alt='<c:out value="${mylist.productName}"/>' style="width:100%">
  <h1><c:out value="${mylist.productName}"/></h1>
  <p class="price"><c:out value="${mylist.buyPrice}"/></p>
  <p><c:out value="${mylist.productDescription}"/></p>
  <p><button>Add to Cart</button></p>
</div>
</c:forEach>
</div>
</body>
</html>
