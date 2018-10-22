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
	public User login(User user) {
		User u =  userMapper.getUserByUsernameAndPassword(user);
		if (u != null) {
			u = userMapper.getMenusAndOperatesByUserId(u.getUserId());
		}
		return u;
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userMapper.getAllUsers();
	}
	@Override
	public Integer getAllUserCount() {
		// TODO Auto-generated method stub
		return userMapper.getAllUserCount();
	}
	@Override
	public List<User> getAllUsersByPage(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return userMapper.getAllUsersByPage((page - 1) * pageSize, pageSize);
	}
	@Override
	public void delete(Integer id) {
		userMapper.delete(id);
		
	}
	@Override
	public void deleteMulti(Integer[] idArr) {
		userMapper.deleteMulti(idArr);
		
	}
	@Override
	public void add(User user) {
		user.setPassword(MD5Encoding.encodingMd5(user.getPassword()));
		userMapper.add(user);	
	}
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(id);
	}
	@Override
	public void update(User user, boolean resetPassword) {
		if (resetPassword) {
			userMapper.updateWithPassword(user);
		} else {
			userMapper.updateWithoutPassword(user);
		}
		
	}
}
