package com.jirafe.services;

import java.util.List;

import com.jirafe.entities.User;

public interface UserService {
	
	void createUser(User user);
	User getUserByToken(String token);
	boolean updateToken(String token, String mail);
	List<User> getUserByEmail(String email);
	
}
