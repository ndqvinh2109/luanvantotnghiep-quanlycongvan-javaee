package com.quangvinh.dao;

import java.util.List;

import com.quangvinh.model.QuyTrinh;


public interface IQuyTrinhDAO {
	void saveQuyTrinh(QuyTrinh quyTrinh);
	void deleteQuyTrinh(int id);
	void updateQuyTrinh(QuyTrinh quyTrinh);
	List<QuyTrinh> getQuyTrinh();
	QuyTrinh findQuyTrinhID(int id);
}
