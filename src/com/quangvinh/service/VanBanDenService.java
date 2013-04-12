package com.quangvinh.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IVanBanDenDAO;
import com.quangvinh.model.DonVi;
import com.quangvinh.model.VanBanDen;

@Service
public class VanBanDenService implements IVanBanDenService{
	
	@Autowired
	private IVanBanDenDAO vanbandenDao;
	
	/**
	 * Create VanBanDen
	 * @param VanBanDen
	 * @return void
	 */
	@Override
	@Transactional
	public void saveVanBanDen(VanBanDen vanbanden) {
		vanbandenDao.saveVanBanDen(vanbanden);
	}

	@Override
	@Transactional
	public void deleteVanBanDen(int id) {
		vanbandenDao.deleteVanBanDen(id);
		
	}

	@Override
	@Transactional
	public void updateVanBanDen(VanBanDen vanbanden) {
		vanbandenDao.updateVanBanDen(vanbanden);
		
	}

	@Override
	@Transactional	
	public List<VanBanDen> getVanBanDen() {
		
		return vanbandenDao.getVanBanDen();
	}

	@Override
	@Transactional
	public int getMaxSoDen() {
		
		return vanbandenDao.getMaxSoDen();
	}

	@Override
	@Transactional
	public int findQuyTrinh(int maVanBan) {
		
		return vanbandenDao.findQuyTrinh(maVanBan);
	}

	@Override
	@Transactional
	public VanBanDen findVanBanDenID(int id) {
		
		return vanbandenDao.findVanBanDenID(id);
	}

	@Override
	@Transactional
	public List<VanBanDen> getVanBanDenChuaTiepNhan() {
		
		return vanbandenDao.getVanBanDenChuaTiepNhan();
	}

	@Override
	@Transactional
	public DonVi findDonViTheoMaVanBan(int mavanban) {
		
		return vanbandenDao.findDonViTheoMaVanBan(mavanban);
	}

	@Override
	@Transactional
	public int capNhatSoDenNgayDen(int mavanban, int soden, Date ngayden) {
		
		return vanbandenDao.capNhatSoDenNgayDen(mavanban, soden, ngayden);
	}

	@Override
	@Transactional
	public List<VanBanDen> timKiemNangCaoVanBanDen(String trichyeu,
			Date ngayden, int soden, String sokyhieu, int coquanbanhanh,
			int loaivanban, int linhvuc, int sohoso) {
		
		return vanbandenDao.timKiemNangCaoVanBanDen(trichyeu, ngayden, soden, sokyhieu, coquanbanhanh, loaivanban, linhvuc, sohoso);
	}

	@Override
	@Transactional
	public List<VanBanDen> timKiemCoBanVanBanDen(String textInput) {
		
		return vanbandenDao.timKiemCoBanVanBanDen(textInput);
	}

	@Override
	@Transactional
	public List<VanBanDen> getVanBanDenTheoTrangThai(int trangthai) {
		
		return vanbandenDao.getVanBanDenTheoTrangThai(trangthai);
	}

	@Override
	@Transactional
	public List<VanBanDen> getVanBanDenPaging(int page) {
	
		return vanbandenDao.getVanBanDenPaging(page);
	}

	@Override
	@Transactional
	public boolean checkExistVanBanDen(String sokyhieuvanban) {
		
		return vanbandenDao.checkExistVanBanDen(sokyhieuvanban);
	}

}
