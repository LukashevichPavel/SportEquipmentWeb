package by.htp.equipment.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.dao.EquipmentDao;
import by.htp.equipment.dao.EquipmentDaoImpl;
import by.htp.equipment.dao.OrderDaoImpl;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.util.ConstantValue;

import static by.htp.equipment.util.ConstantValue.*;

public class EquipmentServiceImpl implements EquipmentService {
	private EquipmentDaoImpl equipmentDao;
	private OrderDaoImpl orderDao;
	
	public EquipmentServiceImpl() {
		equipmentDao = new EquipmentDaoImpl();
		orderDao = new OrderDaoImpl();
	}

	@Override
	public List<Equipment> getEquipmentBase() {
		List<Equipment> equipment = new ArrayList<Equipment>();
		equipment = equipmentDao.getEquipmentBase();
		return equipment;
	}

		@Override
	public boolean takeToRent(Long equipmentId, Long userId, String dateStart, String dateEnd) {
		boolean execute=false;
		
		
			
			
		return execute;
	}

}