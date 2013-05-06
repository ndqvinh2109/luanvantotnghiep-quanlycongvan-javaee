package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.Buoc_NguoiDung;

public interface IBuoc_NguoiDungDAO {
	void saveBuocNguoiDung(Buoc_NguoiDung buocnd);
	void deleteBuocNguoiDung(int mabuocnd);
	void updateBuocNguoiDung(Buoc_NguoiDung buocnd);
	List<Buoc_NguoiDung> getBuocNguoiDung();
	List<Buoc_NguoiDung> getBuocndQuyTrinh(int maquytrinh);
}
