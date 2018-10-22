package com.bwf.controller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Menu;
import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.MD5Encoding;

@Controller
@RequestMapping("user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	// 显示登录页面
	@GetMapping("login")
	public String login( Integer error , ModelMap modelMap ){
		modelMap.addAttribute("error", error);
		return "user/login";
	}
	
	// 进行登录
	@PostMapping("doLogin")
	public String doLogin( User user , HttpSession session ){
		logger.info("{}, {}" , user.getUsername() , user.getPassword());
		
		// 把密码进行加密：
		user.setPassword( MD5Encoding.encodingMd5( user.getPassword() ) );
		logger.info( "password : {}" , user.getPassword() );
		
		// 执行登录 功能 
		User loginUser = userService.login( user );
		
		if ( loginUser == null ) {
			// 登录失败
			logger.info("登录失败，用户名或密码错误");
			
			// 带着错误信息， 跳转到 登录页面
			return "redirect:/user/login?error=1";
			
		} else {
			// 登录成功
			logger.info("登录成功");
			
			// 写入 session 
			session.setAttribute("user", loginUser );
			
//			for( Menu menu : loginUser.getMenus() ) {
//				logger.warn( menu.toString() );
//			}
			
			// 跳转到 首页
			return "redirect:/index";
		}
		
	}

	// 退出登录
	@GetMapping("logout")
	public String logout( HttpSession session ){
		session.removeAttribute("user");
		return "redirect:/user/login";
	}
	
	@GetMapping("show")
	public String show( Integer page, ModelMap map) {
		if (page == null) {
			page = 1;
		}
		Integer pageSize = 10;
		Integer allCount = userService.getAllUserCount();
		Integer allPages = (int)Math.ceil(allCount * 1.0 / pageSize);
		
//		List<User> allUsers = userService.getAllUsers();
		List<User> allUsers = userService.getAllUsersByPage(page, pageSize);
		map.addAttribute("allUsers", allUsers);
		map.addAttribute("page", page);
		return "user/show";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Integer id) {
		userService.delete(id);
		return "redirect:/user/show";
	}
	
	@GetMapping("delete")
	public String deleteMulti(Integer[] id) {
		userService.deleteMulti(id);
		return "redirect:/user/show";
	}
	
	@GetMapping("add")
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("allUsers", userService.getAllUsers());
		return "user/add";
	}
	
	@PostMapping("doAdd")
	public String doAdd( @Valid User user , BindingResult bindingResult , ModelMap modelMap ){
		logger.info( user.toString() );
		logger.info( user.getLeader().getUserId() + "" );
		// 上传头像部分...
		
		if (  bindingResult.hasErrors() ) {
			
			// 参考登录错误的页面进行处理
			modelMap.addAttribute("errors", bindingResult.getAllErrors() );
			return "redirect:/user/add";
		} else {
			
			// 执行添加功能 
			userService.add( user );
			System.out.println("non-error");
			return "redirect:/user/show";
		}		
	}
	
	// 展示修改员工信息的界面
		@GetMapping("edit/{id}")
		public String edit( @PathVariable Integer id , ModelMap map){
			// 根据id获取员工信息 User
			User user = userService.getUserById( id );
			List<User> allUsers = userService.getAllUsers();
			 
			// 把 User 信息 添加进 视图 页面
			map.addAttribute("user1", user);
			map.addAttribute("allUsers", allUsers);
			System.out.println(user.toString());
			// 展示视图页面
			return "user/edit";
		}
		
		@PostMapping("doEdit")
		public String doEdit( User user , String resetPassword ){
			logger.info( "修改的员工信息： {}" , user );
			logger.info("是否需要重置密码： {}" , resetPassword!=null );
			
			userService.update( user , resetPassword!=null );
			
			return "redirect:/user/show";
			
		}
}
