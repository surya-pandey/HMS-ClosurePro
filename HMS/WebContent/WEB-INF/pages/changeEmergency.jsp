<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/HMS/updateEmergencyNumber" method="post">
		Enter New Emergency Number : <input type="text" name="newEmergencyNumber">
		<input type="submit" value="submit">
	</form>
	<br><br><br>
		<a href="/HMS/backToDoctorMenu">Go Back to Main Menu</a>
</body>
</html>