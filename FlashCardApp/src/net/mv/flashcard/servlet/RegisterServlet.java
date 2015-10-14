package net.mv.flashcard.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.flashcard.domain.CardUser;
import net.mv.flashcard.service.CardUserService;

public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*
		 * Get the username and password field values from the form register.jsp
		 */
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		/*
		 * Create a object of CardUser to hold our user data
		 */
		CardUser user = new CardUser();
		
		user.setUsername(username);;
		user.setPassword(password);
		
		CardUserService service = new CardUserService();
		
		//Calls the registerUser method in the CardUserService to create a user
		//returns a boolean true if users exists already
		boolean exists = service.registerUser(user);
		
		RequestDispatcher rd = null;
		
		if (exists) {
			//If exists, send user to register.jsp with error message
			rd = req.getRequestDispatcher("register.jsp");
			//Set error message in the request scope
			req.setAttribute("message", "User already exists!");
		} else {
			//If doesn't exist, send user to login.jsp with success message
			rd = req.getRequestDispatcher("login.jsp");
			//Set success message in request scope
			req.setAttribute("message", "Registration successful");
		}
		
		//Forward request and response to the select resource (register.jsp || login.jsp)
		rd.forward(req, resp);
	}
	
	
}
