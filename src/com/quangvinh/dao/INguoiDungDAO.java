package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.NguoiDung;
import com.quangvinh.model.Roles;


public interface INguoiDungDAO {
	void saveNguoiDung(NguoiDung nguoiDung);
	void deleteNguoiDung(int id);
	void updateNguoiDung(NguoiDung nguoiDung);
	List<NguoiDung> getNguoiDung();
	NguoiDung findNguoiDungID(int id);
	public NguoiDung getNguoiDungByUserName(String userName);
	List<Roles> getRolesByUserName(String userName);
	int getMaNguoiDungTheoUsername(String userName);
	String getTenNguoiDungTheoUsername(String userName);
	int getMaDonViTheoMaNguoiDung(int manguoidung);
	List<NguoiDung> getNguoiDungTheoMaDonVi(int madonvi);
}


