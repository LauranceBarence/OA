<<<<<<< HEAD
package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.AffairChainMapper;
import com.bwf.entity.AffairChain;
import com.bwf.service.IAffairChainService;

@Service
public class AffairChainServiceImpl implements IAffairChainService {
	@Autowired
	AffairChainMapper affairChainMapper;

	@Override
	public void propose(AffairChain affairChain) {
		// TODO Auto-generated method stub
		affairChainMapper.propose(affairChain);
	}
	
	
}
=======
package com.bwf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.AffairChainMapper;
import com.bwf.dao.AffairModuleChainMapper;
import com.bwf.entity.AffairChain;
import com.bwf.entity.AffairModuleChain;
import com.bwf.entity.User;
import com.bwf.service.IAffairChainService;

@Service
public class AffairChainServiceImpl implements IAffairChainService {
	@Autowired
	AffairChainMapper affairChainMapper;
	
	@Autowired
	AffairModuleChainMapper affairModuleChainMapper;
	
	@Override
	public void propose(AffairChain affairChain) {
		// TODO Auto-generated method stub
		affairChainMapper.propose(affairChain);
	}

	@Override
	public void generateChain(Integer affairId,User user ,Integer moduleId) {
		// TODO Auto-generated method stub
		List<AffairModuleChain> affairModuleChain = affairModuleChainMapper.getAffairModuleChainsByAffairModuleId(moduleId);
		List<AffairChain> affairChain = new ArrayList<AffairChain>();
		for(int i=1;i<=affairModuleChain.size();i++){
			AffairChain chain = new AffairChain();
			chain.setAffairChainOrder(i);
			chain.setAffairChainStatus(1);
			if(affairModuleChain.get(i).getApproverId()==-1){
				chain.setApproverId(user.getLeaderId());
			}else{
				chain.setApproverId(affairModuleChain.get(i).getApproverId());
			}
			chain.setAffairId(affairId);
			affairChain.add(chain);
		}
		affairChainMapper.add(affairChain);
	}
	
	
}
>>>>>>> bqr
