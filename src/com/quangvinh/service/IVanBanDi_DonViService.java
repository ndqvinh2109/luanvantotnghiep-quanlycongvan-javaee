package com.quangvinh.service;

import com.quangvinh.model.VanBanDi_DonVi;

public interface IVanBanDi_DonViService {
	void saveVanBanDi_DonVi(VanBanDi_DonVi vanbandi_donvi);
	boolean checkBanHanhYet(int mavanban);
}
