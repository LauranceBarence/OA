package com.bwf.dao;

import java.util.List;

<<<<<<< HEAD
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
=======
import com.bwf.entity.Message;

public interface MessageMapper {
	//读取接收
	List<Message> getMessageByUserId(Integer userId);
	//新发送信息
	Integer addemail(Message message);

	List<Message> sentMessageByUserId(Integer userId);
	//展示
	Message showmessage(Integer id);
	
	
>>>>>>> bqr
	
}
