package net.mv.flashcard.service;

import java.sql.SQLException;

import net.mv.flashcard.dao.CardUserDao;
import net.mv.flashcard.domain.CardUser;

public class CardUserService {
	
	private CardUserDao userDao = new CardUserDao();
	
	/*
	 * Method to compare user entered information with
	 * the information on record in the database 
	 * for that username.
	 */
	public boolean authenticate(CardUser user){
		
		boolean authenticated = false;
		
		CardUser userFromDB = userDao.retrieveCardUser(user.getUsername());
		
		/*
		 * If userFromDB is not null AND userFromDB password equals the password
		 * that the user entered onthe form, set authenticated to true and set the userID 
		 * from the CardUser in the database to the passed CardUser object. 
		 */
		if(userFromDB != null && userFromDB.getPassword().equals(user.getPassword())){
			authenticated = true;
			user.setUserId(userFromDB.getUserId());
		}
		
		return authenticated;
	}
	
	/*
	 * Method to register a user with the application
	 */
	public boolean registerUser(CardUser user){
		
		boolean exists = false;
		
		try {
			// Calls the CardUserDao to insert user information into db
			userDao.createCardUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			exists = true;
		}
		
		return exists;
	}

}
