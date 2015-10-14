<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Cards</title>
</head>
<body align="center">
	<%@ include file="header.jsp" %>
	
	<table align="center" border="1">
	
		<tr>
			<th><h1>Card ID</h1></th>
			<th><h1>Question</h1></th>
			<th><h1>Answer</h1></th>
		</tr>
		
		<c:forEach items="${ cardList }" var="card"> 
			<tr>
				<td><h3><c:out value="${ card.cardId }"></c:out></h3></td>
				<td><h3><c:out value="${ card.question }"></c:out></h3></td>
				<td><h3><c:out value="${ card.answer }"></c:out></h3></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>