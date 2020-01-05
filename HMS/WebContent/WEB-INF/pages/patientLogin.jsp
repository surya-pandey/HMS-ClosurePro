<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		${errorMessage}
<table>
		<form action="/HMS/patientMenu" method="post">
			<tr><td>Enter Id : </td><td><input type="text" name="id"></td></tr>
			<tr><td>Enter Password : </td><td><input type="password" name = "password"></td></tr>
			<tr colspan = "2"><td><input type="submit" name="submit"></td></tr>
		</form>
		<tr><td><a href="/HMS/goForSignup">Click Here for SignUp</a></td></tr>
	</table>


</body>
</html>