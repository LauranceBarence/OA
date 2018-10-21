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

@Controller
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("login")
	public String login(){
		
		return "index/login";
	}
	
	@PostMapping("doLogin")
	public String dologin(User user ,HttpSession session){
		
		User loginUser=userService.getUser(user);
		if (loginUser==null) {
			
			return "redirect:login?error=1";
		
		}else{
		
			session.setAttribute("user", loginUser);
			return "redirect:/index";
		}
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session ){
		session.removeAttribute("User");
		return "redirect:/login";
	}
	
	
}
