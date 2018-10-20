package com.bwf.service;

import java.util.List;

import com.bwf.entity.User;

public interface IUserService {
	User getUser(User user);
	
	List<User> getAllUsers();
}
