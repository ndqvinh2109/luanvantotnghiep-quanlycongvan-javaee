package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.LoaiVanBan;



public interface ILoaiVanBanDAO {
	LoaiVanBan saveLoaiVanBan(LoaiVanBan loaivanban);
	void deleteLoaiVanBan(int id);
	LoaiVanBan updateLoaiVanBan(LoaiVanBan loaivanban);
	List<LoaiVanBan> getLoaiVanBan();
	LoaiVanBan findLoaiVanBanID(int id);
	
}
