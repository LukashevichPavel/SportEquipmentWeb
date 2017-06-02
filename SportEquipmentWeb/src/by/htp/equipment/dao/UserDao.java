package by.htp.equipment.dao;

import by.htp.equipment.entity.User;

public interface UserDao {
	
	User fetchByCredentials(String login, String password);
	User createUser(User user);
	User findUserWithId(Long userId);
}
