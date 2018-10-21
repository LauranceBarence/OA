package com.bwf.service;

import java.util.List;

import com.bwf.entity.Message;
import com.bwf.entity.User;

public interface IMessageService {

	List<Message> getMessageByUserId(Integer userId);

	void addemail(Message message);

	List<Message> sentMessageByUserId(Integer userId);

	List<User> getReciversByMessageId(Integer[] ids);

}
