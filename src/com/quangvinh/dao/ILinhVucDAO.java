package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.LinhVuc;



public interface ILinhVucDAO {
	LinhVuc saveLinhVuc(LinhVuc linhvuc);
	void deleteLinhVuc(int id);
	LinhVuc updateLinhVuc(LinhVuc linhvuc);
	List<LinhVuc> getLinhVuc();
	LinhVuc findLinhVucID(int id);
}
