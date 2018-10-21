package com.bwf.dao;

import java.util.List;

import com.bwf.entity.User;

public interface UserMapper {
	User getUserbyId(Integer id);
	
	void addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(Integer id);
	
	User getUserbyNameandPassword(User user);

	User getFullUser(Integer id);
	
	User getLeader(User user);

	List<User> getUsersWithRole();
}
