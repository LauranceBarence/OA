package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bwf.dao.AffairRelModulePartMapper;
import com.bwf.entity.AffairRelModulePart;
import com.bwf.service.IAffairRelModulePartService;

@Controller
public class AffairRelModulePartServiceImpl implements IAffairRelModulePartService {

	@Autowired
	AffairRelModulePartMapper affariRelModulePartMapper;
	@Override
	public List<AffairRelModulePart> getModulePartsByAffairModuleId(Integer id) {
		// TODO Auto-generated method stub
		return affariRelModulePartMapper.getModulePartsByAffairModuleId(id);
	}

}
