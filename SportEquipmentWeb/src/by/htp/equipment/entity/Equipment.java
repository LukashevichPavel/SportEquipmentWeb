package by.htp.equipment.entity;

public class Equipment {
	private Long equipmentId;
	private String category;
	private String title;
	private boolean isAvialible;
	private double rentPrice;
	private double lostPrice;
	
	public Equipment() {
		super();
	}

	public Equipment (String title, double price){
		this.setTitle(title);
		this.setRentPrice(price);
	} 
		
	public Equipment(Long equipmentId, String category, String title, boolean isAvialible, double rentPrice,
			double lostPrice) {
		super();
		this.equipmentId = equipmentId;
		this.category = category;
		this.title = title;
		this.isAvialible = isAvialible;
		this.rentPrice = rentPrice;
		this.lostPrice = lostPrice;
	}

	public void print(){}

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public double getLostPrice() {
		return lostPrice;
	}

	public void setLostPrice(double lostPrice) {
		this.lostPrice = lostPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAvialible() {
		return isAvialible;
	}

	public void setAvialible(boolean isAvialible) {
		this.isAvialible = isAvialible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((equipmentId == null) ? 0 : equipmentId.hashCode());
		result = prime * result + (isAvialible ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(lostPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rentPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment other = (Equipment) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (equipmentId == null) {
			if (other.equipmentId != null)
				return false;
		} else if (!equipmentId.equals(other.equipmentId))
			return false;
		if (isAvialible != other.isAvialible)
			return false;
		if (Double.doubleToLongBits(lostPrice) != Double.doubleToLongBits(other.lostPrice))
			return false;
		if (Double.doubleToLongBits(rentPrice) != Double.doubleToLongBits(other.rentPrice))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", category=" + category + ", title=" + title
				+ ", isAvialible=" + isAvialible + ", rentPrice=" + rentPrice + ", lostPrice=" + lostPrice + "]";
	}

	

}
