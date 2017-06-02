package by.htp.equipment.service;

import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.dao.EquipmentDao;
import by.htp.equipment.dao.EquipmentDaoImpl;
import by.htp.equipment.dao.OrderDao;
import by.htp.equipment.dao.OrderDaoImpl;
import by.htp.equipment.entity.Order;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	private EquipmentDao equipDao;

	public OrderServiceImpl() {
		orderDao = new OrderDaoImpl();
		equipDao = new EquipmentDaoImpl();
	}

	@Override
	public Order makeOrder(Order order) {
		if (equipDao.checkEquipmentAvialible(order.getEquipmentId())){
			if (orderDao.checkOrderActiveCount(order.getUserId())){
				orderDao.createOrder(order);
			}
			else {System.out.println("”же арендовано максимально допустимое количество оборудовани€");}
		}
		else {System.out.println("ќборудование недоступно дл€ аренды");}
	
		
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		orders = orderDao.getAllOrders();
		return orders;
	}

}
