<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=cp1251"\>
<title>Register page</title>
<link type="text/css" rel="stylesheet" href="register.css">
</head>
<body>
<h1>
	Регистрация нового килента
</h1>
<table>
<form action="MainServlet" method="POST" class="create_user">
	<tr>
		<td><label for="login">Логин:</label></td>
		<td> <input id="login" type="text" name="login" /> </td>
	</tr>
	<tr>
		<td><label for="password">Пароль:</label></td>
		<td><input type="password" name="pass" /></td>
	</tr>
	<tr>
		<td><label for="password2">Повторите пароль:</label></td>
		<td><input type="password" name="pass2" /></td>
	</tr>
	<tr>
		<td><label for="email">Email:</label> </td>
		<td><input type="text" name="email" /> </td>
	</tr>
	<tr>
		<td><label for="firstname">Фамилия:</label> </td>
		<td><input type="text" name="firstname" /> </td>
	</tr>
	<tr>
		<td><label for="lastname">Имя:</label> </td>
		<td><input type="text" name="lastname" /></td>
	</tr>
	<tr>
		<td><label for="adress">Адресс:</label> </td>
		<td><input type="text" name="adress" /></td>
	</tr>
	<tr>
		<td> <label for="telnumber">Номер телефона для связи:</label> </td>
		<td> <input type="text" name="telnumber" /> </td>
	</tr>
	<tr>
	<td> <label for="passport">Серия и номер паспорта:</label> </td>
		<td> <input type="text" name="passport" /> </td>	
	</tr>	
	<tr>
		<td>
				
		</td>
		<td>
			<input type="hidden" value="create_user" name="action" /> 
			<input class="but1" type="submit" value="Register" />
		</td>	
	</tr>
	</form>
</table>
<p>Все поля являются обязательными для заполнения</p>
	
	
</body>
</html>