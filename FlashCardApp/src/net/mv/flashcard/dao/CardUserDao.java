package net.mv.flashcard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.mv.flashcard.domain.CardUser;
import net.mv.flashcard.util.ConnectionUtil;

public class CardUserDao {
	
	private ConnectionUtil util = ConnectionUtil.getConnectionUtil();
	
	/*
	 * So, if the method doesn't find a user by username, it will return null
	 */
	public CardUser retrieveCardUser(String username) {
		CardUser user = null;
		
		String query = "SELECT * FROM CARD_USER WHERE USERNAME = ?";
		
		Connection conn = util.createConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(query);) {
			
			pst.setString(1,  username);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				
				user = new CardUser();
				
				user.setUserId(rs.getLong("c_u_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
		
		return user;
	}
	
	public void createCardUser(CardUser user) throws SQLException {
		
		String query = "INSERT INTO CARD_USER (USERNAME, PASSWORD) VALUES(?, ?)";
		
		Connection conn = util.createConnection();
		
		try(PreparedStatement pst = conn.prepareStatement(query); ) {
			
			pst.setString(1, user.getUsername());
			pst.setString(2,  user.getPassword());
			
			pst.executeUpdate();
			
		} finally {
			util.closeConnection(conn);
		}
	}
}
