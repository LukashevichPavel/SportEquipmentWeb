package by.htp.equipment.dao;

import by.htp.equipment.entity.Client;
import by.htp.equipment.entity.User;

public interface UserDao {
	
	User fetchByCredentials(String login, String password);
	User createUser(User user,Client client);
}
