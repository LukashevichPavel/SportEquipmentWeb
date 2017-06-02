package by.htp.equipment.dao;

import java.util.List;

import by.htp.equipment.entity.Order;

public interface OrderDao {
	
	boolean createOrder(Order order);
	boolean checkOrderActiveCount(Long userId);
	List<Order> getAllOrders();
	
}
