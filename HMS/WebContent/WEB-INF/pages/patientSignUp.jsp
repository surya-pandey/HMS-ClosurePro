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
	<table>
	<f:form action="/HMS/addNewPatient" modelAttribute="patient" method="post">
	<tr><td>	Enter First Name: </td><td><f:input path="firstName"/></td></tr>
	<tr><td>	Enter Last Name: </td><td><f:input path="lastName"/></td></tr>
	<tr><td>	Enter Password: </td><td><f:input path="patientPassword"/></td></tr>
	<tr><td>	Enter Phone Number : </td><td><f:input path="phoneNumber"/></td></tr>
	<tr><td>	If Any Medical History : </td><td><f:textarea path="medicalHistory"/></td></tr>
	<tr><td><input type="submit" value="submit"/></td></tr>
	</f:form>
</table>
</body>
</html>