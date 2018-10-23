package com.bwf.service;

import java.util.List;

import com.bwf.entity.User;
<<<<<<< HEAD

public interface IUserService {
	User getUser(User user);
	
	List<User> getAllUsers();
=======

public interface IUserService {

	User doLogin(User user);

	List<User> getUsersWithRole();

	void addUser(User user);

	User getUserById(Integer id);

	List<User> getAllUsers();

	void updateUser(User user, boolean b);

	void delete(Integer id);

	void deleteMulti(Integer[] id);

	List<User> getAllUsersByPage(Integer page, Integer pageSize);

	Integer getAllUserCount();

>>>>>>> bqr
}
