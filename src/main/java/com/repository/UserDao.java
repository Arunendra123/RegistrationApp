package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.User;

public interface UserDao extends CrudRepository<User, Integer> {
   public User findUserByEmail(String email) ;
}
