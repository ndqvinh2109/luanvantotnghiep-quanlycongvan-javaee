package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.VanBanDi;

public interface IVanBanDiService {
	void saveVanBanDi(VanBanDi vanbandi);
	void deleteVanBanDi(int id);
	void updateVanBanDi(VanBanDi vanbandi);
	List<VanBanDi> getVanBanDi();
	int getMaxSoDi();
	VanBanDi findVanBanDiID(int id);
	List<VanBanDi> getVanBanDiPaging(int page);
}
