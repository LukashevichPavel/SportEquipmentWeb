package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;
import by.htp.equipment.service.OrderService;
import by.htp.equipment.service.OrderServiceImpl;
import by.htp.equipment.service.ServiceNoSuchUserException;
import by.htp.equipment.service.UserService;
import by.htp.equipment.service.UserServiceImpl;

public class LoginCommandAction implements CommandAction {

	private UserService userService;
	private EquipmentService equipService;
	private OrderService orderService;

	public LoginCommandAction() {
		userService = new UserServiceImpl();
		equipService = new EquipmentServiceImpl();
		orderService = new OrderServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String page = PAGE_DEFAULT;
		Date currentDate = new Date();
		//System.out.println("Время из date" + currentDate);
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);

		User user;
		try {
			user = userService.authorise(login, password);
			if (user.getRole() == 0) {

				List<Equipment> equipment = equipService.getEquipmentBase();
				request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
				request.setAttribute(REQUEST_PARAM_USER, user);

				HttpSession session = request.getSession();
				session.setAttribute(REQUEST_PARAM_USER, user);
				session.setAttribute(REQUEST_PARAM_CURRENT_DATE, currentDate);
				page = PAGE_USER_MAIN;
			}
			if (user.getRole() == 1) {
				List<Order> orders = orderService.getAllOrders();
				request.setAttribute(REQUEST_PARAM_LIST_ORDERS, orders);
				request.setAttribute(REQUEST_PARAM_LOGIN, login);
				page = PAGE_ADMIN_MAIN;
			} else {
				// add report

			}
		} catch (ServiceNoSuchUserException e) {
			page = PAGE_ERROR;
			request.setAttribute(REQUEST_PARAM_ERROR_MSG, e.getMessage());
			// e.printStackTrace();
		}
		return page;
	}

}
