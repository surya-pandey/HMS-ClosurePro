<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5 color="red">${errorMessage}</h5>
	<table>
	
		
		<form action="/HMS/adminMenu">
			<tr><td>Enter Username : </td><td><input type="text" name="uname"></td></tr>
			<tr><td>Enter Password : </td><td><input type="password" name = "password"></td></tr>
			<tr colspan = "2"><td><input type="submit" name="submit"></td></tr>
		</form>
	</table>
	
</body>
</html>