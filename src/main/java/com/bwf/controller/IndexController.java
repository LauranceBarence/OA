package com.bwf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

	
	@RequestMapping(value={"","index","index/index"})
	public String showIndex(){
		return "index";
	}
	
	@GetMapping("home")
	public String showHome(){
		return "home/home";
	}
}
