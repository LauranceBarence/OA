package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.AffairRelModulePart;

public interface AffairRelModulePartMapper {

	public void add(@Param("moduleParts") List<AffairRelModulePart> moduleParts);
	
	List<AffairRelModulePart> getModulePartsByAffairModuleId(Integer id);

	public void deletePartsById(Integer id);
}
