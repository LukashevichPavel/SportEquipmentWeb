package by.htp.equipment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import static by.htp.equipment.util.ConstantValue.*;
import by.htp.equipment.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User fetchByCredentials(String login, String password) {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String dbUrl= rb.getString("db.url");
		String dbLogin=rb.getString("db.login");
		String dbPass=rb.getString("db.pass");
		String driverName=rb.getString("db.driver.name");
		
		User user=null;
		
	try {
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(dbUrl,dbLogin,dbPass);
		//Statement st=conn.createStatement();
		//ResultSet rs=st.executeQuery(SQL_STATEMENT_SELECT_USER);
		PreparedStatement ps = conn.prepareStatement(SQL_STATEMENT_SELECT_USER);
		ps.setString(1, login);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if (rs.next()){
			
			String log=rs.getString(2);
			String pass=rs.getString(3);
			boolean role=rs.getBoolean(4);
			user = new User();
			user.setLogin(log);
			user.setPassword(pass);
			user.setRole(role);
		}
		/*while (rs.next()){
		String log=rs.getString(2);
		String pas=rs.getString(3);
		System.out.println(log+" "+pas);
		}*/
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return user;
	}

}
