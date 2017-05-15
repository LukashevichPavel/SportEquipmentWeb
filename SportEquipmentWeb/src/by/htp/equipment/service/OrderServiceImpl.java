package by.htp.equipment.service;

import java.sql.Date;

import by.htp.equipment.dao.OrderDao;
import by.htp.equipment.dao.OrderDaoImpl;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;

public class OrderServiceImpl implements OrderService{

	private OrderDao dao;

	public OrderServiceImpl(){
		dao=new OrderDaoImpl();
	}

	@Override
	public Order makeOrder(User user, Equipment equipment, Date start, Date end) {
		Order order = new Order();
		order.setEquipment(equipment);
		order.setUser(user);
		order.setDateStart(start);
		order.setDateEnd(end);
		dao.createOrder(order);
		return null;
	}

	

	
}
