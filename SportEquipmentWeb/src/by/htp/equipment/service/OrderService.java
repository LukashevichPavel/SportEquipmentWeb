package by.htp.equipment.service;

import java.sql.Date;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;

public interface OrderService {

	public Order makeOrder(User user, Equipment equipment, Date start, Date end);
}
