package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.HoSoLuuTru;

public interface IHoSoLuuTruService {
	HoSoLuuTru saveHoSoLuuTru(HoSoLuuTru hosoluutru);
	HoSoLuuTru updateHoSoLuuTru(HoSoLuuTru hosoluutru);
	void deleteHoSoLuuTru(int id);
	List<HoSoLuuTru> getHoSoLuuTru();
	HoSoLuuTru findHoSoLuuTruID(int id);
}
