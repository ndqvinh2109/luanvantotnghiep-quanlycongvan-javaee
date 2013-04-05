package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.ICongViecDAO;
import com.quangvinh.model.CongViec;

@Service
public class CongViecService implements ICongViecService {
	
	@Autowired
	private ICongViecDAO congviecDao;
	
	@Override
	@Transactional
	public void saveCongViec(CongViec congviec) {
		
		congviecDao.saveCongViec(congviec);
		
	}

	@Override
	@Transactional
	public void updateCongViec(CongViec congviec) {
		
		congviecDao.updateCongViec(congviec);
	}

	@Override
	@Transactional
	public void deleteCongViec(int id) {
		congviecDao.deleteCongViec(id);
		
	}

	@Override
	@Transactional
	public List<CongViec> getCongViec() {
		
		return congviecDao.getCongViec();
	}

	@Override
	@Transactional
	public CongViec findCongViecID(int id) {
		
		return congviecDao.findCongViecID(id);
	}

}
