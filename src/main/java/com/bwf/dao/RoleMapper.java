package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Role;

public interface RoleMapper {

	List<Role> getAllRoles();

	Integer getRoleCount();

	List<Role> getAllRolesByPage(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

	void doDelete(Integer id);

	void doDeleteMulti(@Param("ids") Integer[] ids);

	void addRole(Role role);

	void addRolePermission(@Param("role") Role role, @Param("permissionIds") Integer[] permissionId);

	Role getRoleByName(Role role);

	Role getRoleById(Integer id);

	void editRole(Role rightRole);

	void deleteRolePermission(Role rightRole);


}
