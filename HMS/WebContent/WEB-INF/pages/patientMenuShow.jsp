<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <form action="/HMS/patientMenuChoice" method="post">
		<select name="patientChoice">
			<option value="bookAppointment"/>Book Appointment
			<option value="getDoctorEmergencyNumber"/>Get Doctor Emergency Number
			<input type="submit" value="Submit">
	</form>	

<br><br><br>
	<a href="/HMS/patientLogout">LogOut</a>
	
</body>
</html>