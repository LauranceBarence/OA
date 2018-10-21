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
@RequestMapping("user")
public class UserController {
	@Autowired
	IUserService userService;

	@GetMapping("login")
	public String login(Integer error, ModelMap model) {
		model.addAttribute("error", error);
		return "user/login";
	}

	@PostMapping("doLogin")
	public String doLogin(User user, HttpSession session) {

		User loginUser = userService.doLogin(user);

		if (loginUser != null) {
			session.setAttribute("currentUser", loginUser);
			return "redirect:/index";
		} else {
			return "redirect:/user/login?error=1";
		}
	}

	@RequestMapping("logout")
	public String logOut(HttpSession session) {
		session.removeAttribute("currentUser");

		return "redirect:/user/login";
	}
}
