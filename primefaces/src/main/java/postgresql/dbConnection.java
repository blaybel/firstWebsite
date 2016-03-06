package postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ErrorException.errorException;

public class dbConnection {
	
	public Connection getConnection(String dbName, String userName, String password){
		
		Connection connection = null;
	
	    try {
	         Class.forName("org.postgresql.Driver");
	         connection = DriverManager
	            .getConnection("jdbc:postgresql://127.0.0.1:5432/"+dbName, userName, password);
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	      }
	    
	    return connection;
 	}
 


}
