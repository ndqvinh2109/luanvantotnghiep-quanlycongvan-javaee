package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.NguoiDung;
import com.quangvinh.model.Roles;

public interface INguoiDungService {

	void saveNguoiDung(NguoiDung nguoiDung);
	void deleteNguoiDung(int id);
	void updateNguoiDung(NguoiDung nguoiDung);
	List<NguoiDung> getNguoiDung();
	NguoiDung findNguoiDungID(int id);
	public NguoiDung getNguoiDungByUserName(String userName);
	List<Roles> getRolesByUserName(String userName);
	int getMaNguoiDungTheoUsername(String userName);
	int getMaDonViTheoMaNguoiDung(int manguoidung);
	String getTenNguoiDungTheoUsername(String userName);
	List<NguoiDung> getNguoiDungTheoMaDonVi(int madonvi);
}
