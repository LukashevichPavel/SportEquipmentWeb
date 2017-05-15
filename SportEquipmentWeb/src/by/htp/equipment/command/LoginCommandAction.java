package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.User;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;
import by.htp.equipment.service.ServiceNoSuchUserException;
import by.htp.equipment.service.UserService;
import by.htp.equipment.service.UserServiceImpl;

public class LoginCommandAction implements CommandAction{
	
	private UserService userService;
	private EquipmentService equipService;
	
	public LoginCommandAction(){
		userService = new UserServiceImpl();
		equipService = new EquipmentServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String page = PAGE_DEFAULT;
		
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);
		
		User user;
		try {
			user = userService.authorise(login, password);
			
			if(!user.isRole()){
				List<Equipment> equipment = equipService.getEquipmentBase();
				request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
				page = PAGE_USER_MAIN;
			}
			else {
				// add report
				page = PAGE_ADMIN_MAIN;
			}
		} catch (ServiceNoSuchUserException e) {
			page = PAGE_ERROR;
			request.setAttribute(REQUEST_PARAM_ERROR_MSG, e.getMessage());
			//e.printStackTrace();
		}
		return page;
	}

}
