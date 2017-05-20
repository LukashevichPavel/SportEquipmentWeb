package by.htp.equipment.command;
import static by.htp.equipment.util.ConstantValue.*;
import static by.htp.equipment.util.ConstantValue.PAGE_USER_MAIN;
import static by.htp.equipment.util.ConstantValue.PARAM_DATE_END;
import static by.htp.equipment.util.ConstantValue.PARAM_DATE_START;
import static by.htp.equipment.util.ConstantValue.PARAM_EQUIPMENT_ID;
import static by.htp.equipment.util.ConstantValue.PARAM_USER_ID;

import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Client;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.User;
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
		String page = PAGE_USER_MAIN;
		User user = new User();
		Client client = new Client();
		Long userId=Long.valueOf("0");
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);
		String password2 = request.getParameter(REQUEST_PARAM_PASSWORD2);
		String email = request.getParameter(REQUEST_PARAM_MAIL);
		String firstname = request.getParameter(REQUEST_PARAM_FIRSTNAME);
		String lastname = request.getParameter(REQUEST_PARAM_LASTNAME);
		String adress = request.getParameter(REQUEST_PARAM_ADRESS);
		String telNumber = request.getParameter(REQUEST_PARAM_TELNUMBER);
		client.setFirstname(firstname);
		client.setLastname(lastname);
		client.setEmail(email);
		client.setAdress(adress);
		client.setTelNumber(telNumber);
		user=service.createUser(userId, login, password, false, client);
		if (!password.equals(password2)) page=PAGE_ERROR;
		
		return page;
	}

}
