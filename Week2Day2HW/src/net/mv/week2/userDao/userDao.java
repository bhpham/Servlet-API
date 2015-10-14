package net.mv.week2.userDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.mv.week2.User.User;
import net.mv.week2.util.ConnectionUtil;

public class userDao {
	
	private ConnectionUtil util = ConnectionUtil.getConnectionUtil();
	User user = null;
	public User retrieveUser(String username) {
		String query = "select * from users where username = ?";
		Connection conn = util.createConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserID(rs.getLong("user_id"));
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
	
	public void createUser(User user) throws SQLException {
		String query = "insert into users values( users_seq.nextval, '" + user.getUsername() + "', '" + user.getPassword() + "')";
		
		Connection conn = util.createConnection();
		conn.setAutoCommit(false);
		try (Statement stmt = conn.createStatement(); ) {
			stmt.executeUpdate(query);
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
	}

}
