package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.FileDinhKem;

public interface IFileDinhKemDAO {
	
	void addFileDinhKem(FileDinhKem fileDinhKem);
	List<FileDinhKem> getFileDinhKem();
	FileDinhKem get(int id);
	void deleteFileDinhKem(int id);
	List<FileDinhKem> getFileDinhKemVanBan(int mavanban);
	List<FileDinhKem> getFileDinhKemTheoSoKyHieu(String sokyhieu);
}
