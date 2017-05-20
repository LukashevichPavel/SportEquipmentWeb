package by.htp.equipment.service;

import by.htp.equipment.entity.Client;
import by.htp.equipment.entity.User;

public interface UserService {
	
	User authorise(String login, String password) throws ServiceNoSuchUserException;
	boolean logOut(User user);

	User createUser (Long userId, String login, String password, boolean role, Client client);
}