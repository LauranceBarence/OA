package com.bwf.service;

import java.util.List;

import com.bwf.entity.Message;

public interface IMessageService {
	//读取接收的信息
	List<Message> getMessageByUserId(Integer userId);
	//发送
	void addemail(Message message, List<Integer> list, Integer sender);
	
	//读取发送的信息
	List<Message> sentMessageByUserId(Integer userId);
	//展示信息
	Message showmessage(Integer id);



	

}
