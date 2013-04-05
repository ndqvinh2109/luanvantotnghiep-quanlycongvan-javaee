package com.quangvinh.service;

import java.util.Date;
import java.util.List;

import com.quangvinh.model.DonVi;
import com.quangvinh.model.VanBanDen;

public interface IVanBanDenService {
	void saveVanBanDen(VanBanDen vanbanden);
	void deleteVanBanDen(int id);
	void updateVanBanDen(VanBanDen vanbanden);
	List<VanBanDen> getVanBanDen();
	List<VanBanDen> getVanBanDenChuaTiepNhan();
	int getMaxSoDen();
	int findQuyTrinh(int maVanBan);	
	VanBanDen findVanBanDenID(int id);
	DonVi findDonViTheoMaVanBan(int mavanban);
	int capNhatSoDenNgayDen(int mavanban,int soden, Date ngayden);
	List<VanBanDen> timKiemNangCaoVanBanDen(String trichyeu,Date ngayden,int soden,String sokyhieu,int coquanbanhanh,int loaivanban,int linhvuc,int sohoso);
	List<VanBanDen> timKiemCoBanVanBanDen(String textInput);
}
