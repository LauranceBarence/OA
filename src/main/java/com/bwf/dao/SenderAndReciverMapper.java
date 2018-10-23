package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Message;

public interface SenderAndReciverMapper {

	void addSenderAndReciver(@Param("message")Message message,@Param("list") List<Integer> list,@Param("userId") Integer sender);


}
