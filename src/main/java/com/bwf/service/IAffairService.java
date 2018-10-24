package com.bwf.service;

import java.util.List;

import com.bwf.entity.Affair;
import com.bwf.entity.User;

public interface IAffairService {

	Affair getAffairDetailByAffairId(Integer id);

	void add(Affair affair, User currentUser);

	List<Affair> getAffairByMe(User currentUser);

	List<Affair> getAffairToBePropose(User currentUser);

}
