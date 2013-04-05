package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IQuyTrinhDAO;
import com.quangvinh.model.QuyTrinh;

@Service
public class QuyTrinhService implements IQuyTrinhService{

	@Autowired
	private IQuyTrinhDAO quytrinhDao;
	
	@Override
	@Transactional
	public void saveQuyTrinh(QuyTrinh quyTrinh) {
		quytrinhDao.saveQuyTrinh(quyTrinh);
		
	}

	@Override
	@Transactional
	public void deleteQuyTrinh(int id) {
		quytrinhDao.deleteQuyTrinh(id);
		
	}

	@Override
	@Transactional
	public void updateQuyTrinh(QuyTrinh quyTrinh) {
		quytrinhDao.updateQuyTrinh(quyTrinh);
		
	}

	@Override
	@Transactional
	public List<QuyTrinh> getQuyTrinh() {
		
		return quytrinhDao.getQuyTrinh();
	}

	@Override
	@Transactional
	public QuyTrinh findQuyTrinhID(int id) {
		
		return quytrinhDao.findQuyTrinhID(id);
	}

}
