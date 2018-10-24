package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.MenuMapper;
import com.bwf.entity.Menu;
import com.bwf.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {
	@Autowired
	MenuMapper menuMapper;

	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return menuMapper.getAllMenu();
	}
}
