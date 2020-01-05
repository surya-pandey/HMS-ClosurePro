<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty myMap }">
			<h4>No Schedules Available</h4>
		</c:when>
		<c:otherwise>
	<table>
		<c:forEach items="${myMap}" var="schedule">
			<tr><td>Schedule Id </td><td> : </td><td>${schedule.scheduleId}</td></tr>
			<tr><td>Appointment Date</td><td> : </td><td> ${schedule.appDate}</td></tr>
			<tr><td>Doctor Id </td><td> : </td><td> ${schedule.doctorId}</td></tr>
			<tr><td>Patient Id</td><td> : </td><td> ${schedule.patientId}</td></tr>
			<tr><td>	Slot </td><td> : </td><td> ${schedule.patientId}</td></tr>
		<tr><td>====</td><td> ==== </td><td>====</td></tr>
		</c:forEach>
	</table>
	</c:otherwise>
	</c:choose>
	
	<br><br><br>
		<a href="/HMS/backToDoctorMenu">Go Back to Main Menu</a>
	
</body>
</html>