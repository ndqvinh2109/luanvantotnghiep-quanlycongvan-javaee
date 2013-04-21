package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IDonViDAO;
import com.quangvinh.model.DonVi;

@Service
public class DonViService implements IDonViService{
	
	@Autowired
	private IDonViDAO donviDao;
	
	@Override
	@Transactional
	public DonVi saveDonVi(DonVi donVi) {
		
		return donviDao.saveDonVi(donVi);
	}

	@Override
	@Transactional
	public void deleteDonVi(int id) {
		donviDao.deleteDonVi(id);
		
	}

	@Override
	@Transactional
	public DonVi updateDonVi(DonVi donVi) {
		
		return donviDao.updateDonVi(donVi);
	}

	@Override
	@Transactional
	public List<DonVi> getDonVi() {
		
		return donviDao.getDonVi();
	}

	@Override
	@Transactional
	public DonVi findDonViID(int id) {
		
		return donviDao.findDonViID(id);	
		
	}

	@Override
	@Transactional
	public List<DonVi> getDonViDocLap(int val) {
		return donviDao.getDonViDocLap(val);
	}

	@Override
	@Transactional
	public List<DonVi> getDonViTheoMaDonViPhuThuoc(int madonvi) {
		
		return donviDao.getDonViTheoMaDonViPhuThuoc(madonvi);
	}

	

}
