package com.jirafe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jirafe.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByToken(String token);
	
	List<User> findByMail(String mail);

}
