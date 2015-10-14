<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Question</title>
</head>
<body align="center">
	<%@ include file="header.jsp" %>
	
	<br>
	
	<h1>Question: <c:out value="${ randomCard.question }"></c:out> </h1> <br>
	
	<h1><button onclick="window.location.href=
					'${ pageContext.request.contextPath }/viewAnswer.jsp';">Show Answer</button></h1>
					
	
</body>
</html>