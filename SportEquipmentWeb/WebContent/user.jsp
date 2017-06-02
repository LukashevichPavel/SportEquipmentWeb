<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
<link type="text/css" rel="stylesheet" href="user.css">
</head>
<body>
	<table width="100%" class="headertable">
		<tr>
			<td width="50%">
				<div class="header">
					<h1>RENT STATION</h1>
					<h4>(by STIVEN)</h4>
				</div>
			</td>
			<td class="centrcolumn" width="20%"></td>
			<td class="rightcolumn" width="30%">
				<div class="autoriseduser">
					<p>
						You login as:
						<c:out value="${user.getLogin()}" />
					</p>
					<p>
						name:
						<c:out value="${user.getFirstname()}" />
					</p>
					<p>
						mail:
						<c:out value="${user.getEmail()}" />
					</p>
					<p>
						phone:
						<c:out value="${user.getTelNumber()}" />
					</p>
					<form action="MainServlet" method="GET">
						<input type="hidden" name="action" value="logout"> <input
							type="submit" value="logout" name="logout">
					</form>
				</div>
			</td>
		</tr>
	</table>
	<table width="100%" class="maintable">
		<tr>
			<td class="leftcolumn" width="50%">
				<h2>TODAY IS AVIALIBLE:</h2>
			</td>
			<td class="centrcolumn" width="20%"></td>
			<td class="rightcolumn" width="30%">
				<h2>Here can be your advertising</h2>
			</td>
		</tr>
		<tr>
			<td class="rightcolumn">
				<table class="equiptable">
					<tr>
						<th>#id</th>
						<th>Category</th>
						<th>Name</th>
						<th>is Avialible</th>
						<th>RentPrice</th>
						<th>LostPrice</th>
					</tr>
					<c:forEach items="${list_eq}" var="i">
						<tr>
							<!--  <td><c:out value="${list_eq.indexOf(i)}"/></td>-->
							<td><c:out value="${i.getEquipmentId()}" /></td>
							<td><c:out value="${i.getCategory()}" /></td>
							<td><c:out value="${i.getTitle()}" /></td>
							<td><c:out value="${i.isAvialible()}" /></td>
							<td><c:out value="${i.getRentPrice()}" /></td>
							<td><c:out value="${i.getLostPrice()}" /></td>
							<!-- <td><form>	<input type="checkbox" /></form></td> -->

						</tr>
					</c:forEach>
				</table>
			</td>
			<td>
				<form action="MainServlet" method="GET">
					<input type="hidden" name="action" value="make_order"> <input
						class="makeorder" type="submit" value="Make order">
				</form>
			</td>
		</tr>
	</table>


	<!-- 
<form action="MainServlet" method="GET">
 <input type="hidden" name="action" value="create_order"/>
 <input type="text" name="user_id"/>
 <input type="text" name="equipment_id"/>
 <input type="text" name="date_Start"/>
 <input type="text" name="date_End"/>
 <input type="submit" name="make order"/>
</form>

 -->


</body>
</html>