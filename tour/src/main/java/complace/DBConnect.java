package complace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static String url="jdbc:mysql://localhost:3306/travel?allowPublicKeyRetrieval=true&useSSL=FALSE";
	private static String user="root";
	private static String pass="1234";
	private static Connection conn;
	
	public static Connection getConnection() throws ClassNotFoundException {
		
		try {
			 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("connection");
		}
		 catch (SQLException e) {
	            e.printStackTrace();
		}
		
		return conn;
		
	}
}
