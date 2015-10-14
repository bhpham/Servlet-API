<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<script src="fieldsValidation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body align="center">
	<h1>User Login</h1>
	<br><br>
	<div><h3>${ message }</h3></div>
	
	<form id='login' action="${pageContext.request.contextPath}/login" method="POST" onsubmit="return checkForm(this);">
	
		<table align="center">
		
			<tr>
			
				<td><h1>Username:</h1></td>
				<td><h1><input type="text" name="username" id="username" /></h1></td>
			
			</tr>
			
			<tr>
			
				<td><h1>Password:</td>
				<td><h1><input type="password" name="password" id="password" /></h1></td>
			
			</tr>
			
			<tr>
			
				<td><h1><input type="submit" value="Login" style="width: 100%";></h1></td>
				<td><h1><a href="${ pageContext.request.contextPath }/register.jsp">Register</a></h1></td>
			
			</tr>
		
		</table>
	
	</form>

</body>
</html>