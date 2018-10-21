package com.bwf.service;

import java.util.List;

import com.bwf.entity.User;

public interface IUserService {

	User doLogin(User user);

	List<User> getUsersWithRole();
}
