package com.bwf.controller;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> bqr
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> bqr
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Message;
import com.bwf.entity.User;
import com.bwf.service.IMessageService;
import com.bwf.service.IUserService;
import com.bwf.utils.DateTime;

@Controller
<<<<<<< HEAD
=======
@RequestMapping("email")
>>>>>>> bqr
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
<<<<<<< HEAD
=======
		
>>>>>>> bqr
	}
	
	//发送信息
	@PostMapping("sendemail")
<<<<<<< HEAD
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
=======
	public String sendemail(HttpSession session,Message message ,Integer[] reciverIds){
		User user = (User)session.getAttribute("currentUser");
		String datetime =DateTime.returnDateTime(); 
		message.setMessageTime(datetime);
		//过滤重复
		List<Integer> sender = new ArrayList<Integer>();
		List<Integer> reciver = new ArrayList<Integer>();
		for(int i =0;reciverIds.length>i;i++){
			if(!reciver.contains(reciverIds[i])){
				reciver.add(reciverIds[i]);
				sender.add(user.getUserId());
			}
		}
		messageService.addemail(message , reciver,user.getUserId());
		return "redirect:newemail";
	}
	
	//读取接收的信息
	@RequestMapping("email")
	public String email(HttpSession session,ModelMap modelMap){
		User user = (User)session.getAttribute("currentUser");
		List<Message> messages = messageService.getMessageByUserId(user.getUserId());
		
		modelMap.addAttribute("recivemessage",messages);
//		System.out.println(messages.size());
//		System.out.println(messages.get(1).toString());
//		
		
		List<User> users =new ArrayList<User>(); 
	
		for(int i=0;messages.size()>i;i++){
			users.add(messages.get(i).getUser());
		}
		modelMap.addAttribute("users", users);
>>>>>>> bqr
		return "email/emailtable";
	}
	
	//读取发送的信息
	@RequestMapping("sentemail")
	public String sentemail(HttpSession session,ModelMap modelMap){
<<<<<<< HEAD
		User user =(User)session.getAttribute("user");
		List<Message> messages = messageService.sentMessageByUserId(user.getUserId());
		
//		Integer ids[]=new Integer[messages.size()];
//		for(int i = 0 ; messages.size()>i;i++){
//			ids[i]=messages.get(i).getMessageId();	
//		}
//		List<User> recivers = messageService.getReciversByMessageId(ids);
		
		modelMap.addAttribute("messages",messages);
//		modelMap.addAttribute("recivers", recivers);
		
=======
		User user =(User)session.getAttribute("currentUser");
		List<Message> messages = messageService.sentMessageByUserId(user.getUserId());

		modelMap.addAttribute("messages",messages);
	
		List<User> users =new ArrayList<User>(); 
		for(int i=0;messages.size()>i;i++){
			users.add(messages.get(i).getUser());
		}
		modelMap.addAttribute("users", users);
>>>>>>> bqr
		return "email/sentemail";
	}
	
	//读取删除的信息 
	@RequestMapping("deletemail")
	public String deletemail(){
		
		return "email/deletemail";
	}
<<<<<<< HEAD
=======
	
	//展示信息
	@RequestMapping("showmessage/{id}")
	public String showmessage(@PathVariable Integer id,ModelMap modelMap){
		
		modelMap.addAttribute("showmessage",  messageService.showmessage(id));
		
		return "email/read";
	}
	
>>>>>>> bqr
}
