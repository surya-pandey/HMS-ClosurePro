<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/HMS/getEmergencyNumber" method="post">
	Enter Doctor Id : <input type="text" name="docId"/>
	<input type="submit" value="Get Emergency Number"/> 
	</form>
	
	<br>
	<br>
	Emergency Number : ${emergencyNumber}
	
	<br><br><br>
		<a href="/HMS/backToPatientMenu">Go Back to Main Menu</a>
</body>
</html>