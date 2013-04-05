package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IHoSoLuuTruDAO;
import com.quangvinh.model.HoSoLuuTru;
@Service
public class HoSoLuuTruService implements IHoSoLuuTruService{
	@Autowired
	private IHoSoLuuTruDAO hosoluutruDao;
	@Override
	@Transactional
	public HoSoLuuTru saveHoSoLuuTru(HoSoLuuTru hosoluutru) {
		
		return hosoluutruDao.saveHoSoLuuTru(hosoluutru);
	}

	@Override
	@Transactional
	public HoSoLuuTru updateHoSoLuuTru(HoSoLuuTru hosoluutru) {
		
		return hosoluutruDao.updateHoSoLuuTru(hosoluutru);
	}

	@Override
	@Transactional
	public void deleteHoSoLuuTru(int id) {
		hosoluutruDao.deleteHoSoLuuTru(id);
		
	}

	@Override
	@Transactional
	public List<HoSoLuuTru> getHoSoLuuTru() {
		
		return hosoluutruDao.getHoSoLuuTru();
	}

	@Override
	@Transactional
	public HoSoLuuTru findHoSoLuuTruID(int id) {
		
		return hosoluutruDao.findHoSoLuuTruID(id);
	}

}
