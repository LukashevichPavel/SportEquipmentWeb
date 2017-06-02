package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.entity.Equipment;

public interface EquipmentService {

	List<Equipment> getEquipmentBase();

	boolean takeToRent(Long equipmentId, Long userId, String dateStart, String dateEnd);
	
}