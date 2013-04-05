package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.CongViec;

public interface ICongViecDAO {
	void saveCongViec(CongViec congviec);
	void updateCongViec (CongViec congviec);
	void deleteCongViec (int id);
	List<CongViec> getCongViec();
	CongViec findCongViecID(int id);
}
