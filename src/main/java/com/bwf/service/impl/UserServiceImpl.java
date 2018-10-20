package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.MD5Encoding;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getUser(User user) {
		
		String password = MD5Encoding.encodingMd5(user.getPassword());

		user.setPassword(password);
		User loginUser = userMapper.getUserBy(user);
	
		return loginUser;
	}
	//获取所有用户
	@Override
	public List<User> getAllUsers() {
		
		return userMapper.getAllUsers();
	}

}
