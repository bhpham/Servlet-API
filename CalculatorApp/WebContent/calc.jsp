<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/CalculatorApp/calculate" method="POST">
	
		<table>
		
			<tr>
			
				<td>
				
				
					<label for="num1">Num 1</label>
				
				
				</td>
				
				<td>
					<input type="text" name="num1" id="num1"/>
				</td>
			
			</tr>
			
			<tr>
				
				<td>
				
					<label for="num2">Num 2</label>
				
				</td>
			
				<td>
				
					<input type="text" name="num2" id="num2" />
				
				</td>
				
			</tr>
				
			<tr>
			
				<td>	
					<label for="multiply">Multiply</label> <br>
					<label for="add">Add</label> <br>
					<label for="subtract">Subtract</label> <br>
					<label for="divide">Divide</label> <br>
				</td>
				
				<td>	
					<input type="radio" name="op" id="multiply" value="multiply"/> <br>
					<input type="radio" name="op" id="add" value="add"/> <br>
					<input type="radio" name="op" id="subtract" value="subtract"/> <br>
					<input type="radio" name="op" id="divide" value="divide"/> <br>
				</td>
				
			</tr>
		
			<tr>
			
				<td>
					
					<input type="submit" value="Calculate"/>
					
				</td>
			
			</tr>
		</table>
	
	</form>
</body>
</html>