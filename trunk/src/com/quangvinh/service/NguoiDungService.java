package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.INguoiDungDAO;
import com.quangvinh.model.NguoiDung;
import com.quangvinh.model.Roles;

@Service
public class NguoiDungService implements INguoiDungService{

	@Autowired
	private INguoiDungDAO nguoidungDao;
	
	@Override
	@Transactional
	public void saveNguoiDung(NguoiDung nguoiDung) {
		nguoidungDao.saveNguoiDung(nguoiDung);
		
	}

	@Override
	@Transactional
	public void deleteNguoiDung(int id) {
		nguoidungDao.deleteNguoiDung(id);
		
	}

	@Override
	@Transactional
	public void updateNguoiDung(NguoiDung nguoiDung) {
		nguoidungDao.updateNguoiDung(nguoiDung);
		
	}

	@Override
	@Transactional
	public List<NguoiDung> getNguoiDung() {
		
		return nguoidungDao.getNguoiDung();
	}

	@Override
	@Transactional
	public NguoiDung findNguoiDungID(int id) {
		
		return nguoidungDao.findNguoiDungID(id);
	}

	@Override
	@Transactional
	public NguoiDung getNguoiDungByUserName(String userName) {
		
		return nguoidungDao.getNguoiDungByUserName(userName);
	}

	@Override
	@Transactional
	public List<Roles> getRolesByUserName(String userName) {
		
		return nguoidungDao.getRolesByUserName(userName);
	}

	@Override
	@Transactional
	public int getMaNguoiDungTheoUsername(String userName) {
		
		return nguoidungDao.getMaNguoiDungTheoUsername(userName);
	}

	@Override
	@Transactional
	public int getMaDonViTheoMaNguoiDung(int manguoidung) {
	
		return nguoidungDao.getMaDonViTheoMaNguoiDung(manguoidung);
	}

	@Override
	@Transactional
	public String getTenNguoiDungTheoUsername(String userName) {
		
		return nguoidungDao.getTenNguoiDungTheoUsername(userName);
	}

	@Override
	@Transactional
	public List<NguoiDung> getNguoiDungTheoMaDonVi(int madonvi) {
		
		return nguoidungDao.getNguoiDungTheoMaDonVi(madonvi);
	}

}
