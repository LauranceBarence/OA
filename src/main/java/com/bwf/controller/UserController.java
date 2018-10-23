package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
			List<Menu> menus = loginUser.getMenus();
			
			for(Menu m:menus){
				System.out.println(m);
			}
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
		map.addAttribute("allPages", allPages);
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
		// 上传头像部分...
		
		if (  bindingResult.hasErrors() ) {
			
			// 参考登录错误的页面进行处理
			modelMap.addAttribute("errors", bindingResult.getAllErrors() );
			return "redirect:/user/add";
		} else {
			
			// 执行添加功能 
			userService.addUser( user );
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
			
			userService.updateUser( user , resetPassword!=null );
			
			return "redirect:/user/show";
			
		}
}
