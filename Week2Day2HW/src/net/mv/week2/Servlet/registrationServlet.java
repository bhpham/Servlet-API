package net.mv.week2.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.week2.User.User;
import net.mv.week2.userService.userService;

public class registrationServlet extends HttpServlet {
	
	userService usrService = new userService();
	User user = new User();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username + " " + password);
		
		user.setUsername(username);
		user.setPassword(password);
		
		//call authenticate the user
		try {
			if (usrService.registeredUser(user)) {
				resp.sendRedirect("login.html");
			}else {
				resp.sendRedirect("userExist.html");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
