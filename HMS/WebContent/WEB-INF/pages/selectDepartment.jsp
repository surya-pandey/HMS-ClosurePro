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
	<form action="/HMS/getDoctorList" method="post">
		<select name="department">
								<option value="Cardiologist"/>Cardiologist
								<option value="Dermatologist"/>Dermatologist
								<option value="Physician"/>Physician
								<option value="Neurologist"/>Neurologist
								<option value="Oncologist"/>Oncologist
								<option value="Obstetrician"/>Obstetrician
								<option value="Opthalmologist"/>Opthalmologist
								<option value="Pathologist"/>Pathologist
								<option value="Pediatrician"/>Pediatrician
								</select>
		<input type="submit" value="submit">
	</form>
	<br>
	<br>
	<br>
	<div>
		<c:choose>
		<c:when test="${empty doctorList }">
			<h4>No Doctors Available</h4>
		</c:when>
		<c:otherwise>
	<table>
		<c:forEach items="${doctorList}" var="doctor">
			<tr><td>Doctor Id </td><td> : </td><td>${doctor.doctorId}</td></tr>
			<tr><td>Speciality </td><td> : </td><td> ${doctor.department}</td></tr>
			<tr><td>First Name </td><td> : </td><td> ${doctor.firstName}</td></tr>
			<tr><td>Last Name</td><td> : </td><td> ${doctor.lastName}</td></tr>
		<tr><td>====</td><td> ==== </td><td>====</td></tr>
		</c:forEach>
	</table>
	</c:otherwise>
	</c:choose>
	</div>
	<br>
	<br>
	<br>
	<div>
		<a href="/HMS/formForScheduleBooking">Book An Appointment</a>
	</div>
	<br><br><br>
		<a href="/HMS/backToPatientMenu">Go Back to Main Menu</a>
</body>
</html>