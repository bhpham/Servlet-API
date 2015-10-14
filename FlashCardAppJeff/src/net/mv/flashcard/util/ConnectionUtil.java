package net.mv.flashcard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionUtil {
	
	private static ConnectionUtil util;
	
	private DataSource ds;
	
	private ConnectionUtil(){
		
	}
	
	public static ConnectionUtil getConnectionUtil(){
		
		if(util == null){
			util = new ConnectionUtil();
		}
		
		return util;
		
	}
	
	public void setDataSource(DataSource ds){
		this.ds = ds;
	}
	
	public Connection createConnection(){
		
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
