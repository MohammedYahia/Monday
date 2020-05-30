package com.supercode.springdotsay.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.supercode.springdotsay.model.User;
import com.supercode.springdotsay.repositotry.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	public UserRepository userRepositry;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> users= userRepositry.findByuserName(userName);
		
		if(users == null) {
			throw new UsernameNotFoundException("User Name NOT_FOUND" + userName);
		}
		
		return users.map(MyUserDetails:: new ).get();
	}

}
