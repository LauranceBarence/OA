package com.bwf.dao;

import java.util.List;

import com.bwf.entity.User;

public interface UserMapper {
	
	User getUserBy (User user);

	List<User> getAllUsers();
	
}
