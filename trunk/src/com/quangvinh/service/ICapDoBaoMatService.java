package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.CapDoBaoMat;

public interface ICapDoBaoMatService {
	CapDoBaoMat saveCapDoBaoMat(CapDoBaoMat capDoBaoMat);
	void deleteCapDoBaoMat(int id);
	CapDoBaoMat updateCapDoBaoMat(CapDoBaoMat capDoBaoMat);
	List<CapDoBaoMat> getCapDoBaoMat();
	CapDoBaoMat findCapDoBaoMatID(int id);
}
