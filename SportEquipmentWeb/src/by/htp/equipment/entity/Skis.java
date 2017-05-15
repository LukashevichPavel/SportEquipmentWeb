package by.htp.equipment.entity;

//import java.math.BigDecimal;
//import java.math.RoundingMode;

public class Skis extends Equipment {
	//private String[] catListSkis = { "Fischer", "Guru", "RC4" };
	//private String[] acsListSkis = { "Skis Helmet", "Skis Bag", "Skis Mask", "Skis Skirt" };

	public Skis() {
		super();
	}

	public Skis(Long id, String cat, String title, boolean isAvlble, double rentPrice, double lostPrice) {
		super.setEquipmentId(id);
		super.setCategory(cat);
		super.setTitle(title);
		super.setAvialible(isAvlble);
		super.setRentPrice(rentPrice);
		super.setLostPrice(lostPrice);
	}

	public void print() {
		String infoEquipment="";
		infoEquipment="[id:"+getEquipmentId()+"]"+getCategory()+", "+getTitle() +", ";
		if (!isAvialible())	infoEquipment+="Арендовано";	
		else  infoEquipment+="Доступно";
		infoEquipment+=", цена аренды: "+getRentPrice()+", цена порчи/потери: "+getLostPrice();
		System.out.println(infoEquipment);
	}

}
