package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.FileDinhKem;

public interface IFileDinhKemService {
	void addFileDinhKem(FileDinhKem fileDinhKem);
	List<FileDinhKem> getFileDinhKem();
	FileDinhKem get(int id);
	void deleteFileDinhKem(int id);
	List<FileDinhKem> getFileDinhKemVanBan(int mavanban);
}
