package modal.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import modal.dto.Users;
import utilities.DBUtility;

public class AddUser {
	Connection con;

	// get connection when create object
	/*public AddUser() throws Exception {
		DBUtility utility = new DBUtility();
		con = utility.getConnection();
		System.out.println("Connecting to database...");
	}
*/
	public boolean addUser(Users user) {
		
		// this object is contain all the detail regarding hibernate configuration file
		// we can call it as heavy weight object
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// - Create session object > SessionFactory produce session object that
		// we can get session or open session by calling .openSession() method in SessionFactory
		// - Conceptually mean is whenever session is open then internally database connection will be opened
		Session session = sessionFactory.openSession();
		
		// - Create logical transaction while working with insert, update, delete transaction from
		// hibernate. On the database hibernate would a logical transaction
		// - if you just need a select an object from database we don't require any logical transition
		// but for all the CRUD operation hibernate would need it. in order to begin transaction we need to 
		// call a method beginTransaction()
		session.beginTransaction();
		
		// session.save() means inserting record to database table, we just need to past the model object
		session.save(user);
		// session.delete(user); //Remove record from table 
		
		// commit transaction
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		return true;
		
		
//		PreparedStatement ps = null;
//		try {
//			ps = con.prepareStatement(
//					"INSERT INTO tbluser (user_id, username, password,first_name, last_name, gender, dob, type, status) "
//							+ "VALUES (? ,?, ?, ?, ?, ?, ?, ?, ?)");
//			ps.setInt(1, user.getUser_id());
//			ps.setString(2, user.getUsername());
//			ps.setString(3, user.getPassword());
//			ps.setString(4, user.getFirst_name());
//			ps.setString(5, user.getLast_name());
//			ps.setString(6, String.valueOf(user.getGender()));
//
//			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//			Date parsed = format.parse(user.getDob());
//			java.sql.Date date = new java.sql.Date(parsed.getTime());
//			ps.setDate(7, date);
//			ps.setDate(7, (java.sql.Date) date);
//			ps.setString(8, user.getType());
//			ps.setString(9, user.getStatus());
//
//			// ps.setInt(1, 102);
//			// ps.setString(2,"xxx");
//			// ps.setString(3,"xxx");
//			// ps.setString(4, "xxx");
//			// ps.setString(5,"xxx");
//			// ps.setString(6, String.valueOf('M'));
//			//
//			// SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//			// Date parsed = format.parse("20110210");
//			// java.sql.Date date = new java.sql.Date(parsed.getTime());
//			// ps.setDate(7, date);
//			// ps.setString(8, "xxx");
//			// ps.setString(9, "xxx");
//
//			if (ps.executeUpdate() > 0)
//				return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
		
		
	}
}
