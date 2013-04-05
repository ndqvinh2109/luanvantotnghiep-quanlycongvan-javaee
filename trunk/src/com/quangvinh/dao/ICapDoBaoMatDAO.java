package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.CapDoBaoMat;


public interface ICapDoBaoMatDAO {
	CapDoBaoMat saveCapDoBaoMat(CapDoBaoMat capDoBaoMat);
	void deleteCapDoBaoMat(int id);
	CapDoBaoMat updateCapDoBaoMat(CapDoBaoMat capDoBaoMat);
	List<CapDoBaoMat> getCapDoBaoMat();
	CapDoBaoMat findCapDoBaoMatID(int id);
}
