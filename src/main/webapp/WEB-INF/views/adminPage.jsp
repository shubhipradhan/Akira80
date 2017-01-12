<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Akira | HOME</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<!-- FontAwesome CDN -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- USER DEFINE CSS -->
<link rel="stlesheet" href="static/css/media.css">
<link rel="stylesheet" href="static/css/Navbar.css" />
<link rel="stylesheet" href="static/css/thumbnail.css" />

<!-- Custom Styling -->
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">



</head>
<body>
	<!-- ####################################### HEADER #################################################### -->

	<%@include file="AdminHeader.jsp"%>


	<h2>
		Dear <strong>${user}</strong>, Welcome to Admin Page.
	</h2>
	<%--   <a href="<c:url value="/logout" />">Logout</a>
 --%>
	<div class="row-xs-*">
	
	<!-- ####################### PRODUCT SESSION ######################## -->
		<div class="col-xs-4">
			<h1>Product</h1>
			<h2>
				<a href="product">Product Based Operation</a>
			</h2>
		</div>
		
		<!-- ################################ USER SESSION ######################## -->
		
		<div class="col-xs-4">
			<h1>User</h1>
			<h2>
				<a href="register">User Based Operation</a>
			</h2>
		</div>
		
		<!-- ################################ VENDER ############################ -->
		
		<div class="col-xs-4">
			<h1>Vendor</h1>

		</div>
	</div>

</body>
</html>
