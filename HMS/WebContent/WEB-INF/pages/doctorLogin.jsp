<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h5 color="red"><c:out value="${errorMessage}"></c:out> </h5>

<table>
		<form action="/HMS/docLogin" method="post">
			<tr><td>Enter Id : </td><td><input type="number" name="id"></td></tr>
			<tr><td>Enter Password : </td><td><input type="password" name = "password"></td></tr>
			<tr colspan = "2"><td><input type="submit" name="submit"></td></tr>
			<tr><td><a href="/HMS/addDoctor">Click Here for SignUp</a></td></tr>
		</form>
	</table>
	

</body>
</html>