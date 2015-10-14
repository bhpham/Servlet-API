package net.mv.week2.userService;

import java.sql.SQLException;

import net.mv.week2.User.User;
import net.mv.week2.userDao.userDao;

public class userService {
	private userDao usrDao = new userDao();
	
	/*
	 * Authenticate the users
	 */
	public boolean authenticateUser(User userToAuth) {
		User userFromDB = usrDao.retrieveUser(userToAuth.getUsername());
		boolean authenticated = false;
		if (userFromDB != null && userFromDB.getPassword().equals(userToAuth.getPassword())) {
			authenticated = true;
		}
		return authenticated;
	}
	
	/*
	 * Return existed registered Users
	 */
	public boolean registeredUser(User userToReg) throws SQLException {
		boolean registered = false;
		User userFromDB = usrDao.retrieveUser(userToReg.getUsername());
		if (userFromDB == null || !(userFromDB.getUsername().equals(userToReg.getUsername()))) {
			try {
				usrDao.createUser(userToReg);
				registered = true;
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return registered;
	}
	
}
