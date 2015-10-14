package net.mv.flashcard.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.flashcard.dao.CardDao;
import net.mv.flashcard.domain.Card;
import net.mv.flashcard.domain.CardUser;

public class viewAllServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		CardUser cardUser = (CardUser) req.getSession().getAttribute("cardUser");
		CardDao cardDao = new CardDao();
		ArrayList<Card> allCard = new ArrayList<Card>();
	
		allCard = cardDao.retrieveAll(cardUser);

		req.setAttribute("allCard", allCard);

		RequestDispatcher rd = req.getRequestDispatcher("seeAllCard.jsp");

		rd.forward(req, resp);

	}
}
