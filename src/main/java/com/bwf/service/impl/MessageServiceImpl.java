package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.MessageMapper;
import com.bwf.dao.SenderAndReciverMapper;
import com.bwf.entity.Message;
import com.bwf.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	MessageMapper messageMapper;
	
	@Autowired
	SenderAndReciverMapper senderAndReciverMapper;

	//发送
	@Override
	@Transactional
	public void addemail(Message message, List<Integer> list, Integer sender) {
	
		//新增邮件表
		messageMapper.addemail(message);
		senderAndReciverMapper.addSenderAndReciver(message,list,sender);
		
		
	}
	
	//接收
	@Override
	public List<Message> getMessageByUserId(Integer userId) {
			
		return  messageMapper.getMessageByUserId(userId);
		
	}
	
	//读取发送的信息
	@Override
	public List<Message> sentMessageByUserId(Integer userId) {
		List<Message> messages=messageMapper.sentMessageByUserId(userId);
		
		return messages;
	}

	@Override
	public Message showmessage(Integer id) {
		
		return messageMapper.showmessage(id);
	}



}
