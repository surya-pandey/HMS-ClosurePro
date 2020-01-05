<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/HMS/doctorChoice" method="post">
		
		<select name="doctorChoice">
			<option value="ownSchedule">Check your own Schedule</option>
			<option value="otherSchedule">Check other Doctor's Schedule</option>
			<option value="changeEmergencyNumber">Update your emergency Number</option>
			<option value="updateSchedule">Update your schedule</option>
		</select>
		
		<input type="submit" value="submit">
	
	</form>
	<br><br><br>
	<a href="/HMS/doctorLogout">LogOut</a>
</body>
</html>