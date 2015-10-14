<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<script src="fieldsValidation.js"></script>
	<h1>User Registration</h1>
	
	<!-- EL statement to evaluate a message object that is stored in either a page, request, session, or application
		scoped attribute. This shows an optional error message to the user if a username is already taken.-->
	<div><h3>${ message }</h3></div>
	
	<!-- The html form contains our input fields to submit to the RegistrationServlet. The URL mapping for the servlet is 
		 /registration.  -->
	<form action="${pageContext.request.contextPath}/registration" onsubmit="return checkForm(this);" method="POST" >
	
		<table align="center">
		
			<tr>
			
				<td><h1>Username:</h1></td>
				<td><h1><input type="text" name="username" id="username" /></h1></td>
			
			</tr>
			
			<tr>
			
				<td><h1>Password:</h1></td>
				<td><h1><input type="password" name="password" id="password" /> </h1></td>
			
			</tr>
			
			<tr>
			
				<td><h1><input type="submit" value="Register" style="width: 100%; "/></h1></td>
				<td><h1><a href="${ pageContext.request.contextPath }/login.jsp">Login</a></h1></td>
			
			</tr>
		
		</table>
	
	</form>
</body>
</html>