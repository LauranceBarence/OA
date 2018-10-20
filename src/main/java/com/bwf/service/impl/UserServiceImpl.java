package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	

	@Autowired
	UserMapper userMapper;
	
	@Transactional
	@Override
	public User login(User user) {
		
		User u = userMapper.getUserByUsernameAndPassword(user);
		if (u!=null) {
			u=userMapper.getMenusByUserId(u.getUserId());
		}
		return u;
	}
	

}
