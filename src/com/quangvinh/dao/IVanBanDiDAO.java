package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.VanBanDi;

public interface IVanBanDiDAO {
	void saveVanBanDi(VanBanDi vanbandi);
	void deleteVanBanDi(int id);
	void updateVanBanDi(VanBanDi vanbandi);
	List<VanBanDi> getVanBanDi();
	int getMaxSoDi();
	VanBanDi findVanBanDiID(int id);
	
}
