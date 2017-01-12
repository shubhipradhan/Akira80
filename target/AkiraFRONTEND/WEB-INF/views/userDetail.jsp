
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<%@ page isELIgnored="false" %>


<html>
<head>
<head>
	<title>User Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:soluserId;border-wuserIdth:1px;overflow:huserIdden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:soluserId;border-wuserIdth:1px;overflow:huserIdden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<title>Insert title here</title>
</head>
<body>
Welcome

<h2><a href="admin/homePage">homepage accessed by admin</a></h2>
<h2><a href="user/userPage">userpage accessed by admin</a></h2>

<hr>
<h3>Users List</h3>
<form:form  modelAttribute="user">
<table class="tg">
	<tr>
		<th wuserIdth="80">User Id</th>
		<th wuserIdth="120">User Name</th>
		<th wuserIdth="120">Password</th>
		<th wuserIdth="120">Name</th>
		<th wuserIdth="120">Role</th>
		<th wuserIdth="120">Enabled</th>
		<th wuserIdth="120">Mobile</th>
	
		
	</tr>
	<c:forEach items="${listUsers}" var="user">
		<tr>
			<td>${user.userId}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.name}</td>
			<td>${user.role}</td>
			<td>${user.enabled}</td>
			<td>${user.mobile}</td>
			
			
		</tr>
	</c:forEach>
	</table>

</form:form>

</body>
</html>