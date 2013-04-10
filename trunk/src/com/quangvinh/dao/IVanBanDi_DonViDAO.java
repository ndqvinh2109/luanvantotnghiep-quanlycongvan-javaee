package com.quangvinh.dao;

import com.quangvinh.model.VanBanDi_DonVi;

public interface IVanBanDi_DonViDAO {
	
	void saveVanBanDi_DonVi(VanBanDi_DonVi vanbandi_donvi);
	boolean checkBanHanhYet(int mavanban);
}
