package com.supercode.springdotsay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supercode.springdotsay.model.User;
import com.supercode.springdotsay.repositotry.UserRepository;

@Service
public class UserServiceImple implements UserService {

	private UserRepository userRepo;

	@Autowired
	public UserServiceImple(UserRepository theUserRepository) {
		userRepo = theUserRepository;
	}

	@Override
	public List<User> findAll() {

		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {

		Optional<User> result = userRepo.findById(id);
		
		User theUser = null;
		
		if(result.isPresent()) {
			 theUser = result.get();
		 }else {
			 throw new RuntimeException("the user is NOT_FOUND--" + id);
		 }
		
		return theUser;
	}

	@Override
	public void save(User theUser) {

		userRepo.save(theUser);

	}

	public void deleteById(int id) {
		userRepo.deleteById(id);

	}
}
