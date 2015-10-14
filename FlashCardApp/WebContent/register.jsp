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
	<h1>User Registration</h1>
	
	<!--  EL statement to evaluate a message object that is stored in either a page, request, session, or application
		  scoped attribute. This shows an optional error message to the user if a username is already taken  -->
	<div>${ message }</div>
	
	<!--  The html form contains our input fields to submit to the RegistrationServlet. The URL mapping for the servlet is 
		  /registration. -->
	<form action="/FlashCardApp/registration" method="POST">
	
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
				<td><input type="submit" value="Register" /></td>
				<td><a href="/FlashCardApp/login.jsp">Login</a></td>
			</tr>
			
		</table>
	
	</form>
</body>
</html>