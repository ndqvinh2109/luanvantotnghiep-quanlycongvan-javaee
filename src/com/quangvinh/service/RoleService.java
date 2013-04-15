package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IRolesDAO;
import com.quangvinh.model.NguoiDung_Roles;
import com.quangvinh.model.Roles;

@Service
public class RoleService implements IRoleService{

	@Autowired
	private IRolesDAO rolesDao;
	
	@Override
	@Transactional
	public void saveRoles(Roles roles) {
		rolesDao.saveRoles(roles);
	}

	@Override
	@Transactional
	public void updateRoles(Roles roles) {
		rolesDao.updateRoles(roles);
	}

	@Override
	@Transactional
	public void deleteRoles(int id) {
		rolesDao.deleteRoles(id);
		
	}

	@Override
	@Transactional
	public List<Roles> getRoles() {
		
		return rolesDao.getRoles();
	}

	@Override
	@Transactional
	public Roles findRoleID(int id) {
		
		return rolesDao.findRoleID(id);
	}

	@Override
	@Transactional
	public List<NguoiDung_Roles> getRolesListTheoNguoiDung(int manguoidung) {
		
		return rolesDao.getRolesListTheoNguoiDung(manguoidung);
	}

}
