package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.OperateMapper;
import com.bwf.entity.Operate;
import com.bwf.service.IOperateService;

@Service
public class OperateServiceImpl implements IOperateService {

	@Autowired
	OperateMapper operateMapper;
	
	@Override
	public List<Operate> getAllOperate() {
		// TODO Auto-generated method stub
		return operateMapper.getAllOperate();
	}

}
