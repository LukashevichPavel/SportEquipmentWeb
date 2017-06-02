package by.htp.equipment.dao;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import by.htp.equipment.entity.Equipment;

public class EquipmentDaoImpl implements EquipmentDao {

	@Override
	public List<Equipment> getEquipmentBase() {
		Connection conn = new ConnectionBD().getConnection();

		Map<Long, Equipment> equipmentBase = new TreeMap<Long, Equipment>();
		List<Equipment> equipment = new ArrayList<Equipment>();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_SELECT_ALL_EQUIPMENT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long equipmentId = rs.getLong(1);
				String title = rs.getString(2);
				String type = rs.getString(3);
				double rentPrice = rs.getDouble(4);
				double lostPrice = rs.getDouble(5);
				boolean isAvialible = rs.getBoolean(6);
				String category = rs.getString(7);
				Equipment eq = new Equipment(equipmentId, category, title, isAvialible, rentPrice, lostPrice);
				equipmentBase.put(eq.getEquipmentId(), eq);
			}

			if (!equipmentBase.isEmpty()) {
				for (Map.Entry<Long, Equipment> e : equipmentBase.entrySet()) {
					equipment.add(e.getValue());
				}
			} else {
				System.out.println("Ошибка, база пуста");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return equipment;
	}

	@Override
	public boolean checkEquipmentAvialible(Long equipmentId) {
		boolean result = false;
		Connection conn = new ConnectionBD().getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_STATEMENT_EQUIPMENT_AVIALIBLE_CHECK);
			ps.setLong(1, equipmentId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int isAvialible = rs.getInt(6);
				if (isAvialible==1) result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
