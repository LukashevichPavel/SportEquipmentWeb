package by.htp.equipment.dao;

import java.sql.Date;
import java.util.List;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.User;
import by.htp.equipment.entity.Order;

public interface OrderDao {

	//boolean createOrder(User user, Equipment equipment, Date start, Date end);
	boolean createOrder(Order order);
	List<Order> fetchAll();
}
