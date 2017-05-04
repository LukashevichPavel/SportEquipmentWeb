<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
</head>
<body>
<p align="center">Welcome User!</p>

<table align="center" border="1">
   <tr>
    <th>#id</th>
    <th>Category</th>
    <th>Name</th>
    <th>is Avialible</th>
    <th>RentPrice</th>
    <th>LostPrice</th>
    <!--  <th>Категория</th>
    <th>Название</th>
    <th>RentPrice</th>
    <th>LostPrice</th>
    <th>Доступность</th> -->
    </tr>
		<c:forEach items="${list_eq}" var="i">
			<h3>
				<tr> 
					<td><c:out value="${list_eq.indexOf(i)}"/></td>
					<td><c:out value="${i.getCategory()}" /></td>
					<td><c:out value="${i.getTitle()}" /></td>
					<td><c:out value="${i.isAvialible()}" /></td>
					<td><c:out value="${i.getRentPrice()}" /> </td>
					<td><c:out value="${i.getLostPrice()}" /> </td>
				</tr>
				</h3>
		</c:forEach>
		</table>
</body>
</html>