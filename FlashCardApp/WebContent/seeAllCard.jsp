<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="net.mv.flashcard.domain.Card" %>  
<%@ page import="java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://s3.amazonaws.com/codecademy-content/projects/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		ArrayList<Card> cards = (ArrayList<Card>) request.getAttribute("allCard");
	 	if(cards.size() != 0) {
	 		for (Card card : cards) {
	 			out.write("<h1> Question: " + card.getQuestion() + " | " + "Answer: " + card.getAnswer() + " </h1>");
	 		}
	 	}else
	 		out.write("<h1> THERE IS NO CARDS IN THE SET </h1>");
	 %>
</body>
</html>