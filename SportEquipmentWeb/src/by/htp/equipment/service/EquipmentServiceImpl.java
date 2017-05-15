package by.htp.equipment.service;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.User;
import by.htp.equipment.parser.MyDOMParser;

public class EquipmentServiceImpl implements EquipmentService {

	@Override
	public List<Equipment> getEquipmentBase() throws SQLException {
		
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String dbUrl= rb.getString("db.url");
		String dbLogin=rb.getString("db.login");
		String dbPass=rb.getString("db.pass");
		String driverName=rb.getString("db.driver.name");
		
		Map<Long,Equipment> equipmentBase = new TreeMap<Long,Equipment>();
		List<Equipment> equipment = new ArrayList<Equipment>();
		
		try {
			Class.forName(driverName);
			Connection conn;
		
			conn = DriverManager.getConnection(dbUrl,dbLogin,dbPass);
			
			//Statement st=conn.createStatement();
			//ResultSet rs=st.executeQuery(SQL_STATEMENT_SELECT_USER);
			PreparedStatement ps = conn.prepareStatement(SQL_STATEMENT_SELECT_ALL_EQUIPMENT);
			ResultSet rs=ps.executeQuery();
			//System.out.println("Найдено "+rs.getRow()+" записей");
			while (rs.next()){
				
				Long equipmentId=rs.getLong(1);
				String title=rs.getString(2);
				String type=rs.getString(3);
				double rentPrice=rs.getDouble(4);
				double lostPrice=rs.getDouble(5);
				boolean isAvialible=rs.getBoolean(6);
				String category=rs.getString(7);
				Equipment eq = new Equipment(equipmentId, category, title, isAvialible, rentPrice, lostPrice);
				equipmentBase.put(eq.getEquipmentId(), eq);
			}
			
			
			
			//equipmentBase=parser.parse();
			
			if (!equipmentBase.isEmpty()) {
				for (Map.Entry<Long, Equipment> e : equipmentBase.entrySet()) {
					equipment.add(e.getValue());
				}
			}
			else {
				System.out.println("Ошибка, база пуста");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return equipment;
	}
	
	public List<Equipment> getEquipmentBaseFromXML() {
		MyDOMParser parser = new MyDOMParser();
		Map<Long,Equipment> equipmentBase = new TreeMap<Long,Equipment>();
		List<Equipment> equipment = new ArrayList<Equipment>();
		
		equipmentBase=parser.parse();
		if (!equipmentBase.isEmpty()) {
			for (Map.Entry<Long, Equipment> e : equipmentBase.entrySet()) {
				equipment.add(e.getValue());
			}
		}
		else {
		System.out.println("Ошибка, база пуста");
		}
		return equipment;
	}

}