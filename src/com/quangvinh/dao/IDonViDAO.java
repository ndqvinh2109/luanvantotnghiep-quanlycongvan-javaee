package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.DonVi;



public interface IDonViDAO {
	DonVi saveDonVi(DonVi donVi);
	void deleteDonVi(int id);
	DonVi updateDonVi(DonVi donVi);
	List<DonVi> getDonVi();
	DonVi findDonViID(int id);
	List<DonVi> getDonViDocLap(int val);
	int insertDonViVanBan(int mavanban,int madonvi);
	List<DonVi> getDonViTheoMaDonViPhuThuoc(int madonvi);
	
}
