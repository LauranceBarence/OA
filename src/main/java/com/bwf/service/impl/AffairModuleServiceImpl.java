package com.bwf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.AffairModuleChainMapper;
import com.bwf.dao.AffairModuleMapper;
import com.bwf.dao.AffairRelModulePartMapper;
import com.bwf.entity.AffairModule;
import com.bwf.entity.AffairModuleChain;
import com.bwf.entity.AffairRelModulePart;
import com.bwf.service.IAffairModuleService;

@Service
public class AffairModuleServiceImpl implements IAffairModuleService {

	@Autowired
	AffairModuleMapper affairModuleMapper;

	@Autowired
	AffairRelModulePartMapper affairRelModulePartMapper;

	@Autowired

	AffairModuleChainMapper affairModuleChainMapper;

	@Override
	public List<AffairModule> getAllModules() {
		// TODO Auto-generated method stub
		return affairModuleMapper.getAllModules();
	}

	@Override
	public Integer getModuleCount() {
		// TODO Auto-generated method stub
		return affairModuleMapper.getModuleCount();
	}

	@Override
	public List<AffairModule> getModulesByPage(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return affairModuleMapper.getModulesByPage((page - 1) * pageSize, pageSize);
	}

	@Transactional
	@Override
	public void doAdd(AffairModule module, String[] partName, Integer[] partType, String[] partData,
			Integer[] chainIds) {
		// TODO Auto-generated method stub
		// 添加模板
		affairModuleMapper.addModule(module);
		System.out.println(module.toString());
		// 添加组件
		List<AffairRelModulePart> moduleParts = new ArrayList<AffairRelModulePart>();
		for (int i = 0; i < partName.length; i++) {
			AffairRelModulePart m = new AffairRelModulePart();
			m.setModuleId(module.getModuleId());
			m.setOrder(i);
			m.setPartId(partType[i]);
			m.setPartName(partName[i]);
			m.setPartData(partData[i]);

			moduleParts.add(m);
		}

		affairRelModulePartMapper.add(moduleParts);

		// 添加审批链
		List<AffairModuleChain> chains = new ArrayList<AffairModuleChain>();
		for (int i = 0; i < chainIds.length; i++) {
			AffairModuleChain chain = new AffairModuleChain();
			chain.setOrder(i + 1);
			chain.setApproverId(chainIds[i]);
			chain.setModuleId(module.getModuleId());
			chains.add(chain);
		}

		affairModuleChainMapper.add(chains);

	}

	@Override
	public AffairModule getAffairModuleById(Integer id) {
		// TODO Auto-generated method stub
		return affairModuleMapper.getAffairModuleById(id);
	}

	@Override
	public void deleteModule(Integer id) {
		// TODO Auto-generated method stub
		affairModuleMapper.deleteModule(id);
	}

	@Transactional
	@Override
	public void doEdit(Integer id, AffairModule module, String[] partName, Integer[] partType, String[] partData,
			Integer[] chainIds) {
		// TODO Auto-generated method stub
		module.setModuleId(id);
		affairModuleMapper.doEdit(module);
		// 添加组件
		affairRelModulePartMapper.deletePartsById(id);

		List<AffairRelModulePart> moduleParts = new ArrayList<AffairRelModulePart>();
		for (int i = 0; i < partName.length; i++) {
			AffairRelModulePart m = new AffairRelModulePart();
			m.setModuleId(module.getModuleId());
			m.setOrder(i);
			m.setPartId(partType[i]);
			m.setPartName(partName[i]);
			m.setPartData(partData[i]);

			moduleParts.add(m);
		}

		affairRelModulePartMapper.add(moduleParts);

		// 添加审批链
		affairModuleChainMapper.deleteChainById(id);
		
		List<AffairModuleChain> chains = new ArrayList<AffairModuleChain>();
		for (int i = 0; i < chainIds.length; i++) {
			AffairModuleChain chain = new AffairModuleChain();
			chain.setOrder(i + 1);
			chain.setApproverId(chainIds[i]);
			chain.setModuleId(module.getModuleId());
			chains.add(chain);
		}

		affairModuleChainMapper.add(chains);
	}

}
