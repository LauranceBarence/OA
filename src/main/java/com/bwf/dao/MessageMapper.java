package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Message;
import com.bwf.entity.User;

public interface MessageMapper {

	List<Message> getMessageByUserId(Integer userId);

	void addemail(Message message);

	List<Message> sentMessageByUserId(Integer userId);
	List<User> getMessageBySendIdWithRecivers( Integer[] message);	
	
	void addSenderAndReciver(Message message);

	List<Message> getReciveMessage(Integer userId);
	
}
