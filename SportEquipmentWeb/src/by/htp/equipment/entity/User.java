package by.htp.equipment.entity;

import java.util.Map;
import static by.htp.equipment.util.ConstantValue.ROLE;

public class User {
	private Long userId;
	private String login;
	private String password;
	private int role;
	private String firstname;
	private String lastname;
	private String passport;
	private String email;
	private String adress;
	private String telNumber;
	private Map<Integer, Equipment> takeEquipment;

	public User() {
		super();
	}

	public User(Long userId, String login, String password, int role, String firstname, String lastname,
			String passport, String email, String adress, String telNumber, Map<Integer, Equipment> takeEquipment) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.role = role;
		this.firstname = firstname;
		this.lastname = lastname;
		this.passport = passport;
		this.email = email;
		this.adress = adress;
		this.telNumber = telNumber;
		this.takeEquipment = takeEquipment;
	}

	public User(User user, Map<Integer, Equipment> takeEquipment) {
		this.userId = user.getUserId();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.role = user.getRole();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.passport = user.getPassport();
		this.email = user.getEmail();
		this.adress = user.getAdress();
		this.telNumber = user.getTelNumber();
		this.takeEquipment = takeEquipment;
	}

	public User(Long userId, String login, String password, int role, String firstname, String lastname,
			String passport, String email, String adress, String telNumber) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.role = role;
		this.firstname = firstname;
		this.lastname = lastname;
		this.passport = passport;
		this.email = email;
		this.adress = adress;
		this.telNumber = telNumber;
	}

	public User(String login, String password, int role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public Map<Integer, Equipment> getTakeEquipment() {
		return takeEquipment;
	}

	public void setTakeEquipment(Map<Integer, Equipment> takeEquipment) {
		this.takeEquipment = takeEquipment;
	}

	public void printClientInfo() {
		String infoClient = "";
		infoClient = getFirstname() + ", " + getLastname() + ", " + getPassport()
				+ ", " + getAdress() + ", " + getTelNumber();
		System.out.println(infoClient);
	/*	if (getTakeEquipment().size() > 0) {
			System.out.println("Арендованное оборудование:");
			for (Map.Entry<Integer, Equipment> e : getTakeEquipment().entrySet()) {
				e.getValue().print();
			}
		} else {
			System.out.println("Пока нет арендованного оборудования");
		}
		*/
	}

	public void printUserInfo() {
		String infoUser = "";
		infoUser = "login: " + getLogin() + ", pass: " + getPassword() + ", role: "
				+ getRole() + "]";
		System.out.println(infoUser);
	}

	public String getRoleName(int role) {
		String roleName = "";
		switch (role) {
		case 0: {
			roleName = ROLE.User.toString();
			break;
		}
		case 1: {
			roleName = ROLE.Admin.toString();
			break;
		}
		case 2: {
			roleName = ROLE.Guest.toString();
			break;
		}
		case 3: {
			roleName = ROLE.Manager.toString();
			break;
		}
		default: {
			roleName = ROLE.Guest.toString();
			break;
		}
		}
		return roleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((passport == null) ? 0 : passport.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + role;
		result = prime * result + ((takeEquipment == null) ? 0 : takeEquipment.hashCode());
		result = prime * result + ((telNumber == null) ? 0 : telNumber.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		User other = (User) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (passport == null) {
			if (other.passport != null)
				return false;
		} else if (!passport.equals(other.passport))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (takeEquipment == null) {
			if (other.takeEquipment != null)
				return false;
		} else if (!takeEquipment.equals(other.takeEquipment))
			return false;
		if (telNumber == null) {
			if (other.telNumber != null)
				return false;
		} else if (!telNumber.equals(other.telNumber))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", login=" + login + ", password=" + password + ", role=" + role
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", passport=" + passport + ", email=" + email
				+ ", adress=" + adress + ", telNumber=" + telNumber + "]";
	}

	

}
