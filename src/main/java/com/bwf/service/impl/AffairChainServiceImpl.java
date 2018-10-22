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
