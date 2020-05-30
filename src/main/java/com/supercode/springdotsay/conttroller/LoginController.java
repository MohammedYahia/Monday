package com.supercode.springdotsay.conttroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String loginPage() {
		return "users/login-form";
	}
 
	@RequestMapping("/create")
	public String createUser() {
		return "users/register";
	}

}

