package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.RoleMapper;
import com.bwf.entity.Role;
import com.bwf.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	RoleMapper roleMapper;

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleMapper.getAllRoles();
	}

	@Override
	public Integer getRoleCount() {
		// TODO Auto-generated method stub
		return roleMapper.getRoleCount();
	}

	@Override
	public List<Role> getAllRolesByPage(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return roleMapper.getAllRolesByPage((page - 1) * pageSize, pageSize);
	}

	@Override
	public void doDelete(Integer id) {
		// TODO Auto-generated method stub
		roleMapper.doDelete(id);
	}

	@Override
	public void doDeleteMulti(Integer[] ids) {
		// TODO Auto-generated method stub
		roleMapper.doDeleteMulti(ids);
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		roleMapper.addRole(role);
	}

	@Override
	public void addRolePermission(Role role, Integer[] permissionId) {
		// TODO Auto-generated method stub
		Role newRole = roleMapper.getRoleByName(role);
		roleMapper.addRolePermission(newRole, permissionId);
	}

	@Override
	public Role getRoleById(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleById(id);
	}

	@Transactional
	@Override
	public void editRole(Role role, Integer[] permissionId) {
		// TODO Auto-generated method stub
		Role rightRole = roleMapper.getRoleById(role.getRoleId());
		if (role.getDepartmentId() != -1) {
			rightRole.setDepartmentId(role.getDepartmentId());
		} else {
			rightRole.setDepartmentId(null);
		}
		roleMapper.editRole(rightRole);
		roleMapper.deleteRolePermission(rightRole);
		if (permissionId != null) {
			roleMapper.addRolePermission(rightRole, permissionId);
		}
	}
}
