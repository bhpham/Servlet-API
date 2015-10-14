<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="fieldsValidation.js"></script>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Card</title>
</head>
<body align="center">

	<%@ include file="header.jsp" %>
	
	<br>
	
	<h1>Please enter question and answer:</h1>

	<form action="${pageContext.request.contextPath}/card" onsubmit="return checkMessage(this);" method="POST">
	
	
	
		<table align="center" >
		
			<tr>
			
				<td><h1>Question:</h1></td>
				<td><h3><textarea rows="4" cols="50" name="question" id="question"></textarea> </h3></td>
			
			</tr>
			
			<tr>
			
				<td><h1>Answer:</h1></td>
				<td><h3><textarea rows="4" cols="50" name="answer" id="answer"></textarea></h3></td>
				
			</tr>
			
			<tr>
			
				<td><h1><input type="submit" value="Submit" id="submit"></h1></td>
				
			</tr>
		
		</table>
	
	
	
	</form>

</body>
</html>