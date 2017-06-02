package by.htp.equipment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static by.htp.equipment.util.ConstantValue.*;

import by.htp.equipment.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User fetchByCredentials(String login, String password) {

		Connection conn = new ConnectionBD().getConnection();
		User user = null;

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_SELECT_USER);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Long userId = rs.getLong(1);
				String log = rs.getString(2);
				String pass = rs.getString(3);
				int role = rs.getInt(4);
				String firstname = rs.getString(5);
				String lastname = rs.getString(6);
				String mail = rs.getString(7);
				String adress = rs.getString(8);
				String telNumber = rs.getString(9);
				String passport = rs.getString(10);
				user = new User();
				user.setUserId(userId);
				user.setLogin(log);
				user.setPassword(pass);
				user.setRole(role);
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setEmail(mail);
				user.setAdress(adress);
				user.setTelNumber(telNumber);
				user.setPassport(passport);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User createUser(User user) {

		Connection conn = new ConnectionBD().getConnection();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_INSERT_USER);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, String.valueOf(user.getRole()));
			ps.setString(4, user.getFirstname());
			ps.setString(5, user.getLastname());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getAdress());
			ps.setString(8, user.getTelNumber());
			ps.setString(9, user.getPassport());
			ps.executeUpdate();
			System.out.println("Insert user ok!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User findUserWithId(Long userId) {

		Connection conn = new ConnectionBD().getConnection();

		User user = null;

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_FIND_USER_ID);
			ps.setString(1, String.valueOf(userId));

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				String log = rs.getString(2);
				String pass = rs.getString(3);
				int role = rs.getInt(4);
				user = new User();
				user.setLogin(log);
				user.setPassword(pass);
				user.setRole(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
}
