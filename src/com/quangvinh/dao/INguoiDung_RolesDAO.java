package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.NguoiDung_Roles;



public interface INguoiDung_RolesDAO {
	void saveNguoiDungRoles(NguoiDung_Roles nguoiDungRoles);
	void deleteNguoiDungRoles(int id);
	void updateNguoiDungRoles(NguoiDung_Roles nguoiDungRoles);
	List<NguoiDung_Roles> getNguoiDungRoles();
	NguoiDung_Roles findNguoiDungRolesID(int id);
	List<NguoiDung_Roles> checkExistNguoiDungRoles(int manguoidung, int marole);
	void deleteNguoiDungRoles2(int manguoidung,int marole);
}
