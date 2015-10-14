package net.mv.flashcard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.mv.flashcard.domain.Card;
import net.mv.flashcard.domain.CardUser;
import net.mv.flashcard.util.ConnectionUtil;

public class CardDao {
	
	private ConnectionUtil util = ConnectionUtil.getConnectionUtil();
	
	public void createCard(Card card){
		
		String query = "INSERT INTO CARD (QUESTION,ANSWER,C_U_ID) VALUES(?,?,?)";
		
		Connection conn = util.createConnection();
		
		try(PreparedStatement pst = conn.prepareStatement(query);){
			
			pst.setString(1, card.getQuestion());
			pst.setString(2, card.getAnswer());
			pst.setLong(3, card.getUser().getUserId());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		
	}
	
	/*
	 * Method to return list of Card objects by userId
	 */
	public List<Card> retrieveCardList(CardUser user) {
		
		//Create ArrayList<Card> and store it in a variable of type List<Card>
		List<Card> cards = new ArrayList<Card>();
		
		String query = "SELECT * FROM CARD WHERE C_U_ID = ?";
		
		Card card = null;
		
		Connection conn = util.createConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(query); ) {
			
			pst.setLong(1, user.getUserId());
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				card = new Card();
				
				card.setCardId(rs.getLong("c_id"));
				card.setQuestion(rs.getString("question"));
				card.setAnswer(rs.getString("answer"));
				card.setUser(user);
				
				cards.add(card);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
		
		return cards;
	}

}
