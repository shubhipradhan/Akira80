<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<%@ page isELIgnored="false" %>
<html>
<head>
	<title>Product Page</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</head>
<body>
<br>
<br>
<div class="container">
<h2>
	Add a Product
</h2>
</div>
<c:url var="addAction" value="/product/add" ></c:url>



<form:form action="${addAction}" modelAttribute="product">

<center>

<table>
	<c:if test="${!empty product.productName}">
	<tr>
		<td>
			<form:label path="productId">
				<spring:message text="ProductId"/>
			</form:label>
		</td>
		<td>
			<form:input path="productId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="productId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="productName">
				<spring:message text="  ProductName"/>
			</form:label>
		</td>
		<td>
			<form:input path="productName" />
			
		</td> 
	</tr>
	
	<tr>
		<td>
			<form:label path="brand">
				<spring:message text="  Brand"/>
			</form:label>
		</td>
		<td>
			<form:input path="brand" />
			
		</td> 
	</tr>
	
	<tr>
		<td>
			<form:label path="category">
				<spring:message text="  Category"/>
			</form:label>
		</td>
		<td>
			<form:input path="category" />
			
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="desc">
				<spring:message text="  Description"/>
			</form:label>
		</td>
		<td>
			<form:input path="desc" />
			
		</td> 
	</tr>	
	
	<tr>
		<td>
			<form:label path="price">
				<spring:message text="  Price"/>
			</form:label>
		</td>
		<td>
			<form:input path="price" />
			
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty product.productName}">
				<input type="submit"
					value="<spring:message text="Edit product"/>" />
			</c:if>
			<c:if test="${empty product.productName}">
				<input type="submit"
					value="<spring:message text="Add product"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</center>
</form:form>
<br>
<!-- ############################## PRODUCT TABLE ################################-->
<center><h3>Products List</h3></center>
<c:if test="${!empty listProducts}">
<div class="container">
	<table class="tg table table-hover">
	<tr class="info">
		<th wproductIdth="80">Product Id</th>
		<th wproductIdth="120">ProductName</th>
		<th wproductIdth="120">Brand</th>
		<th wproductIdth="120">Category</th>
		<th wproductIdth="120">Description</th>
		<th wproductIdth="120">Price</th>
		<th wproductIdth="60">Edit</th>
		<th wproductIdth="60">Delete</th>
	</tr>
	<c:forEach items="${listProducts}" var="product">
		<tr class="success">
			<td>${product.productId}</td>
			<td>${product.productName}</td>
			<td>${product.brand}</td>
			<td>${product.category}</td>
			<td>${product.desc}</td>
			<td>${product.price}</td>
			<td><a href="<c:url value='/product/edit/${product.productId}' />" >Edit</a></td>
			<td><a href="<c:url value='/product/remove/${product.productId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	</div>
</c:if>


</body>
</html>