package by.htp.equipment.service;

import java.sql.Date;
import java.util.List;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;

public interface OrderService {

	public Order makeOrder(Order order);

	public List<Order> getAllOrders ();
}
