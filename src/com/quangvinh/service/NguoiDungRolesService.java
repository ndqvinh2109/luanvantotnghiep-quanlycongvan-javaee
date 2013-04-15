package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.INguoiDung_RolesDAO;
import com.quangvinh.model.NguoiDung_Roles;

@Service
public class NguoiDungRolesService implements INguoiDungRolesService{

	@Autowired
	private INguoiDung_RolesDAO nguoidungroleDAO;
	
	@Override
	@Transactional
	public void saveNguoiDungRoles(NguoiDung_Roles nguoiDungRoles) {
		nguoidungroleDAO.saveNguoiDungRoles(nguoiDungRoles);
		
	}

	@Override
	@Transactional
	public void deleteNguoiDungRoles(int id) {
		
		nguoidungroleDAO.deleteNguoiDungRoles(id);
	}

	@Override
	@Transactional
	public void updateNguoiDungRoles(NguoiDung_Roles nguoiDungRoles) {
		
		nguoidungroleDAO.updateNguoiDungRoles(nguoiDungRoles);
	}

	@Override
	@Transactional
	public List<NguoiDung_Roles> getNguoiDungRoles() {
		
		return nguoidungroleDAO.getNguoiDungRoles();
	}

	@Override
	@Transactional
	public NguoiDung_Roles findNguoiDungRolesID(int id) {
		
		return nguoidungroleDAO.findNguoiDungRolesID(id);
	}

	@Override
	@Transactional
	public List<NguoiDung_Roles> checkExistNguoiDungRoles(int manguoidung,
			int marole) {
		
		return nguoidungroleDAO.checkExistNguoiDungRoles(manguoidung, marole);
	}

	@Override
	@Transactional
	public void deleteNguoiDungRoles2(int manguoidung, int marole) {
		nguoidungroleDAO.deleteNguoiDungRoles2(manguoidung, marole);
		
	}

}
