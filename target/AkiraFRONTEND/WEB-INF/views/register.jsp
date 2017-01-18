<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>User Page</title>
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
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">



<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: soluserId;
	border-wuserIdth: 1px;
	overflow: huserIdden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: soluserId;
	border-wuserIdth: 1px;
	overflow: huserIdden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>


	<h1>Add a User</h1>

	<c:url var="addAction" value="/users/add"></c:url>



	<form:form action="${addAction}" modelAttribute="user"
		enctype="multipart/form-data" >



		<table>
			<c:if test="${!empty user.username}">
				<tr>
					<td><form:label path="userId">
							<spring:message text="userId" />
						</form:label></td>
					<td><form:input path="userId" readonly="true" size="8"
							disabled="true" /> <form:hidden path="userId" /></td>
				</tr>
			</c:if>
			<tr>
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

		<%-- 	<tr>
				<td><form:label path="userimage">
						<spring:message text="Image" />
					</form:label></td>
				<td><form:input type="file" path="userimage" /></td>
			</tr> --%>
			<%--  <tr>
			<td><input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /></td>
			</tr> --%>
			<tr>
				<td colspan="2"><c:if test="${!empty user.username}">
						<input type="submit" value="<spring:message text="Edit User"/>" />
					</c:if> <c:if test="${empty user.username}">
						<input type="submit" value="<spring:message text="Add User"/>" />
					</c:if></td>
			</tr>

		</table>
	</form:form>
	<br>
	<h3>Users List</h3>
	<c:if test="${!empty listUsers}">
		<table class="tg table table-hover">
			<tr class="info">
				<th wuserIdth="80">User Id</th>
				<th wuserIdth="120">User Name</th>
				<th wuserIdth="120">Password</th>
				<th wuserIdth="120">Name</th>
				<th wuserIdth="120">Role</th>
				<th wuserIdth="120">Enabled</th>
				<th wuserIdth="120">Mobile</th>

				<th wuserIdth="60">Edit</th>
				<th wuserIdth="60">Delete</th>
			</tr>
			<c:forEach items="${listUsers}" var="user">
				<tr class="success">
					<td>${user.userId}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.name}</td>
					<td>${user.role}</td>
					<td>${user.enabled}</td>
					<td>${user.mobile}</td>

					<td><a href="<c:url value='/edit/${user.userId}' />">Edit</a></td>
					<td><a href="<c:url value='/remove/${user.userId}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>