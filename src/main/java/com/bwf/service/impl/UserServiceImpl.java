package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======
import org.springframework.transaction.annotation.Transactional;
>>>>>>> bqr

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.MD5Encoding;

@Service
public class UserServiceImpl implements IUserService {
<<<<<<< HEAD
	
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
=======

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

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(MD5Encoding.encodingMd5(user.getPassword()));
		userMapper.addUser(user);
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.getUserbyId(id);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.getAllUsers();
	}

	@Override
	public void updateUser(User user, boolean b) {
		// TODO Auto-generated method stub
		if (b) {
			userMapper.updateWithPassword(user);
		} else {
			userMapper.updateWithoutPassword(user);
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userMapper.delete(id);
	}

	@Override
	public void deleteMulti(Integer[] id) {
		// TODO Auto-generated method stub
		userMapper.deleteMulti(id);
	}

	@Override
	public List<User> getAllUsersByPage(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return userMapper.getAllUsersByPage((page - 1) * pageSize, pageSize);
	}

	@Override
	public Integer getAllUserCount() {
		// TODO Auto-generated method stub
		return userMapper.getAllUserCount();
	}
>>>>>>> bqr

}
