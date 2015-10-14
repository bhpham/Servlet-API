package net.mv.flashcard.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.flashcard.domain.Card;
import net.mv.flashcard.domain.CardUser;
import net.mv.flashcard.service.CardService;

public class AllCardsServlet extends HttpServlet {
	
	private CardService cardService = new CardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		CardUser user = (CardUser) req.getSession().getAttribute("cardUser");

		List<Card> cardList = cardService.getAllCard(user);
	
		req.getSession().setAttribute("cardList", cardList);
		
		RequestDispatcher rd = null;
		
		if (cardList.size() != 0) {
			rd = req.getRequestDispatcher("allCards.jsp");
			req.getSession().setAttribute("cardList", cardList);
		} else {
			req.setAttribute("message", "please add cards");
			rd = req.getRequestDispatcher("home.jsp");
		}
		
		rd.forward(req, resp);
	}
}
