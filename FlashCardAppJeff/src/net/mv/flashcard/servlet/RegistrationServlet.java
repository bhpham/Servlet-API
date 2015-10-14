package net.mv.flashcard.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.flashcard.domain.CardUser;
import net.mv.flashcard.service.CardUserService;

public class RegistrationServlet extends HttpServlet{
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * doPost method to handle the POST request coming from register.jsp
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/*
		 * Get the username and password field values from the form on register.jsp
		 */
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		/*
		 * Create a object of CardUser to hold our user data
		 */
		CardUser user = new CardUser();
		
		user.setUsername(username);
		user.setPassword(password);
		
		/*
		 * Create an object of the CardUserService class to perform our business logic
		 */
		CardUserService service = new CardUserService();
		
		// Calls the registerUser method in the CardUserSErvice to create a user
		// returns a boolean true if user exists already
		boolean exists = service.registerUser(user);
		
		RequestDispatcher rd = null;
		
		if(exists){
			// If exists, send user to register.jsp with error message
			rd = req.getRequestDispatcher("register.jsp");
			// set error message in request scope
			req.setAttribute("message", "User already exists");
		}else{
			// If does not exist, send user to login.jsp with success message
			rd = req.getRequestDispatcher("login.jsp");
			// set success message in request scope
			req.setAttribute("message", "Registration successful");
		}
		// Forward request and response to the selected resource (register.jsp || login.jsp)
		rd.forward(req, resp);

	}

}
