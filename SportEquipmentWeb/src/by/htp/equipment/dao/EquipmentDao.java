package by.htp.equipment.dao;

import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.entity.Equipment;

public interface EquipmentDao {

	List<Equipment> getEquipmentBase();
	
	boolean checkEquipmentAvialible(Long equipmentId);
}
