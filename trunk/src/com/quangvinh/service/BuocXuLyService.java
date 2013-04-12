package com.quangvinh.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IBuocXuLyDAO;
import com.quangvinh.model.Buoc;
import com.quangvinh.model.BuocXuLyPheDuyetVanBan;

@Service
public class BuocXuLyService implements IBuocXuLyService{
	
	@Autowired
	private IBuocXuLyDAO buocxulyDao;
	
	@Override
	@Transactional
	public void saveBuocXuLy(BuocXuLyPheDuyetVanBan buocXuLyPheDuyetVanBan) {
		
		buocxulyDao.saveBuocXuLy(buocXuLyPheDuyetVanBan);
	}

	@Override
	@Transactional
	public void updateBuocXuLy(BuocXuLyPheDuyetVanBan buocXuLyPheDuyetVanBan) {
		buocxulyDao.updateBuocXuLy(buocXuLyPheDuyetVanBan);
		
	}

	@Override
	@Transactional
	public void deleteBuocXuLy(int id) {
		buocxulyDao.deleteBuocXuLy(id);
		
	}

	@Override
	@Transactional
	public List<BuocXuLyPheDuyetVanBan> getBuocXuLyPheDuyetVanBans() {
		
		return buocxulyDao.getBuocXuLyPheDuyetVanBans();
	}

	@Override
	@Transactional
	public List<Buoc> getBuocXuLyPheDuyetTrongQuyTrinh(int MaQuyTrinh) {
		
		return buocxulyDao.getBuocXuLyPheDuyetTrongQuyTrinh(MaQuyTrinh);
	}

	@Override
	@Transactional
	public List<BuocXuLyPheDuyetVanBan> getBuocXuLyTheoMaNguoiDung(
			int manguoidung) {
		
		return buocxulyDao.getBuocXuLyTheoMaNguoiDung(manguoidung);
	}

	@Override
	@Transactional
	public BuocXuLyPheDuyetVanBan getBuocXuLyTheoVbanBuoc(int mavanban,
			int buoc) {
		
		return buocxulyDao.getBuocXuLyTheoVbanBuoc(mavanban, buoc);
	}

	@Override
	@Transactional
	public long countBuocXuLyTheoMaQuyTrinh(int maquytrinh,int mavanban) {
		
		return buocxulyDao.countBuocXuLyTheoMaQuyTrinh(maquytrinh,mavanban);
	}

	@Override
	@Transactional
	public int updateNoiDungAndValueXuLy(int mavanban, int sothutu,
			String noidungxuly, boolean valueXuLy,Date thoigianxuly) {
		
		return buocxulyDao.updateNoiDungAndValueXuLy(mavanban, sothutu, noidungxuly, valueXuLy,thoigianxuly);
	}

	@Override
	@Transactional
	public int updateNoiDungAndValueChuyen(int mavanban, int sothutu,
			boolean valueChuyen) {
		
		return buocxulyDao.updateNoiDungAndValueChuyen(mavanban, sothutu, valueChuyen);
	}

	@Override
	@Transactional
	public boolean checkExistVanBanTrongBuocXuLy(int mavanban) {
		
		return buocxulyDao.checkExistVanBanTrongBuocXuLy(mavanban);
	}

	@Override
	@Transactional
	public long countBuocXuLyTheoMaNguoiDung(int manguoidung,
			boolean valuechuyen, boolean valuexuly) {
		
		return buocxulyDao.countBuocXuLyTheoMaNguoiDung(manguoidung, valuechuyen, valuexuly);
	}

}
