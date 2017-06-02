package by.htp.equipment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;

import static by.htp.equipment.util.ConstantValue.*;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean createOrder(Order order) {

		Connection conn = new ConnectionBD().getConnection();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_ORDER_CREATE);
			ps.setLong(1, order.getUserId());
			ps.setLong(2, order.getEquipmentId());
			ps.setDate(3, order.getDateStart());
			ps.setDate(4, order.getDateEnd());
			ps.setString(5, order.getStatus());

			ps.executeUpdate();
			System.out.println("Insert succesfull");

			// ***********************************************************
			ps = conn.prepareStatement(SQL_STATEMENT_EQUIPMENT_AVIALIBLE_TOFALSE);
			ps.setLong(1, order.getEquipmentId());
			ps.executeUpdate();
			// ***********************************************************
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Order> getAllOrders() {
		Connection conn = new ConnectionBD().getConnection();

		List<Order> orders = new ArrayList<Order>();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_SELECT_ALL_ORDERS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long orderId = rs.getLong(1);
				Long userId = rs.getLong(2);
				Long equipmentId = rs.getLong(3);
				Date dateStart = rs.getDate(4);
				Date dateEnd = rs.getDate(5);
				String status = rs.getString(6);
				orders.add(new Order(orderId, userId, equipmentId, dateStart, dateEnd, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public boolean checkOrderActiveCount(Long userId) {
		Connection conn = new ConnectionBD().getConnection();
		boolean result = false;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_SELECT_ALL_ORDERS_USER);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			int count=0;
			while (rs.next()) {
				if ("ACTIVE".equals(rs.getString(6))) count++;  
			}
			if (count<PARAM_MAX_COUNT_EQUIPMENT){
				result=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
