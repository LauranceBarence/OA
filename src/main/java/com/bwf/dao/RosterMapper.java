package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.Attendence;

public interface RosterMapper {
	
	List<Attendence> getAllAttendence();

	Integer getAllAttendenceCount();

	List<Attendence> getAllAttendencesByPage(@Param("p")Integer page, @Param("pageSize")Integer pageSize);

	Integer add(Attendence attendence);

	List<Attendence> getAttendenceById(Integer id);

}
