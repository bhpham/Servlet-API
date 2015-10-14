package net.mv.flashcard.service;

import java.util.ArrayList;
import java.util.Random;

import net.mv.flashcard.dao.CardDao;
import net.mv.flashcard.domain.Card;
import net.mv.flashcard.domain.CardUser;

public class CardService {
	
	private CardDao cardDao = new CardDao();
	
	public void saveCard(Card card) {
		
		/*
		 * TODO: Call CardDao.createCard(Card card)
		 */
		cardDao.createCard(card);
		
	}
	
	public Card getRandomCard(CardUser cardUser) {
		
		Card myCard = null;
		Random randomGenerator = new Random();
		ArrayList<Card> allCards = cardDao.retrieveAll(cardUser);
		int size = allCards.size();

		if (size > 0) {
			int randomInt = randomGenerator.nextInt(size);
			myCard = allCards.get(randomInt);
		}
		
		return myCard;
	}
	
	
	
	
}
