package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.AffairModule;

public interface AffairModuleMapper {

	List<AffairModule> getAllModules();

	Integer getModuleCount();

	List<AffairModule> getModulesByPage(@Param("page") int page,@Param("pageSize") Integer pageSize);

	void addModule(AffairModule module);

	AffairModule getAffairModuleById(Integer id);

	void deleteModule(Integer id);

	void doEdit(AffairModule module);


}
