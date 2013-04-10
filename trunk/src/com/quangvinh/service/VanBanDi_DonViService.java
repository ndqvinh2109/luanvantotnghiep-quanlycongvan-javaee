package com.quangvinh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IVanBanDi_DonViDAO;
import com.quangvinh.model.VanBanDi_DonVi;

@Service
public class VanBanDi_DonViService implements IVanBanDi_DonViService{

	@Autowired
	private IVanBanDi_DonViDAO vanbandi_donviDao;
	
	@Override
	@Transactional
	public void saveVanBanDi_DonVi(VanBanDi_DonVi vanbandi_donvi) {
		
		vanbandi_donviDao.saveVanBanDi_DonVi(vanbandi_donvi);
	}

	@Override
	@Transactional
	public boolean checkBanHanhYet(int mavanban) {
		
		return vanbandi_donviDao.checkBanHanhYet(mavanban);
	}

}
