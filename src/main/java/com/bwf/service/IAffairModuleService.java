package com.bwf.service;

import java.util.List;

import com.bwf.entity.AffairModule;

public interface IAffairModuleService {

	List<AffairModule> getAllModules();

	Integer getModuleCount();

	List<AffairModule> getModulesByPage(Integer page, Integer pageSize);

	void doAdd(AffairModule module, String[] partName, Integer[] partType, String[] partData, Integer[] chainIds);

	AffairModule getAffairModuleById(Integer id);

	void deleteModule(Integer id);

	void doEdit(Integer id, AffairModule module, String[] partName, Integer[] partType, String[] partData,
			Integer[] chainIds);

}
