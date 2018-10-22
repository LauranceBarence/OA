package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.MD5Encoding;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserMapper userMapper;

	@Transactional
	@Override
	public User doLogin(User user) {
		// TODO Auto-generated method stub
		String pwd = user.getPassword();
		user.setPassword(MD5Encoding.encodingMd5(pwd));
		User loginUser = userMapper.getUserbyNameandPassword(user);
		if (loginUser != null) {
			return userMapper.getFullUser(loginUser.getUserId());
		} else {
			return null;
		}
	}

	@Override
	public List<User> getUsersWithRole() {
		// TODO Auto-generated method stub
		return userMapper.getUsersWithRole();
	}

}
