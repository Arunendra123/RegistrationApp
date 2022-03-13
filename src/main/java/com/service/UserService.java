package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userdao;
	
	public String registerUser(User user) {
		if(userdao.findUserByEmail(user.getEmail())==null) {
			userdao.save(user);
			return "User Registered Successfully...";
		} else {
			return "User Already Registered...";
		}
	}
}
