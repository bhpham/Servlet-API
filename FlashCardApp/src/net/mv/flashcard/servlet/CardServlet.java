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

public class CardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		CardUser cardUser = (CardUser) req.getSession().getAttribute("cardUser");
		CardService cs = new CardService();
		Card randCard = new Card();
		randCard = cs.getRandomCard(cardUser);
	
		HttpSession session = req.getSession();
		
		req.setAttribute("randCard", randCard);
				
		RequestDispatcher rd = req.getRequestDispatcher("seeRandCard.jsp");
		
		rd.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Create Card object
		Card card = new Card();
		
		//Get question/answer from the HttpServletRequest object
		String question = req.getParameter("question");
		String answer = req.getParameter("answer");
		
		CardUser cardUser = (CardUser) req.getSession().getAttribute("cardUser"); 
		//Store variables in the Card object to save to DB
		
		card.setUser(cardUser);
		card.setQuestion(question);
		card.setAnswer(answer);
		
		/*
		 * TODO: Call CardService.saveCard(Card)
		 */
		
		CardService service = new CardService();
		
		service.saveCard(card);
		
		/*
		 * Forward back to home.jsp
		 */
		req.getRequestDispatcher("home.jsp").forward(req, resp);

	}
}
