package net.mv.week2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.week2.domain.Calc;
import net.mv.week2.service.CalcService;

public class CalculatorServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		
		String op = request.getParameter("op");
		
		System.out.println(num1 +  " " + num2 + " " + op);
		
		Calc calc = new Calc();
		
		calc.setNum1(num1);
		calc.setNum2(num2);
		calc.setOp(op);
		
		CalcService service = new CalcService();
		
		calc = service.handleCalculation(calc);
		
		request.setAttribute("calcResult", calc);
		
		
		
		
		HttpSession session = request.getSession();
		
		List<Calc> calcResultList = (List<Calc>) session.getAttribute("calcResultList");
		
		if (calcResultList == null) {
			calcResultList = new ArrayList<Calc>();
		}
		
		calcResultList.add(calc);
		
		session.setAttribute("calcResultList", calcResultList);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		
		rd.forward(request, response);
		
		
	}
}
