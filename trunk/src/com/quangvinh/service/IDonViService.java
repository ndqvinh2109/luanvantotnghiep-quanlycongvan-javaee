package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.DonVi;

public interface IDonViService {
	DonVi saveDonVi(DonVi donVi);
	void deleteDonVi(int id);
	DonVi updateDonVi(DonVi donVi);
	List<DonVi> getDonVi();
	DonVi findDonViID(int id);
	List<DonVi> getDonViDocLap(int val);
	List<DonVi> getDonViTheoMaDonViPhuThuoc(int madonvi);
}	
