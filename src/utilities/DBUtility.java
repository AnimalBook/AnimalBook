package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtility {
	public Connection getConnection(){
		Connection c = null;
		Properties props=null;
	    try {
	    	Class.forName("org.postgresql.Driver");
	    	props=new Properties();
	    	props.put("user", "postgres");
	    	props.put("password", "1234");

	    	c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AnimalBookDB", props);
	       
	    	return c;
	    } catch (Exception e) {
	        System.out.println("Connection not found !");
	    }
	    return null;
	}
	public static void main(String[] args) {
		DBUtility db = new DBUtility();
		db.getConnection();
		
	}
}