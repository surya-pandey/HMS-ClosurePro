<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<f:form action="/HMS/updateSchedule" modelAttribute="updatedSchedule" method="post">
		<table>
		<tr><td>Enter Date </td><td> : </td><td><f:input path="appDate"/></td></tr>
		<tr><td>Enter Schedule Id which you want to change </td><td> : </td><td><f:input path="scheduleId"/> </td></tr>
		<tr><td>Choose Slot Option </td><td> : </td><td> <f:select path="slot">
			<f:option value="10-11"/>10-11
			<f:option value="11-12"/>11-12
			<f:option value="3-4"/>3-4
			<f:option value="4-5"/>4-5
			<f:option value = "NotBooked"/>Not Booked
			</f:select>
		</table>
		<input type = "submit" value="Save Changes">
		
		</f:form>
		
		<br><br><br>
		<a href="/HMS/backToDoctorMenu">Go Back to Main Menu</a>
		
</body>
</html>