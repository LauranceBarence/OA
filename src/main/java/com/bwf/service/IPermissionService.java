package com.bwf.service;

import java.util.List;

import com.bwf.entity.Permission;
import com.bwf.entity.Role;

public interface IPermissionService {

	public List<Permission> getAllPermission();

	public List<Integer> getPermissionIds(List<Permission> currentRolePermission);

	public Integer getPermissionCount();

	public List<Role> getAllPermissionByPage(Integer page, Integer pageSize);

	public void doAdd(Permission permission, Integer[] operateId, Integer[] menuId);

	public Permission getPermissionById(Integer id);

	public List<Integer> getOperatesById(Integer id);

	public List<Integer> getMenusById(Integer id);

	public void doEdit(Permission p, Integer[] operateId, Integer[] menuId);

	public Permission getFullPermissionById(Integer id);

	public void doDelete(Integer id);

	public void doDeleteMulti(Integer[] ids);

}
