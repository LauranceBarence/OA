package com.bwf.service;

import java.util.List;

import com.bwf.entity.Message;

public interface IMessageService {

	List<Message> getMessageByUserId(Integer userId);

	void addemail(Message message);

	List<Message> sentMessageByUserId(Integer userId);

}
