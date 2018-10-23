package com.bwf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD


@Controller
=======
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

>>>>>>> bqr
public class IndexController {
	@GetMapping(value={"","index","index/index"})
	public String index(){
		return "index/index";
	}
	
	@GetMapping("home")
	public String home(){
		return "index/home"; 
	}
	

	
	@RequestMapping(value={"","index","index/index"})
	public String showIndex(){
		return "index";
	}
	
	@GetMapping("home")
	public String showHome(){
		return "home/home";
	}
}
