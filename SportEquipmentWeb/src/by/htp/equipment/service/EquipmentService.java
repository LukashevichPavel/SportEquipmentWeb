package by.htp.equipment.service;

import java.sql.SQLException;
import java.util.List;

import by.htp.equipment.entity.Equipment;

public interface EquipmentService {
	
List<Equipment> getEquipmentBase() throws SQLException;

}