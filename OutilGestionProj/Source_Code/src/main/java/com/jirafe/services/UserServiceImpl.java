package com.jirafe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jirafe.entities.User;
import com.jirafe.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		userRepository.save(user);
	}
	
	/**
	 * Retourne un utilisateur avec un token donné
	 */
	public User getUserByToken(String token) {
		User user = userRepository.findByToken(token);
		if(user != null)
			return user;
		else
			return null;
	}
	
	/**
	 * Met à jour le token pour un user, en le récupérant via son adresse mail
	 */
	public boolean updateToken(String token, String mail) {
		List<User> user = userRepository.findByMail(mail);
		if(user != null && !user.isEmpty()) {
			user.get(0).setToken(token);
			userRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retourne un user en fonction de son id
	 */
	public List<User> getUserByEmail(String email) {
		return userRepository.findByMail(email);
	}

}
