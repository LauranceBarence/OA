package com.bwf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.PermissionMapper;
import com.bwf.entity.Permission;
import com.bwf.entity.Role;
import com.bwf.service.IPermissionService;

@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	PermissionMapper permissionMapper;

	@Override
	public List<Permission> getAllPermission() {
		// TODO Auto-generated method stub
		return permissionMapper.getAllPermission();
	}

	@Override
	public List<Integer> getPermissionIds(List<Permission> currentRolePermission) {
		// TODO Auto-generated method stub
		List<Integer> ids = new ArrayList<Integer>();
		for (Permission p : currentRolePermission) {
			ids.add(p.getPermissionId());
		}
		return ids;
	}

	@Override
	public Integer getPermissionCount() {
		// TODO Auto-generated method stub
		return permissionMapper.getPermissionCount();
	}

	@Override
	public List<Role> getAllPermissionByPage(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return permissionMapper.getAllPermissionByPage((page - 1) * pageSize, pageSize);
	}

	@Transactional
	@Override
	public void doAdd(Permission permission, Integer[] operateId, Integer[] menuId) {
		// TODO Auto-generated method stub
		permissionMapper.addPermission(permission);

		if (operateId != null) {
			permissionMapper.addPermissionOperate(permission.getPermissionId(), operateId);
		}
		if (menuId != null) {
			permissionMapper.addPermissionMenu(permission.getPermissionId(), menuId);
		}
	}

	@Override
	public Permission getPermissionById(Integer id) {
		// TODO Auto-generated method stub
		return permissionMapper.getPermissionById(id);
	}

	@Override
	public List<Integer> getOperatesById(Integer id) {
		// TODO Auto-generated method stub
		return permissionMapper.getOperatesById(id);
	}

	@Override
	public List<Integer> getMenusById(Integer id) {
		// TODO Auto-generated method stub
		return permissionMapper.getMenusById(id);
	}

	@Override
	public void doEdit(Permission p, Integer[] operateId, Integer[] menuId) {
		// TODO Auto-generated method stub
		permissionMapper.editPermission(p);
		permissionMapper.deleteOperate(p.getPermissionId());
		permissionMapper.deleteMenu(p.getPermissionId());
		if(operateId!=null){
			permissionMapper.addPermissionOperate(p.getPermissionId(), operateId);
		}
		if(menuId!=null){
			permissionMapper.addPermissionMenu(p.getPermissionId(), menuId);
		}
	}

	@Override
	public Permission getFullPermissionById(Integer id) {
		// TODO Auto-generated method stub
		return permissionMapper.getFullPermissionById(id);
	}

	@Override
	public void doDelete(Integer id) {
		// TODO Auto-generated method stub
		permissionMapper.doDelete(id);
	}

	@Override
	public void doDeleteMulti(Integer[] ids) {
		// TODO Auto-generated method stub
		permissionMapper.doDeleteMulti(ids);
	}
}
