package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.User;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;

public class MakeOrderAction implements CommandAction {
	private EquipmentService equipService;
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page=PAGE_ORDER_CREATE;
		equipService = new EquipmentServiceImpl();	
		List <Equipment> equipment = null;
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		request.setAttribute(REQUEST_PARAM_CURRENT_DATE, new Date());
		
		equipment = equipService.getEquipmentBase();
		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
	
		return page;
		
	}
}
