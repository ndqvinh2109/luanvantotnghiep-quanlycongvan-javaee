package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.VanBan;

public interface IVanBanService {
	void saveVanBan(VanBan vanban);
	void deleteVanBan(int id);
	void updateVanBan(VanBan vanban);
	List<VanBan> getVanBan();
	VanBan findVanBanID(int id);
	int updateTrangThaiXuLy(int trangthai,int mavanban);
	int getMaVanBanTheoSoKyHieu(String sovakyhieu);
	int capNhatBooleanTiepNhan(boolean var,int mavanban);
	int capNhatBooleanBanHanh(boolean var,int mavanban);
	
}
