package net.mv.flashcard.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.flashcard.domain.Card;
import net.mv.flashcard.domain.CardUser;
import net.mv.flashcard.service.CardService;

public class CardServlet extends HttpServlet{
	
	private CardService service = new CardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/*
		 * doGet to view random card based on userId
		 */
		
		HttpSession session = req.getSession();
		CardUser user = (CardUser) session.getAttribute("cardUser");
		
		/*
		 * TODO: add call to CardService method to get random card
		 */
		Card randomCard = service.getRandomCard(user);
		
		//Get RequestDispatcher from HttpServletRequest to forward user to pages
		RequestDispatcher rd = null;
		
		//If the card is not null (they have no cards), set it ass a session attribute and display
		if (randomCard != null) {
			session.setAttribute("randomCard", randomCard);
			rd = req.getRequestDispatcher("viewQuestion.jsp");
		}
		//If the card is null, send back to home.jsp and display error
		else {
			rd = req.getRequestDispatcher("home.jsp");
			req.setAttribute("message", "Please add some cards before viewing");
		}
			
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Create Card object
		Card card = new Card();
		
		// Get question/answer from the HttpServletRequest object
		String question = req.getParameter("question");
		String answer = req.getParameter("answer");
		
		// Store variables in the Card object to save to DB
//		card.setUser((CardUser) req.getSession().getAttribute("cardUser"));
		/*
		 * Decare CardUser varialbe, retrieve the CardUser object from the session
		 * and set it to the current CardUser variable.
		 */
		CardUser cardUser = (CardUser) req.getSession().getAttribute("cardUser");
		/*
		 * Set the CardUser property in the Card object to the CardUser object
		 * that was retrieved from the HttpSession
		 */
		card.setUser(cardUser);
		card.setQuestion(question);
		card.setAnswer(answer);
		
		
		/*
		 * Call CardService.saveCard(Card)
		 */
		
		CardService service = new CardService();
		
		service.saveCard(card);
		
		/*
		 * Forward back to home.jsp
		 */
		req.getRequestDispatcher("home.jsp").forward(req, resp);
		
	}

}
