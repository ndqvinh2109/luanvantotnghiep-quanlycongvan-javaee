package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.CongViec;

public interface ICongViecService {
	void saveCongViec(CongViec congviec);
	void updateCongViec (CongViec congviec);
	void deleteCongViec (int id);
	List<CongViec> getCongViec();
	CongViec findCongViecID(int id);
}
