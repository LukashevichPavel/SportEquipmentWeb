<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Error page</title>
		<link rel="stylesheet" type="text/css" href="error.css">
	</head>
	<body>
		<c:out value="${error_msg}"/>
	</body>
</html>