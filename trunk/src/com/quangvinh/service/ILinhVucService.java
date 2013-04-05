package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.LinhVuc;

public interface ILinhVucService {
	LinhVuc saveLinhVuc(LinhVuc linhvuc);
	void deleteLinhVuc(int id);
	LinhVuc updateLinhVuc(LinhVuc linhvuc);
	List<LinhVuc> getLinhVuc();
	LinhVuc findLinhVucID(int id);
}
