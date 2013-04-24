package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.VanBan;


public interface IVanBanDAO {
	void saveVanBan(VanBan vanban);
	void deleteVanBan(int id);
	void updateVanBan(VanBan vanban);
	List<VanBan> getVanBan();
	VanBan findVanBanID(int id);
	int updateTrangThaiXuLy(int trangthai,int mavanban);
	int getMaVanBanTheoSoKyHieu(String sovakyhieu);
	int capNhatBooleanTiepNhan(boolean var,int mavanban);
	int capNhatBooleanBanHanh(boolean var,int mavanban);
	boolean checkExistKyHieuVanBan(String kyhieuvanban);
}
