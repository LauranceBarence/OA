package com.bwf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Department;
import com.bwf.entity.Permission;
import com.bwf.entity.Role;
import com.bwf.service.IDepartmentService;
import com.bwf.service.IPermissionService;
import com.bwf.service.IRoleService;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	IRoleService roleService;

	@Autowired
	IDepartmentService departmentService;

	@Autowired
	IPermissionService permissionService;

	@RequestMapping("show")
	public String show(Integer page, ModelMap model) {
		List<Role> roles = null;
		if (page == null) {
			page = 1;
		}
		Integer pageSize = 10;
		Integer allCount = roleService.getRoleCount();
		Integer allPages = (int) Math.ceil(allCount * 1.0 / pageSize);
		roles = roleService.getAllRolesByPage(page, pageSize);
		model.addAttribute("allPages", allPages);
		model.addAttribute("roles", roles);
		model.addAttribute("page", page);
		return "role/show";
	}

	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Integer id) {
		roleService.doDelete(id);
		return "redirect:/role/show";
	}

	@RequestMapping("multiDelete")
	public String mutiDelete(Integer[] ids) {
		if (ids != null) {
			roleService.doDeleteMulti(ids);
			return "redirect:/role/show";
		} else {
			return "redirect:/role/show?error=1";
		}

	}

	@RequestMapping("add")
	public String add(ModelMap model) {
		List<Department> departments = departmentService.getAllDepartment();
		List<Permission> permissions = permissionService.getAllPermission();
		if (departments != null) {
			model.addAttribute("departments", departments);
		}
		if (permissions != null) {
			model.addAttribute("permissions", permissions);
		}
		return "role/add";
	}

	@Transactional
	@RequestMapping("doAdd")
	public String doAdd(Role role, Integer[] permissionId) {
		roleService.addRole(role);
		roleService.addRolePermission(role, permissionId);
		return "redirect:/role/show";
	}

	@RequestMapping("edit/{id}")
	public String edit(@PathVariable Integer id, ModelMap model) {
		Role currentRole = roleService.getRoleById(id);
		List<Department> departments = departmentService.getAllDepartment();
		List<Permission> permissions = permissionService.getAllPermission();
		List<Permission> currentRolePermission;
		List<Integer> currentRolePermissionIds;
		if (departments != null) {
			model.addAttribute("departments", departments);
		}
		if (permissions != null) {
			model.addAttribute("permissions", permissions);
		}
		if (currentRole != null) {
			model.addAttribute("currentRole", currentRole);
			currentRolePermission = currentRole.getPermissions();
			currentRolePermissionIds = permissionService.getPermissionIds(currentRolePermission);
			model.addAttribute("currentRolePermissionIds", currentRolePermissionIds);
			return "role/edit";
		} else {
			return "redirect:/role/show";
		}
	}

	@RequestMapping("doEdit")
	public String doEdit(Role role, Integer[] permissionId) {
		roleService.editRole(role, permissionId);

		return "redirect:/role/show";
	}

	@RequestMapping("view/{id}")
	public String view(@PathVariable Integer id, ModelMap model) {
		Role currentRole = roleService.getRoleById(id);
		List<Department> departments = departmentService.getAllDepartment();
		List<Permission> permissions;
		if (departments != null) {
			model.addAttribute("departments", departments);
		}
		if (currentRole != null) {
			model.addAttribute("currentRole", currentRole);
			permissions = currentRole.getPermissions();
			model.addAttribute("permissions", permissions);
			return "role/view";
		} else {
			return "redirect:/role/show";
		}
	}
}
