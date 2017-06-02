package by.htp.equipment.command;
import static by.htp.equipment.util.ConstantValue.*;
import static by.htp.equipment.util.ConstantValue.PAGE_USER_MAIN;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.User;
import by.htp.equipment.service.ServiceNoSuchUserException;
import by.htp.equipment.service.UserService;
import by.htp.equipment.service.UserServiceImpl;

public class UserCreateAction implements CommandAction {

	private UserService service;
	
	public UserCreateAction() {
		service = new UserServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String page = PAGE_DEFAULT;
		User user = new User();
		Long userId=Long.valueOf("0");
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);
		String password2 = request.getParameter(REQUEST_PARAM_PASSWORD2);
		String email = request.getParameter(REQUEST_PARAM_MAIL);
		String firstname = request.getParameter(REQUEST_PARAM_FIRSTNAME);
		String lastname = request.getParameter(REQUEST_PARAM_LASTNAME);
		String adress = request.getParameter(REQUEST_PARAM_ADRESS);
		String telNumber = request.getParameter(REQUEST_PARAM_TELNUMBER);
		String passport = request.getParameter(REQUEST_PARAM_PASSPORT);
		user.setUserId(userId);
		user.setLogin(login);
		user.setPassword(password);
		user.setRole(0);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setAdress(adress);
		user.setTelNumber(telNumber);
		user.setPassport(passport);
		service.createUser(user);
		//if (!password.equals(password2)) 
		//{page=PAGE_ERROR;}
	
		return page;
	}

}
