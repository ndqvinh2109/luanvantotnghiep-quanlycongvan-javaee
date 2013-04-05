package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.ILinhVucDAO;
import com.quangvinh.model.LinhVuc;
/**
 * LinhVucService class
 * @author QuangVinhPc
 *
 */
@Service
public class LinhVucService implements ILinhVucService{

	@Autowired
	private ILinhVucDAO linhvucDao;
	
	@Override
	@Transactional
	public LinhVuc saveLinhVuc(LinhVuc linhvuc) {
		
		return linhvucDao.saveLinhVuc(linhvuc);
	}

	@Override
	@Transactional
	public void deleteLinhVuc(int id) {
		
		linhvucDao.deleteLinhVuc(id);
	}

	@Override
	@Transactional
	public LinhVuc updateLinhVuc(LinhVuc linhvuc) {
	
		return linhvucDao.updateLinhVuc(linhvuc);
	}

	@Override
	@Transactional
	public List<LinhVuc> getLinhVuc() {
		
		return linhvucDao.getLinhVuc();
	}

	@Override
	@Transactional
	public LinhVuc findLinhVucID(int id) {
		
		return linhvucDao.findLinhVucID(id);
	}

}
