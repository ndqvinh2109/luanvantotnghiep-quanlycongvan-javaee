package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.ILoaiVanBanDAO;
import com.quangvinh.model.LoaiVanBan;
@Service
public class LoaiVanBanService implements ILoaiVanBanService{

	@Autowired
	private ILoaiVanBanDAO loaivanbanDao;
	@Override
	@Transactional
	public LoaiVanBan saveLoaiVanBan(LoaiVanBan loaivanban) {
		
		return loaivanbanDao.saveLoaiVanBan(loaivanban);
	}

	@Override
	@Transactional
	public void deleteLoaiVanBan(int id) {
		
		loaivanbanDao.deleteLoaiVanBan(id);
	}

	@Override
	@Transactional
	public LoaiVanBan updateLoaiVanBan(LoaiVanBan loaivanban) {
		
		return loaivanbanDao.updateLoaiVanBan(loaivanban);
	}

	@Override
	@Transactional
	public List<LoaiVanBan> getLoaiVanBan() {
		
		return loaivanbanDao.getLoaiVanBan();
	}

	@Override
	@Transactional
	public LoaiVanBan findLoaiVanBanID(int id) {
	
		return loaivanbanDao.findLoaiVanBanID(id);
	}

}
