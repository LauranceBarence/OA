package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	
	//
	List<User> getAllUsers();

	Integer getAllUserCount();

	List<User> getAllUsersByPage(@Param("p")Integer p, @Param("pageSize")Integer pageSize);

	void deleteMulti(@Param("idArr")Integer[] idArr);

	void updateWithPassword(User user);

	void updateWithoutPassword(User user);

	void delete(Integer id);


}
