package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
	protected Connection conn = null;
	
	protected String url = "jdbc:oracle:thin:@localhost:1521:xe";
	protected String user = "hot6";
	protected String password = "1234";
	
	protected ResultSet rs = null;
	protected PreparedStatement pstmt = null;

	protected void connectDB() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(	url, user, password );
		
		}catch(SQLException e) {
//			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
//			e.printStackTrace();
		}
		finally {
			if(conn != null) {
				try { 
					//연결 끊기
					conn.close();
					rs.close();
					pstmt.close();
				} catch (SQLException e) {}
			}
		}
	}
}
