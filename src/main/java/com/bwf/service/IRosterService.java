package com.bwf.service;

import java.util.List;

import com.bwf.entity.Attendence;

public interface IRosterService {
	
	List<Attendence> getAllAttendence();

	Integer add(Attendence attendence);

	List<Attendence> getAttendenceById(Integer id);

}
