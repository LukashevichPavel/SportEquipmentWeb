<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page orders</title>
<link type="text/css" rel="stylesheet" href="user.css">

<script type="text/javascript">
function clock() {
var d = new Date();
var month_num = d.getMonth()
var day = d.getDate();
var hours = d.getHours();
var minutes = d.getMinutes();
var seconds = d.getSeconds();

month=new Array("january", "february", "march", "april", "may", "june",
		"july", "august", "september", "october", "november", "december");

if (day <= 9) day = "0" + day;
if (hours <= 9) hours = "0" + hours;
if (minutes <= 9) minutes = "0" + minutes;
if (seconds <= 9) seconds = "0" + seconds;

date_time = "Today - " + day + " " + month[month_num] + " " + d.getFullYear() +
" .&nbsp;&nbsp;&nbsp; Current Time - "+ hours + ":" + minutes + ":" + seconds;
if (document.layers) {
 document.layers.doc_time.document.write(date_time);
 document.layers.doc_time.document.close();
}
else document.getElementById("doc_time").innerHTML = date_time;
 setTimeout("clock()", 1000);
}
</script>
</head>

<body>
<span id="doc_time">
Date and Time
</span>
<script type="text/javascript">
 clock();
</script>

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
			<p>You login as: <c:out value="${user.getLogin()}" /></p>	
			<p>name: <c:out value="${user.getFirstname()}" /></p>	
			<p>mail: <c:out value="${user.getEmail()}" /></p>
			<p>phone: <c:out value="${user.getTelNumber()}" /></p>
			<form action="MainServlet" method="GET">
				<input type="hidden" name="action" value="logout">
				<input type="submit" value="logout" name="logout">
			</form>
			</div>
			</td>
	</tr>
	</table>
<table width="100%" class="maintable">
	<tr >
		<td class="leftcolumn" width="50%">
			<h2>TODAY IS AVIALIBLE:</h2>
		</td>
		<td class="centrcolumn" width="20%">
			<c:out value="${infomessage}" />
		</td>
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
					<td><c:out value="${i.getRentPrice()}" /> </td>
					<td><c:out value="${i.getLostPrice()}" /> </td>
				</tr>
				</c:forEach>
			</table>
		</td>
		<td>
		<div class="formorder">
			<form action="MainServlet" method="GET">
				<input type="hidden" name="action" value="create_order">
				<p>
					<label>Insert ID Equipment:</label>
					<input type="text" value="1" name="equipment_id">
				</p>
				<p>
					<label>Insert Date Start:</label>
					<br />
				
					<input type="datetime-local" value="alert(new Date())" name="date_start" />
					
					
				</p>
				<p>
					<label>Insert Date End:</label>
					<br />
					<input type="datetime-local" name="date_end">
				</p>
				<p><input class="makeorder" type="submit" value="Make order"></p>
			</form>
		</div>>
		</td>
	</tr>
</table>
</body>
</html>