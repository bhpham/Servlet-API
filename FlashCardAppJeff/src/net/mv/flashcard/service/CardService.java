package net.mv.flashcard.service;

import java.util.List;

import net.mv.flashcard.dao.CardDao;
import net.mv.flashcard.domain.Card;
import net.mv.flashcard.domain.CardUser;

public class CardService {
	
	private CardDao cardDao = new CardDao();
	
	
	public void saveCard(Card card){
		
		/*
		 * Call CardDao.createCard(Card card)
		 */
		cardDao.createCard(card);
		
	}
	
	public Card getRandomCard(CardUser user) {
		/*
		 * TODO: Call CardDao.retrieveCard(CardUser user)
		 */
		List<Card> cards = cardDao.retrieveCardList(user);
		
		int size = cards.size();
		
		Card card = null;
		
		if (size != 0) {
			card = cards.get((int) (size*Math.random()));
		}
		
		return card;
	}
	
	public List<Card> getAllCard(CardUser user) {
		return cardDao.retrieveCardList(user);
	}
	

}
