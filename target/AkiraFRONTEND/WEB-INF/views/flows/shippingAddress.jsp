<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3>Shipping Details :</h3>
        <form:form  modelAttribute="shippingAddress">
             <table>
                <tr>
                    <td><form:label path="line1">Line1 : </form:label></td>
                    <td><form:input path="line1"/></td>
                </tr>
                <tr>
                    <td><form:label path="line2">Line2 : </form:label></td>
                    <td><form:input path="line2"/></td>
                </tr>
                <tr>
                    <td><form:label path="country">Country : </form:label></td>
                    <td><form:input path="country"/></td>
                </tr>
                <tr>
                    <td><form:label path="state">State : </form:label></td>
                    <td><form:input path="state"/></td>
                </tr>
                <tr>
                    <td><form:label path="city">City : </form:label></td>
                    <td><form:input path="city"/></td>
                </tr>
                <tr>
                    <td><form:label path="zipcode">ZipCode : </form:label></td>
                    <td><form:input path="zipcode"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="_eventId_submitShippingAddress" value="save"/></td>
                </tr>
            </table>
        </form:form>
    
</body>
</html>