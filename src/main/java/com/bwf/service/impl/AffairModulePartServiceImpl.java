package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.AffairModulePartMapper;
import com.bwf.entity.AffairModulePart;
import com.bwf.service.IAffairModulePartService;

@Service
public class AffairModulePartServiceImpl implements IAffairModulePartService {

	@Autowired
	AffairModulePartMapper affairModulePartMapper;

	@Override
	public List<AffairModulePart> getAllParts() {
		// TODO Auto-generated method stub
		return affairModulePartMapper.getAllParts();
	}

	
}
