package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.model.CapDoBaoMat;
import com.quangvinh.dao.ICapDoBaoMatDAO;
@Service
public class CapDoBaoMatService implements ICapDoBaoMatService{

	@Autowired
	private ICapDoBaoMatDAO capdobaomatDao;
	@Override
	@Transactional
	public CapDoBaoMat saveCapDoBaoMat(CapDoBaoMat capDoBaoMat) {
		
		return capdobaomatDao.saveCapDoBaoMat(capDoBaoMat);
	}

	@Override
	@Transactional
	public void deleteCapDoBaoMat(int id) {
		
		capdobaomatDao.deleteCapDoBaoMat(id);
	}

	@Override
	@Transactional
	public CapDoBaoMat updateCapDoBaoMat(CapDoBaoMat capDoBaoMat) {
		
		return capdobaomatDao.updateCapDoBaoMat(capDoBaoMat);
	}

	@Override
	@Transactional
	public List<CapDoBaoMat> getCapDoBaoMat() {
		
		return capdobaomatDao.getCapDoBaoMat();
	}

	@Override
	@Transactional
	public CapDoBaoMat findCapDoBaoMatID(int id) {
		
		return capdobaomatDao.findCapDoBaoMatID(id);
	}
	
	
	

}
