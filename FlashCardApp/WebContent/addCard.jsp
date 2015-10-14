<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Card</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<br>
	<h1>Please enter question and answer:</h1>
	<form action="/FlashCardApp/card" method="POST">
		<table>
			<tr>
				<td>Question: </td>
				<td><textarea rows="4" cols="50" name="question" id="question"></textarea></td>
			</tr>
			<tr>
				<td>Answer: </td>
				<td><textarea rows="4" cols="50" name="answer" id="answer"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" id="submit" ></td>
			</tr>
			
		</table>
	</form>	
</body>
</html>