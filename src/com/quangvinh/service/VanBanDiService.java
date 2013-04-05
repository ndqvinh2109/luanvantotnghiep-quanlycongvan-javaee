package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IVanBanDiDAO;
import com.quangvinh.model.VanBanDi;
@Service
public class VanBanDiService implements IVanBanDiService{

	@Autowired
	private IVanBanDiDAO vanbandiDao;
	
	@Override
	@Transactional
	public void saveVanBanDi(VanBanDi vanbandi) {
		vanbandiDao.saveVanBanDi(vanbandi);
		
	}

	@Override
	@Transactional
	public void deleteVanBanDi(int id) {
		vanbandiDao.deleteVanBanDi(id);
		
		
	}

	@Override
	@Transactional
	public void updateVanBanDi(VanBanDi vanbandi) {
		vanbandiDao.updateVanBanDi(vanbandi);
		
	}

	@Override
	@Transactional
	public List<VanBanDi> getVanBanDi() {
		
		return vanbandiDao.getVanBanDi();
	}

	@Override
	@Transactional
	public int getMaxSoDi() {
		
		return vanbandiDao.getMaxSoDi();
	}

	@Override
	@Transactional
	public VanBanDi findVanBanDiID(int id) {
		
		return vanbandiDao.findVanBanDiID(id);
	}

}
