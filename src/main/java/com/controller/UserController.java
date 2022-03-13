package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.User;
import com.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bp;
	
	@GetMapping(value={"/","index"})
	public String index() {
		return "index";
	}
	
	@PostMapping(value={"/register"})
	public String register(@ModelAttribute User user,HttpSession session) {
		System.out.println(user);
		user.setRole("ROLE_USER");
		user.setPassword(bp.encode(user.getPassword()));
		String msg=userService.registerUser(user);
		session.setAttribute("msg", msg);
		return "index";
	}
	
	@GetMapping(value={"/login"})
	public String login() {
		return "login";
	}
}
