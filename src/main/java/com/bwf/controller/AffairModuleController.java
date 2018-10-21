package com.bwf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.AffairModule;
import com.bwf.entity.AffairModuleChain;
import com.bwf.entity.AffairModulePart;
import com.bwf.entity.AffairRelModulePart;
import com.bwf.entity.Department;
import com.bwf.entity.User;
import com.bwf.service.IAffairModuleChainService;
import com.bwf.service.IAffairModulePartService;
import com.bwf.service.IAffairModuleService;
import com.bwf.service.IAffairRelModulePartService;
import com.bwf.service.IDepartmentService;
import com.bwf.service.IUserService;
import com.bwf.service.impl.AffairRelModulePartServiceImpl;

@Controller
@RequestMapping("affair_module")
public class AffairModuleController {
	
	@Autowired
	IAffairModuleService affairModuleService;;
	@Autowired
	IAffairModulePartService affairModulePartService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IDepartmentService departmentService;
	
	@Autowired
	IAffairRelModulePartService affairRelModulePartService;
	
	@Autowired
	IAffairModuleChainService affairModuleChainService;
	
	@RequestMapping("show")
	public String design(Integer page,ModelMap model){
		List<AffairModule> modules = null;
		if (page == null) {
			page = 1;
		}
		Integer pageSize = 10;
		Integer allCount = affairModuleService.getModuleCount();
		Integer allPages = (int) Math.ceil(allCount * 1.0 / pageSize);
		modules = affairModuleService.getModulesByPage(page,pageSize);
		model.addAttribute("page", page);
		model.addAttribute("modules", modules);
		model.addAttribute("allPages", allPages);
		return "affair_module/show";
	}
	
	@RequestMapping("add")
	public String add(ModelMap model){
		List<AffairModulePart> parts=affairModulePartService.getAllParts();
		List<Department> departments = departmentService.getAllDepartment();
		List<User> users = userService.getUsersWithRole();
		model.addAttribute("departments", departments);
		model.addAttribute("parts", parts);
		model.addAttribute("users", users);
		return "affair_module/add";
	}
	
	@RequestMapping("doAdd")
	public String doAdd(AffairModule module,String[] partName,Integer[] partType,String[] partData, Integer[] chainIds){
		 
		affairModuleService.doAdd(module,partName,partType,partData,chainIds);
		return "redirect:/affair_module/show";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Integer id){
		affairModuleService.deleteModule(id);
		return "redirect:/affair_module/show";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(@PathVariable Integer id,ModelMap model){
		AffairModule affairModule = affairModuleService.getAffairModuleById(id);
		List<AffairRelModulePart> moduleOptions = affairRelModulePartService.getModulePartsByAffairModuleId(id);
		List<AffairModuleChain> affairModuleChains = affairModuleChainService.getAffairModuleChainsByAffairModuleId(id);
		List<AffairModulePart> parts=affairModulePartService.getAllParts();
		List<User> users = userService.getUsersWithRole();
		model.addAttribute("affairModule", affairModule);
		model.addAttribute("moduleOptions", moduleOptions);
		model.addAttribute("allDepartments", departmentService.getAllDepartment() ) ;
		model.addAttribute("affairModuleChains", affairModuleChains);
		model.addAttribute("users", users);
		model.addAttribute("parts", parts);
		model.addAttribute("id", id);
		return "affair_module/edit";
	}
	
	@RequestMapping("doEdit/{id}")
	public String doEdit(@PathVariable Integer id,AffairModule module,String[] partName,Integer[] partType,String[] partData, Integer[] approverId){
		affairModuleService.doEdit(id,module,partName,partType,partData,approverId);
		return "redirect:/affair_module/show";
	}
	
	@RequestMapping("view/{id}")
	public String view(@PathVariable Integer id,ModelMap model){
		AffairModule affairModule = affairModuleService.getAffairModuleById(id);
		List<AffairRelModulePart> moduleOptions = affairRelModulePartService.getModulePartsByAffairModuleId(id);
		List<AffairModuleChain> affairModuleChains = affairModuleChainService.getAffairModuleChainsByAffairModuleId(id);
		List<User> users = userService.getUsersWithRole();
		model.addAttribute("affairModule", affairModule);
		model.addAttribute("moduleOptions", moduleOptions);
		model.addAttribute("allDepartments", departmentService.getAllDepartment() ) ;
		model.addAttribute("affairModuleChains", affairModuleChains);
		model.addAttribute("users", users);
		model.addAttribute("id", id);
		return "affair_module/view";
	}
}
