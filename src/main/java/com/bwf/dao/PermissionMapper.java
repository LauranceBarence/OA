package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Permission;
import com.bwf.entity.Role;

public interface PermissionMapper {

	List<Permission> getAllPermission();

	Integer getPermissionCount();

	List<Role> getAllPermissionByPage(@Param("page") int page, @Param("pageSize") Integer pageSize);

	void addPermission(Permission permission);

	void addPermissionOperate(@Param("permissionId") Integer permissionId,@Param("operateIds") Integer[] operateId);

	void addPermissionMenu(@Param("permissionId") Integer permissionId,@Param("menuIds") Integer[] menuId);

	Permission getPermissionById(Integer id);

	List<Integer> getOperatesById(Integer id);

	List<Integer> getMenusById(Integer id);

	void editPermission(Permission p);

	void deleteOperate(Integer id);

	void deleteMenu(Integer id);

	Permission getFullPermissionById(Integer id);

	void doDelete(Integer id);

	void doDeleteMulti(@Param("ids") Integer[] ids);



}
