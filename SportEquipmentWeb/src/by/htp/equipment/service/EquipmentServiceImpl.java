package by.htp.equipment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import by.htp.equipment.entity.Equipment;
import parser.MyDOMParser;

public class EquipmentServiceImpl implements EquipmentService {

	@Override
	public List<Equipment> getEquipmentBase() {
		MyDOMParser parser = new MyDOMParser();
		Map<Integer,Equipment> equipmentBase = new TreeMap<Integer,Equipment>();
		List<Equipment> equipment = new ArrayList<Equipment>();
		
		equipmentBase=parser.parse();
		if (!equipmentBase.isEmpty()) {
			for (Map.Entry<Integer, Equipment> e : equipmentBase.entrySet()) {
				equipment.add(e.getValue());
			}
		}
		else {
		equipment.add(new Equipment("eq1", 25));
		equipment.add(new Equipment("eq2", 30));
		equipment.add(new Equipment("eq3", 35));
		}
		return equipment;
	}

}