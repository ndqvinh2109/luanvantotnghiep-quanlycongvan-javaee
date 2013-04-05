package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IFileDinhKemDAO;
import com.quangvinh.model.FileDinhKem;

@Service
public class FileDinhKemService implements IFileDinhKemService{

	@Autowired
	private IFileDinhKemDAO filedinhkemDao;
	
	@Override
	@Transactional
	public void addFileDinhKem(FileDinhKem fileDinhKem) {
		filedinhkemDao.addFileDinhKem(fileDinhKem);
		
	}

	@Override
	@Transactional
	public List<FileDinhKem> getFileDinhKem() {
		
		return filedinhkemDao.getFileDinhKem();
	}

	@Override
	@Transactional
	public FileDinhKem get(int id) {
		
		return filedinhkemDao.get(id);
	}

	@Override
	@Transactional
	public void deleteFileDinhKem(int id) {
		
		filedinhkemDao.deleteFileDinhKem(id);
	}

	@Override
	@Transactional
	public List<FileDinhKem> getFileDinhKemVanBan(int mavanban) {
		
		return filedinhkemDao.getFileDinhKemVanBan(mavanban);
	}

}
