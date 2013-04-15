package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.NguoiDung_Roles;
import com.quangvinh.model.Roles;

public interface IRolesDAO {
	void saveRoles(Roles roles);
	void updateRoles(Roles roles);
	void deleteRoles(int id);
	List<Roles> getRoles();
	Roles findRoleID(int id);
	List<NguoiDung_Roles> getRolesListTheoNguoiDung(int manguoidung);
}
