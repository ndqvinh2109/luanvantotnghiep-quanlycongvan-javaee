package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.CapDoKhan;

public interface ICapDoKhanService {
	CapDoKhan saveCapDoKhan(CapDoKhan capDoKhan);
	void deleteCapDoKhan(int id);
	CapDoKhan updateCapDoKhan(CapDoKhan capDoKhan);
	List<CapDoKhan> getCapDoKhan();
	CapDoKhan findCapDoKhanID(int id);
}
