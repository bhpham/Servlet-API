package net.mv.flashcard.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.flashcard.domain.CardUser;
import net.mv.flashcard.service.CardUserService;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		CardUser user = new CardUser();
		
		user.setUsername(username);;
		user.setPassword(password);
		
		CardUserService service = new CardUserService();
		
		boolean authenticated = service.authenticate(user);
		
		RequestDispatcher rd = null;
		
		if (authenticated) {
			rd = req.getRequestDispatcher("home.jsp");
			/*
			 *  Getting an HttpSession from the Request object.
			 *  Setting our CardUser object to an HttpSession scope
			 *  with a name of "cardUser"
			 */
			HttpSession session = req.getSession();
			session.setAttribute("cardUser", user);
		
		} else {
			rd = req.getRequestDispatcher("login.jsp");
			req.setAttribute("message", "Bad crendentials");
		}
		
		rd.forward(req, resp);
	}

}
