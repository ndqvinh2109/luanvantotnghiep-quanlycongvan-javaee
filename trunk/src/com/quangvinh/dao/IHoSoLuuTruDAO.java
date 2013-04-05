package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.HoSoLuuTru;

public interface IHoSoLuuTruDAO {
	HoSoLuuTru saveHoSoLuuTru(HoSoLuuTru hosoluutru);
	HoSoLuuTru updateHoSoLuuTru(HoSoLuuTru hosoluutru);
	void deleteHoSoLuuTru(int id);
	List<HoSoLuuTru> getHoSoLuuTru();
	HoSoLuuTru findHoSoLuuTruID(int id);
}
