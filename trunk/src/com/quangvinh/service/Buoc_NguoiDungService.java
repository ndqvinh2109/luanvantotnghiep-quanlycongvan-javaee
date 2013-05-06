package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IBuoc_NguoiDungDAO;
import com.quangvinh.model.Buoc_NguoiDung;

@Service
public class Buoc_NguoiDungService implements IBuoc_NguoiDungService{

	@Autowired
	private IBuoc_NguoiDungDAO buocndDao;
	
	@Override
	@Transactional
	public void saveBuocNguoiDung(Buoc_NguoiDung buocnd) {
		buocndDao.saveBuocNguoiDung(buocnd);
		
	}

	@Override
	@Transactional
	public void deleteBuocNguoiDung(int mabuocnd) {
		buocndDao.deleteBuocNguoiDung(mabuocnd);
		
	}

	@Override
	@Transactional
	public void updateBuocNguoiDung(Buoc_NguoiDung buocnd) {
	
		buocndDao.updateBuocNguoiDung(buocnd);
	}

	@Override
	@Transactional
	public List<Buoc_NguoiDung> getBuocNguoiDung() {
		
		return buocndDao.getBuocNguoiDung();
	}

	@Override
	@Transactional
	public List<Buoc_NguoiDung> getBuocndQuyTrinh(int maquytrinh) {
		
		return buocndDao.getBuocndQuyTrinh(maquytrinh);
	}

}
