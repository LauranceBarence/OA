package com.bwf.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.MD5Encoding;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	IUserService userService;
	
	@GetMapping("login")
	public String login(Integer error,ModelMap modelMap){
		modelMap.addAttribute("error", error);
		return "user/login";
	}
	@PostMapping("doLogin")
	public String doLogin(User user ,HttpSession session){

		
		user.setPassword(MD5Encoding.encodingMd5(user.getPassword()));

		User loginUser =userService.login(user);
		if (loginUser==null) {		
			return "redirect:/user/login?error=1";
		}else{	
//			User UserWithMenus = userService.getMenusByUserId(loginUser.getUserId());
			session.setAttribute("user", loginUser);

			
			return "redirect:/index";
		
		}
	}
	
	
	
	@GetMapping("logout")
	public String logout(HttpSession session){
		
		session.removeAttribute("user");
		return "redirect:/user/login";
	}
}
