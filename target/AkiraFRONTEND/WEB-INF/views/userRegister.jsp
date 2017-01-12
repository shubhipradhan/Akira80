<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Akira | HOME </title>

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
<link rel="stylesheet" href="static/css/tg.css" />

<!-- Custom Styling -->
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">



<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp" %>
<div class="col-xs-6">
<img src="<s:url value="/static/img/ring2.JPG" />" />

</div>
<div class="col-xs-6">
	<h1>User Registration</h1>
<br>
<br>
	<c:url var="addAction" value="/users/add"></c:url>



	<form:form action="${addAction}" modelAttribute="user">



		<table class="table table-hover">
			<c:if test="${!empty user.username}">
				<tr class="info">
					<td><form:label path="userId">
							<spring:message text="userId" />
						</form:label></td>
					<td><form:input path="userId" readonly="true" size="8"
							disabled="true" /> <form:hidden path="userId" /></td>
				</tr>
				<br>
			</c:if>
			<tr >
			
				<td><form:label path="username">
						<spring:message text="Username :" />
					</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			
			<tr>
				<td><form:label path="password">
						<spring:message text="Password :" />
					</form:label></td>
				<td><form:input path="password" /></td>
			</tr>

			<tr>
				<td><form:label path="name">
						<spring:message text="Name :" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<td><form:label path="mobile">
						<spring:message text="Mobile :" />
					</form:label></td>
				<td><form:input path="mobile" /></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty user.username}">
						<input type="submit"  value="<spring:message text="Edit User"/>" />
					</c:if> 
					<br>
					<c:if test="${empty user.username}">
						<input type="submit" class="btn btn-primary" value="<spring:message text="Regiter with Us"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>

</div>

</body>
</html>