package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

abstract public class Dao {
	
	
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
	private final String USER = "root";
	private final String PASSWORD = "q1w2e3";
	private final String URL = "jdbc:mysql://localhost:3306/blog";
	
	
	protected void open() throws Exception {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}
	
	protected void close() throws Exception{
		conn.close();
	}
	
	

}
