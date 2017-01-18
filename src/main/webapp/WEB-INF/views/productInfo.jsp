<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.2/angular.min.js"></script>
<style>
body {
	font-family: "Arial";
}
</style>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>ProductInfo</title>
</head>
<body ng-app="addToCartApp">
	<%@include file="Header.jsp"%>
	<div class="col-xs-6"></div>
	<div class="col-xs-6" ng-controller="addToCartCtrl">
		<h2>Product :</h2>
		<h3>${product.productName }</h3>

		<h2>Product Brand</h2>
		<h3>${product.brand}</h3>

		<h2>Product Category</h2>
		<h3>${product.category}</h3>

		<h2>Product Description</h2>
		<h3>${product.desc}</h3>

		<h2>Product Price</h2>
		<h3>${product.price}</h3>
		<br>
		<!-- <a class="btn btn-primary"
			ng-click="addItemToCart('{$product.productId}')" href="order">Add
			To Cart</a> -->
			
			<%-- <a class="btn btn-primary" href="<c:url value='/AddtoCart/${product.productId}' />">Cart</a> --%>
			
			<a class="btn btn-primary" href="cart_checkout">Checkout</a>
	</div>
</body>
</html>