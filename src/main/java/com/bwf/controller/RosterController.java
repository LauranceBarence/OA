package com.bwf.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Attendence;
import com.bwf.entity.User;
import com.bwf.service.IRosterService;

@Controller
@RequestMapping("roster")
public class RosterController {
	
	@Autowired
	IRosterService rosterService;
	
	@GetMapping("select")
	public String select() {
		return "roster/select";
	}
	
	@GetMapping("show")
	public String show(ModelMap map) {
		List<Attendence> allAttendence = rosterService.getAllAttendence();
		map.addAttribute("allAttendence", allAttendence);
		return "roster/show";
	}
	
	@GetMapping("research")
	public String research(HttpSession session, ModelMap modelMap) {
		Attendence attendence = (Attendence)session.getAttribute("attendence");
		
		List<Attendence> allAttendence = rosterService.getAttendenceById(attendence.getUserId());

		modelMap.addAttribute("allAttendence", allAttendence);

		return "roster/research";
	}

	
	@RequestMapping("addData")
	public String addData( 
//			Attendence attendence
			HttpSession session) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newData = df.format(new Date());
		User user=(User)session.getAttribute("user");
		Attendence attendence=new Attendence();
		attendence.setUserId(user.getUserId());
//		Integer userId = rosterService.add(attendence);
		
//		map.addAttribute("df", df);
//		map.addAttribute("newData", newData);
		attendence.setSignTime(newData);
		rosterService.add(attendence);
		return "redirect:/index?success=1";
	}

}
