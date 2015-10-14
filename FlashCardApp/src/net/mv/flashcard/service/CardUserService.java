package net.mv.flashcard.service;

import java.sql.SQLException;

import net.mv.flashcard.dao.CardUserDao;
import net.mv.flashcard.domain.CardUser;

public class CardUserService {
	
	private CardUserDao userDao = new CardUserDao();
	
	public boolean authenticate(CardUser user) {
		
		boolean authenticated = false;
		
		CardUser userFromDB = userDao.retrieveCardUser(user.getUsername());
		
		if (userFromDB != null && userFromDB.getPassword().equals(user.getPassword())) {
			authenticated = true;
			user.setUserId(userFromDB.getUserId());
		}
		
		return authenticated;
	}
	
	public boolean registerUser(CardUser user) {
		
		boolean exists = false;
		
		try {
			userDao.createCardUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			exists = true;
		}
		
		return exists;
	}
}
