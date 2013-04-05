package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.QuyTrinh;

public interface IQuyTrinhService {
	void saveQuyTrinh(QuyTrinh quyTrinh);
	void deleteQuyTrinh(int id);
	void updateQuyTrinh(QuyTrinh quyTrinh);
	List<QuyTrinh> getQuyTrinh();
	QuyTrinh findQuyTrinhID(int id);
}
