package by.htp.equipment.parser;

import org.w3c.dom.*;

import by.htp.equipment.entity.Acsessories;
import by.htp.equipment.entity.Bike;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Skis;
import by.htp.equipment.entity.SnowBoard;

import javax.xml.parsers.*;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class MyDOMParser {

	public MyDOMParser() {
		super();
	}

	public Map<Long, Equipment> parse() {
		Map<Long, Equipment> equipmentBase = new TreeMap<Long, Equipment>();
		try {
			File inputFile = new File("c:\\Workspace\\SportEquipmentWeb\\src\\RentStation.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Equipment");
			System.out.println("----------------------------");
			
			Equipment equipment = null;
			int temp = 0;
			for (temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String id = eElement.getElementsByTagName("id").item(0).getTextContent();
					String category = eElement.getElementsByTagName("category").item(0).getTextContent();
					String title = eElement.getElementsByTagName("title").item(0).getTextContent();
					boolean isAvialible;
					if ("true".equals(eElement.getElementsByTagName("isAvialible").item(0).getTextContent())) isAvialible=true;
					else isAvialible=false;
					String rentPrice = eElement.getElementsByTagName("rentPrice").item(0).getTextContent();
					String lostPrice = eElement.getElementsByTagName("lostPrice").item(0).getTextContent();
					switch (eElement.getElementsByTagName("category").item(0).getTextContent()) {
					case "Bike": {
						equipment = new Bike(Long.valueOf(id), category, title,isAvialible, Double.valueOf(rentPrice), Double.valueOf(lostPrice));
						break;
					}
					case "SnowBoard": {
					 equipment = new SnowBoard(Long.valueOf(id), category, title,isAvialible, Double.valueOf(rentPrice), Double.valueOf(lostPrice));
					 break;
					}
					case "Skis": {
						 equipment = new Skis(Long.valueOf(id), category, title,isAvialible, Double.valueOf(rentPrice), Double.valueOf(lostPrice));
						 break;
					}
					case "Acsessories": {
						 equipment = new Acsessories(Long.valueOf(id), category, title,isAvialible, Double.valueOf(rentPrice), Double.valueOf(lostPrice));
						 break;
						 }
					}
					equipment.print();
					equipmentBase.put(equipment.getEquipmentId(), equipment);
				}
			}	
			System.out.println();
			System.out.println("Всего найдено " + temp + " элементов:");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipmentBase;
	}
	
}
