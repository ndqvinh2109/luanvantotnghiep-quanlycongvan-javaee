package com.quangvinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quangvinh.dao.IViTriLuuTruDAO;
import com.quangvinh.model.ViTriLuuTru;
/**
 * ViTriLuuTruService class
 * @author QuangVinhPc
 *
 */
@Service
public class ViTriLuuTruService implements IViTriLuuTruService{
	
	@Autowired
	private IViTriLuuTruDAO vitriluutrudao;

	@Override
	@Transactional
	public ViTriLuuTru saveViTriLuuTru(ViTriLuuTru vitriluutru) {
		
		return vitriluutrudao.saveViTriLuuTru(vitriluutru);
	}

	@Override
	@Transactional
	public void deleteViTriLuuTru(int id) {
		
		vitriluutrudao.deleteViTriLuuTru(id);
	}

	@Override
	@Transactional
	public ViTriLuuTru updateViTriLuuTru(ViTriLuuTru vitriluutru) {
		
		return vitriluutrudao.updateViTriLuuTru(vitriluutru);
	}

	@Override
	@Transactional
	public List<ViTriLuuTru> getViTriLuuTru() {
		
		return vitriluutrudao.getViTriLuuTru();
	}

	@Override
	@Transactional
	public ViTriLuuTru findViTriLuuTruID(int id) {
		// TODO Auto-generated method stub
		return vitriluutrudao.findViTriLuuTruID(id);
	}
	
}
