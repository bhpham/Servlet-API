package net.mv.week2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 
 * @author Binh Pham
 * My first servlet. I am writing a doGet and doPost method in here to test
 * functionality.
 */
public class MyFirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Test 1 2 3");
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username + " " + password);
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Test 4 5 6");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username + " " + password);
		
		/*
		 * User PrintWriter from the HttpServletResponse object to write back to the client response
		 */
//		PrintWriter writer = resp.getWriter();
//		writer.write("<html><body><h1>Username: " + username + "</h1/></body></html>");
		
		/*
		 * Basic user authentication for login
		 */ 
		if (username.equals("Binh") && password.equals("1234")) {
			resp.sendRedirect("success.html");
		}else {
			resp.sendRedirect("failure.html");
		}	
	}
}
