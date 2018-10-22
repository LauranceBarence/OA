package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Message;
import com.bwf.entity.User;

public interface MessageMapper {
	//读取接收
	List<Message> getMessageByUserId(Integer userId);
	//新发送信息
	Integer addemail(Message message);

	List<Message> sentMessageByUserId(Integer userId);
	//展示
	Message showmessage(Integer id);
	
	
	
}
