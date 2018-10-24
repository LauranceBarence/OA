package com.bwf.service;

import java.util.List;

import com.bwf.entity.AffairRelModulePart;

public interface IAffairRelModulePartService {

	List<AffairRelModulePart> getModulePartsByAffairModuleId(Integer id);

}
