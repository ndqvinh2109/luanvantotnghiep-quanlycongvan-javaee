package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.VanBanDi_DonVi;

public interface IVanBanDi_DonViDAO {
	
	void saveVanBanDi_DonVi(VanBanDi_DonVi vanbandi_donvi);
	boolean checkBanHanhYet(int mavanban);
	List<VanBanDi_DonVi> getListVBDVDaBH(int mavanban);
	
}
