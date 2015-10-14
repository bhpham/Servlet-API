<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FlashCardApp</title>
</head>
<body>
	<h1>User Login</h1>
	<div>${ message }</div>
	
	<form action="/FlashCardApp/login" method="POST">
	
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
				<td><a href="/FlashCardApp/register.jsp">Register</a></td>
			</tr>
			
		</table>
	
	</form>
</body>
</html>