package com.bwf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Menu;
import com.bwf.entity.Operate;
import com.bwf.entity.Permission;
import com.bwf.entity.Role;
import com.bwf.service.IMenuService;
import com.bwf.service.IOperateService;
import com.bwf.service.IPermissionService;

@Controller
@RequestMapping("permission")
public class PermissionController {

	@Autowired
	IPermissionService permissionService;
	@Autowired
	IMenuService menuService;
	@Autowired
	IOperateService operateService;

	@RequestMapping("show")
	public String show(Integer page, ModelMap model) {
		List<Role> permissions = null;
		if (page == null) {
			page = 1;
		}
		Integer pageSize = 10;
		Integer allCount = permissionService.getPermissionCount();
		Integer allPages = (int) Math.ceil(allCount * 1.0 / pageSize);
		permissions = permissionService.getAllPermissionByPage(page, pageSize);
		model.addAttribute("allPages", allPages);
		model.addAttribute("permissions", permissions);
		model.addAttribute("page", page);
		return "permission/show";
	}

	@RequestMapping("add")
	public String add(ModelMap model) {
		List<Permission> permissions = permissionService.getAllPermission();
		List<Menu> menus = menuService.getAllMenu();
		List<Operate> operate = operateService.getAllOperate();
		model.addAttribute("menus", menus);
		model.addAttribute("permissions", permissions);
		model.addAttribute("operate", operate);
		return "permission/add";
	}

	@RequestMapping("doAdd")
	public String doAdd(Permission permission, Integer[] operateId, Integer[] menuId) {

		permissionService.doAdd(permission, operateId, menuId);

		return "redirect:/permission/show";
	}

	@RequestMapping("edit/{id}")
	public String edit(@PathVariable Integer id, ModelMap model) {
		Permission p = permissionService.getPermissionById(id);
		List<Integer> permissionOperateId = permissionService.getOperatesById(id);
		List<Integer> permissionMenuId = permissionService.getMenusById(id);
		List<Permission> permissions = permissionService.getAllPermission();
		List<Menu> menus = menuService.getAllMenu();
		List<Operate> operate = operateService.getAllOperate();
		if (p != null) {
			model.addAttribute("currentPermission", p);
		}
		if (permissionOperateId != null) {
			model.addAttribute("permissionOperateId", permissionOperateId);
		}
		if (permissionMenuId != null) {
			model.addAttribute("permissionMenuId", permissionMenuId);
		}
		model.addAttribute("permissions", permissions);
		model.addAttribute("menus", menus);
		model.addAttribute("operates", operate);
		return "permission/edit";
	}

	@RequestMapping("doEdit")
	public String doEdit(Permission p, Integer[] operateId, Integer[] menuId) {
		permissionService.doEdit(p, operateId, menuId);

		return "redirect:/permission/show";
	}

	@RequestMapping("view/{id}")
	public String view(@PathVariable Integer id, ModelMap model) {
		List<Permission> permissions = permissionService.getAllPermission();
		Permission currentPermission = permissionService.getFullPermissionById(id);
		model.addAttribute("permissions", permissions);
		if (currentPermission != null) {
			model.addAttribute("currentPermission", currentPermission);
			 List<Operate> operates = currentPermission.getOperates();
			 List<Menu> menus = currentPermission.getMenus();
			 if(operates!=null){
			 model.addAttribute("operates", operates);
			 }
			 if(menus!=null){
				 System.out.println(menus.size());
			 model.addAttribute("menus", menus);
			 }
			return "permission/view";
		} else {
			return "permission/show";
		}
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Integer id) {
		permissionService.doDelete(id);
		return "redirect:/permission/show";
	}

	@RequestMapping("multiDelete")
	public String mutiDelete(Integer[] ids) {
		if (ids != null) {
			permissionService.doDeleteMulti(ids);
			return "redirect:/permission/show";
		} else {
			return "redirect:/permission/show?error=1";
		}

	}
}
