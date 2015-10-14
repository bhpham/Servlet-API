package net.mv.flashcard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionUtil {

		private static ConnectionUtil util;
		
		private DataSource ds;
		
		private ConnectionUtil() {
			
		}
		/*
		 *	Commented out old constructor in favor of datasource	 
		 */
//		private ConnectionUtil() throws ClassNotFoundException {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		}
		
		public static ConnectionUtil getConnectionUtil() {
			if (util == null) {
				util = new ConnectionUtil();
				/*
				 * Commented out as we no longer need to handle exception from loading class
				 */
//				try {
//					util = new ConnectionUtil();
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
			}
			return util;
		}
		
		public void setDataSource(DataSource ds) {
			this.ds = ds;
		}
		
		public Connection createConnection() {
			Connection conn = null;
			
			try {
				conn = ds.getConnection();
				//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin", "admin");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return conn;
		}
		
		public void closeConnection(Connection conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
