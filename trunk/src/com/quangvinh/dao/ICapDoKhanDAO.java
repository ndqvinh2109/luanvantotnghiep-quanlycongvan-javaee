package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.CapDoKhan;



public interface ICapDoKhanDAO {
	CapDoKhan saveCapDoKhan (CapDoKhan capDoKhan);
	void deleteCapDoKhan(int id);
	CapDoKhan updateCapDoKhan(CapDoKhan capDoKhan);
	List<CapDoKhan> getCapDoKhan();
	CapDoKhan findCapDoKhanID(int id);
}
