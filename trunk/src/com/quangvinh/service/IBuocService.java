package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.Buoc;

public interface IBuocService {
	void saveBuoc(Buoc buoc);
	void deleteBuoc(int id);
	void updateBuoc(Buoc buoc);
	List<Buoc> getBuoc();
	Buoc findBuocID(int maquytrinh,int sothutu);
	int getMaxId(int maquytrinh);
}
