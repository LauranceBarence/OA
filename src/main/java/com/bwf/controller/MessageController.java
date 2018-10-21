package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Message;
import com.bwf.entity.User;
import com.bwf.service.IMessageService;
import com.bwf.service.IUserService;
import com.bwf.utils.DateTime;

@Controller
public class MessageController {
	@Autowired
	IMessageService messageService;

	@Autowired
	IUserService userService;
	

	
	//新建信息
	@GetMapping("newemail")
	public String newemail(ModelMap modelMap){
		modelMap.addAttribute("allUsers", userService.getAllUsers());
		return "email/newemailtable";
	}
	
	//发送信息
	@PostMapping("sendemail")
	public String sendemail(Message message){
		
		String datetime =DateTime.returnDateTime(); 
		message.setMessageTime(datetime);

		messageService.addemail(message);
		
		
		return "redirect:newemail";
	}
	//读取接收的信息
	@RequestMapping("email")
	public String email(HttpSession session,ModelMap modelMap){
		User user = (User)session.getAttribute("user");
		
		modelMap.addAttribute("recivemessage",messageService.getMessageByUserId(user.getUserId()));
		return "email/emailtable";
	}
	
	//读取发送的信息
	@RequestMapping("sentemail")
	public String sentemail(HttpSession session,ModelMap modelMap){
		User user =(User)session.getAttribute("user");
		List<Message> messages = messageService.sentMessageByUserId(user.getUserId());
		
//		Integer ids[]=new Integer[messages.size()];
//		for(int i = 0 ; messages.size()>i;i++){
//			ids[i]=messages.get(i).getMessageId();	
//		}
//		List<User> recivers = messageService.getReciversByMessageId(ids);
		
		modelMap.addAttribute("messages",messages);
//		modelMap.addAttribute("recivers", recivers);
		
		return "email/sentemail";
	}
	
	//读取删除的信息 
	@RequestMapping("deletemail")
	public String deletemail(){
		
		return "email/deletemail";
	}
}
