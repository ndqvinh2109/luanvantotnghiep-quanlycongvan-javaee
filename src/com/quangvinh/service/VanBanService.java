package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IVanBanDAO;
import com.quangvinh.model.VanBan;
/**
 * VanBanService class
 * @author QuangVinhPc
 *
 */
@Service

public class VanBanService implements IVanBanService{
	@Autowired
	private IVanBanDAO vanbanDao;
	/**
	 * Create VanBan
	 * @param VanBan
	 * @return void
	 */
	@Override
	@Transactional
	public void saveVanBan(VanBan vanban) {
		
		vanbanDao.saveVanBan(vanban);
	}
	/**
	 * Delete VanBan
	 * @param id
	 * @return void
	 */
	@Override
	@Transactional
	public void deleteVanBan(int id) {
		
		vanbanDao.deleteVanBan(id);
	}
	/**
	 * Update VanBan
	 * @param vanban
	 * @return void
	 */
	@Override
	@Transactional
	public void updateVanBan(VanBan vanban) {
		
		vanbanDao.updateVanBan(vanban);
	}
	/**
	 * Get all VanBan
	 * @return List VanBan
	 */
	@Override
	@Transactional
	public List<VanBan> getVanBan() {
		
		return vanbanDao.getVanBan();
	}
	@Override
	@Transactional
	public VanBan findVanBanID(int id) {
		
		return vanbanDao.findVanBanID(id);
	}
	@Override
	@Transactional
	public int updateTrangThaiXuLy(int trangthai, int mavanban) {
		
		return vanbanDao.updateTrangThaiXuLy(trangthai, mavanban);
	}
	@Override
	@Transactional
	public int getMaVanBanTheoSoKyHieu(String sovakyhieu) {
		
		return vanbanDao.getMaVanBanTheoSoKyHieu(sovakyhieu);
	}
	@Override
	@Transactional
	public int capNhatBooleanTiepNhan(boolean var, int mavanban) {
		
		return vanbanDao.capNhatBooleanTiepNhan(var, mavanban);
	}
	@Override
	@Transactional
	public int capNhatBooleanBanHanh(boolean var, int mavanban) {
		
		return vanbanDao.capNhatBooleanBanHanh(var, mavanban);
	}
	@Override
	@Transactional
	public boolean checkExistKyHieuVanBan(String kyhieuvanban) {
		
		return vanbanDao.checkExistKyHieuVanBan(kyhieuvanban);
	}
	
	
}
