package com.bwf.service;

import com.bwf.entity.AffairChain;
import com.bwf.entity.User;

public interface IAffairChainService {

	void propose(AffairChain affairChain);

	void generateChain(Integer affairId,User user, Integer moduleId);

}
