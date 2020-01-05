<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix=c %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result eq true}">
	<h4>Update Was Successful</h4>
	</c:if>
	<c:if test="${result eq false}">
	<h4>Update Was not Successful</h4>
	</c:if>
	
	<br><br><br>
		<a href="/HMS/backToDoctorMenu">Go Back to Main Menu</a>
</body>
</html>