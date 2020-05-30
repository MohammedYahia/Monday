package com.supercode.springdotsay.conttroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.supercode.springdotsay.model.User;
import com.supercode.springdotsay.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping("/list")
	public String viewAllUsers(Model theModel) {
		
		List<User> users =  userService.findAll();
		
		theModel.addAttribute("user",users);
		
		return "users/users-list";
	}
	@GetMapping("/user/{id}")
	public String veiwSingleUser(@PathVariable("id") int id , Model theModel) {
	  User theUser = userService.findById(id);
	  
	  if(theUser == null) {
		  throw new RuntimeException("the user NOT_FOUND--" + id);
	  }

	  return "index";
   }

	@PostMapping("/create")
	public String createUser(User theUser) {
		
		userService.save(theUser);
		
		return "users/";
		
	}
	@DeleteMapping("/user/{id}")
	public void deleteById(@PathVariable("id") int id, Model theModel) {
	User delUser = userService.findById(id);
	if(delUser == null) {
		throw new RuntimeException("the user NOT_FOUND--" +id);
		
	}
	    theModel.addAttribute("User",delUser);
	    userService.deleteById(id);
	
	
	}

	@RequestMapping("/")
	public String HomePage() {
		return "index";
	}





}
