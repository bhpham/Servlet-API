<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>
	<!--  Get CardUser object from the session attribute -->
	<jsp:useBean id="cardUser" class="net.mv.flashcard.domain.CardUser" scope="session" ></jsp:useBean>
	
	<!--  Get the username property from the CardUser object, then output it to the screen -->
	Hello, <jsp:getProperty property="username" name="cardUser" /> <br>

	<!--  Static include/ Directive to import the header.jsp
		  which contains various links in our application
	 -->
	<%@ include file="header.jsp" %>
	
	
	
	
</body>
</html>