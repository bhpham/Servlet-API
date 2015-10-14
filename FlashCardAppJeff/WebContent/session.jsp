<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

	if (session.getAttribute("cardUser") == null) {
		
		request.setAttribute("message", "Please log in...");
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
	}

 %>


