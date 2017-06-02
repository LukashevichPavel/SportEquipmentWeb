package by.htp.equipment.command;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;
import by.htp.equipment.service.OrderService;
import by.htp.equipment.service.OrderServiceImpl;
import static by.htp.equipment.util.ConstantValue.*;

public class OrderCreateAction implements CommandAction{	
	private OrderService orderService;
	private EquipmentService equipService; 
	
	public OrderCreateAction() {
		orderService = new OrderServiceImpl();
		equipService = new EquipmentServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String page = PAGE_USER_MAIN;
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user.toString());
		if (user.getRole()==0){
			page=PAGE_REGISTER;
			String infomessage="Register for make order";
			request.setAttribute(infomessage, infomessage);
			
			List <Equipment> equipment = null;
			
			equipment = equipService.getEquipmentBase();
			request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
		}
		if (user.getRole()==1){
		
		}
		if (user.getRole()==2){
			//********************** ЗАГЛУШКА
			Long orderId = Long.valueOf(0);
			Long userId = Long.valueOf(0);//request.getuser.getUserId();
			Long equipmentId = Long.valueOf(request.getParameter(PARAM_EQUIPMENT_ID));
			String dateStart = request.getParameter(PARAM_DATE_START);
			String dateEnd = request.getParameter(PARAM_DATE_END);
			String status = "ACTIVE";
			Date start = Date.valueOf(dateStart);
			Date end = Date.valueOf(dateEnd);
			Order order = new Order(orderId, userId, equipmentId, start, end, status);
			if (check(order)){
				orderService.makeOrder(order);
			}
			else {page = PAGE_ERROR; System.out.println("При проверке переменных найден Null");}
			//}}
		}
		
		return page;
	}

}

