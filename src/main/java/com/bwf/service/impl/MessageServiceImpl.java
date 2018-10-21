package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.MessageMapper;
import com.bwf.entity.Message;
import com.bwf.entity.User;
import com.bwf.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	MessageMapper messageMapper;
	
	//接收
	@Override
	public List<Message> getMessageByUserId(Integer userId) {
			
		return  messageMapper.getReciveMessage(userId);
	}
	//发送
	@Override
	@Transactional
	public void addemail(Message message) {
		
		//新增邮件表
		messageMapper.addemail(message);
		
	}
	//读取发送的信息
	@Override
	public List<Message> sentMessageByUserId(Integer userId) {
		List<Message> messages=messageMapper.sentMessageByUserId(userId);
		
		return messages;
	}
	//接收人的信息
	@Override
	public List<User> getReciversByMessageId(Integer[] messages) {
		
		return messageMapper.getMessageBySendIdWithRecivers(messages);
	}

}
