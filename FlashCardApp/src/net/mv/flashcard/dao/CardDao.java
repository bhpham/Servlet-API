package net.mv.flashcard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.mv.flashcard.domain.Card;
import net.mv.flashcard.domain.CardUser;
import net.mv.flashcard.util.ConnectionUtil;

public class CardDao {

	private ConnectionUtil util = ConnectionUtil.getConnectionUtil();
	
	public void createCard(Card card) {
		String query = "INSERT INTO CARD (QUESTION, ANSWER, C_U_ID) VALUES (?,?,?)";
		
		Connection conn = util.createConnection();
		
		try(PreparedStatement pst = conn.prepareStatement(query); ){
			
			pst.setString(1, card.getQuestion());
			pst.setString(2, card.getAnswer());
			pst.setLong(3, card.getUser().getUserId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
	}
	
	public ArrayList<Card> retrieveAll(CardUser cardUser) {
		
		ArrayList<Card> allCards = new ArrayList<Card>();
		long userId = cardUser.getUserId();
		String query = "SELECT * FROM CARD WHERE C_U_ID = ?";
		
		Connection conn = util.createConnection();
		
		try(PreparedStatement pst = conn.prepareStatement(query); ){
			pst.setLong(1, userId);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Card card = new Card();
				card.setQuestion(rs.getString("question"));
				card.setAnswer(rs.getString("answer"));
				
				allCards.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allCards;
	}
	
}
