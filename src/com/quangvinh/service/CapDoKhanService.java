package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.ICapDoKhanDAO;
import com.quangvinh.model.CapDoKhan;

@Service
public class CapDoKhanService implements ICapDoKhanService{
	
	@Autowired
	private ICapDoKhanDAO capdokhanDao;
	@Override
	@Transactional
	public CapDoKhan saveCapDoKhan(CapDoKhan capDoKhan) {
		
		return capdokhanDao.saveCapDoKhan(capDoKhan);
	}

	@Override
	@Transactional
	public void deleteCapDoKhan(int id) {
		
		capdokhanDao.deleteCapDoKhan(id);
	}

	@Override
	@Transactional
	public CapDoKhan updateCapDoKhan(CapDoKhan capDoKhan) {
		
		return capdokhanDao.updateCapDoKhan(capDoKhan);
	}

	@Override
	@Transactional
	public List<CapDoKhan> getCapDoKhan() {
		
		return capdokhanDao.getCapDoKhan();
	}

	@Override
	@Transactional
	public CapDoKhan findCapDoKhanID(int id) {
		
		return capdokhanDao.findCapDoKhanID(id);
	}
	
	
	

	
	
	

}
