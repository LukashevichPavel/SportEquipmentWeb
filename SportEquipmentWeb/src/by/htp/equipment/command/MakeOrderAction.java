package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;
import by.htp.equipment.service.UserService;
import by.htp.equipment.service.UserServiceImpl;



public class MakeOrderAction implements CommandAction {
	private UserService userService;
	private EquipmentService equipService;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		userService = new UserServiceImpl();
		equipService = new EquipmentServiceImpl();	
		List<Equipment> equipment =null;
		try {
			equipment = equipService.getEquipmentBase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
		
		return PAGE_ORDER_CREATE;
		
	}
	
	

}
