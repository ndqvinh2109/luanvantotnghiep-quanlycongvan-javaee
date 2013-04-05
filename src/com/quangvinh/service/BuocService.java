package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IBuocDAO;
import com.quangvinh.model.Buoc;

@Service
public class BuocService implements IBuocService{

	@Autowired
	private IBuocDAO buocDao;
	
	@Override
	@Transactional
	public void saveBuoc(Buoc buoc) {
		buocDao.saveBuoc(buoc);
	
	}

	@Override
	@Transactional
	public void deleteBuoc(int id) {
		
		buocDao.deleteBuoc(id);
	}

	@Override
	@Transactional
	public void updateBuoc(Buoc buoc) {
		buocDao.updateBuoc(buoc);
		
	}

	@Override
	@Transactional
	public List<Buoc> getBuoc() {
		
		return buocDao.getBuoc();
	}

	

	@Override
	@Transactional
	public int getMaxId(int maquytrinh) {
		
		return buocDao.getMaxId(maquytrinh);
	}

	@Override
	@Transactional
	public Buoc findBuocID(int maquytrinh, int sothutu) {
		
		return buocDao.findBuocID(maquytrinh, sothutu);
	}

}
