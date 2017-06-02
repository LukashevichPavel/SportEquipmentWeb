<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin page</title>
<link type="text/css" rel="stylesheet" href="admin_page_style.css">
</head>
<body>

<table width="100%" class = "headertable">
	<tr>
		<td width="50%">
			<div class="header">
	 			<h1>RENT STATION</h1>
				<h4>(by STIVEN)</h4>
			</div>
		</td>
			<td class="centrcolumn" width="20%">
			
			</td>
			<td class="rightcolumn" width="30%">
			<div class = "autoriseduser">
			<p>You login as: <c:out value="${User.getLogin()}" /></p>	
			<p>name: <c:out value="${User.getFirstname()}" /></p>	
			<p>mail: <c:out value="${User.getEmail()}" /></p>
			<p>phone: <c:out value="${User.getTelNumber()}" /></p>
			</div>
			</td>
	</tr>
	</table>
 
<table width="100%" class="maintable">
	<tr >
		<td class="leftcolumn" width=40%>
			<h2>ALL ORDERS:</h2>
		</td>
		<td class="centrcolumn" width="30%">
			
		</td>
		<td class="rightcolumn" width="30%">
			
		</td>
	</tr>
	<tr>
		<td class="rightcolumn">
			<table class="ordertable">
				<tr>
					<th>OrderId</th>
					<th>UserId</th>
					<th>EquipmentId</th>
					<th>Date Start</th>
					<th>Date End</th>
					<th>Status</th>
				</tr>
				<c:forEach items="${list_orders}" var="i">
				<tr> 
					<!--  <td><c:out value="${list_eq.indexOf(i)}"/></td>-->
					<td><c:out value="${i.getOrderId()}" /></td>
					<td><c:out value="${i.getUserId()}" /></td>
					<td><c:out value="${i.getEquipmentId()}" /></td>
					<td><c:out value="${i.getDateStart()}" /></td>
					<td><c:out value="${i.getDateEnd()}" /> </td>
					<td><c:out value="${i.getStatus()}" /> </td>
				</tr>
				</c:forEach>
			</table>
		</td>
		<td>
			<form action="MainServlet" method="GET">
				<input type="hidden" name="action" value="make_order">
				<input class="makeorder" type="submit" value="Make order">
			</form>
			<form action="MainServlet" method="GET">
				<input type="hidden" name="action" value="close_order">
				<input class="closeorder" type="submit" value="Close order">
			</form>
			<form action="MainServlet" method="GET">
				<input type="hidden" name="action" value="edit_order">
				<input class="editorder" type="submit" value="Edit order">
			</form>
			<form action="MainServlet" method="GET">
				<input type="hidden" name="action" value="delete_order">
				<input class="deleteorder" type="submit" value="Delete order">
			</form>
		</td>
	</tr>
</table>
		
</body>
</html>