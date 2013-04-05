package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.ViTriLuuTru;

public interface IViTriLuuTruService {
	ViTriLuuTru saveViTriLuuTru(ViTriLuuTru vitriluutru);
	void deleteViTriLuuTru(int id);
	ViTriLuuTru updateViTriLuuTru(ViTriLuuTru vitriluutru);
	List<ViTriLuuTru> getViTriLuuTru();
	ViTriLuuTru findViTriLuuTruID(int id);
}
