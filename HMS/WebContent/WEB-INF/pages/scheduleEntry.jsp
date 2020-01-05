<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<f:form action="/HMS/bookSchedule" modelAttribute="schedule" method="post">
	Enter Appointment Date : <f:input path="appDate"/><br>
	Enter Doctor Id: <f:input path="doctorId"/><br>
	Enter Slot :    <f:select path="slot">
							<f:option value="10-11"/>10-11
							<f:option value="11-12"/>11-12
							<f:option value="3-4"/>3-4
							<f:option value="4-5"/>4-5
						</f:select>
						<input type="submit" value="Book Appointment">
	</f:form>
	
	<br><br><br>
		<a href="/HMS/backToPatientMenu">Go Back to Main Menu</a>
</body>
</html>