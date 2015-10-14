<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="net.mv.week2.domain.Calc"%>
<%@ page import="java.util.*" %>
<%@ include file="calc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<%-- 	<jsp:include page="calc.jsp"></jsp:include> --%>
	
	<%
		Calc calc = (Calc) request.getAttribute("calcResult");
		if(calc != null)
		out.write("<h1> Your numbers were: " + calc.getNum1() + " ,"
				+ calc.getNum2() + " and your result is "
				+ calc.getResult() + " with an operation of "
				+ calc.getOp() + "</h1>");
				 
		out.write("<br> ");
		
		List<Calc> calcResultList = (List<Calc>) session.getAttribute("calcResultList");
		
		for (Calc calcResult : calcResultList) {
			out.write(calcResult.toString() + "<br>");
		}
	%>

</body>
</html>