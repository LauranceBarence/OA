package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bwf.dao.RosterMapper;
import com.bwf.entity.Attendence;
import com.bwf.service.IRosterService;
@Service
public class RosterServiceImpl implements IRosterService {
	
	@Autowired
	RosterMapper rosterMapper;
	
	@Override
	public List<Attendence> getAllAttendence() {
		// TODO Auto-generated method stub
		return rosterMapper.getAllAttendence();
	}

	@Override
	public Integer add(Attendence attendence) {
		// TODO Auto-generated method stub
		return rosterMapper.add(attendence);
	}

	@Override
	public List<Attendence> getAttendenceById(Integer id) {
		// TODO Auto-generated method stub
		return rosterMapper.getAttendenceById(id);
	}



}
