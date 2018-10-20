package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Message;

public interface MessageMapper {

	List<Message> getMessageByUserId(Integer userId);

	void addemail(Message message);

	List<Message> sentMessageByUserId(Integer userId);

	void addSenderAndReciver(Message message);
	
}
