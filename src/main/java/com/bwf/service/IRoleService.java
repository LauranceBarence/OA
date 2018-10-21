package com.bwf.service;

import java.util.List;

import com.bwf.entity.Role;

public interface IRoleService {

	List<Role> getAllRoles();

	Integer getRoleCount();

	List<Role> getAllRolesByPage(Integer page, Integer pageSize);

	void doDelete(Integer id);

	void doDeleteMulti(Integer[] ids);

	void addRole(Role role);

	void addRolePermission(Role role,Integer[] permissionId);

	Role getRoleById(Integer id);

	void editRole(Role role, Integer[] permissionId);


}
