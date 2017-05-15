package by.htp.equipment.entity;

//import java.util.Map;

public class Acsessories extends Equipment {

	public Acsessories() {
		super();
	}

	public Acsessories(Long id, String cat, String title, boolean isAvlble, double rentPrice, double lostPrice) {
		super.setEquipmentId(id);
		super.setCategory(cat);
		super.setTitle(title);
		super.setAvialible(isAvlble);
		super.setRentPrice(rentPrice);
		super.setLostPrice(lostPrice);
	}

	public void print() {
		String infoAcsessories="";
		infoAcsessories="[id:"+getEquipmentId()+"]Аксессуар для "+getCategory()+", "+getTitle() +", ";
		if (!isAvialible())	infoAcsessories+="Арендовано";	
		else  infoAcsessories+="Не арендовано";
		infoAcsessories+=", "+getRentPrice()+", "+getLostPrice();
		System.out.println(infoAcsessories);
	}

}
