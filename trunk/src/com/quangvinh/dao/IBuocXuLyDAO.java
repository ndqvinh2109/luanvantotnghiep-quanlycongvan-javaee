package com.quangvinh.dao;

import java.util.Date;
import java.util.List;

import com.quangvinh.model.Buoc;
import com.quangvinh.model.BuocXuLyPheDuyetVanBan;

public interface IBuocXuLyDAO {
	void saveBuocXuLy(BuocXuLyPheDuyetVanBan buocXuLyPheDuyetVanBan);
	void updateBuocXuLy(BuocXuLyPheDuyetVanBan buocXuLyPheDuyetVanBan);
	void deleteBuocXuLy(int id);
	List<BuocXuLyPheDuyetVanBan> getBuocXuLyPheDuyetVanBans();
	List<Buoc> getBuocXuLyPheDuyetTrongQuyTrinh(int MaQuyTrinh);
	List<BuocXuLyPheDuyetVanBan> getBuocXuLyTheoMaNguoiDung(int manguoidung);
	BuocXuLyPheDuyetVanBan getBuocXuLyTheoVbanBuoc(int mavanban,int buoc);
	long countBuocXuLyTheoMaQuyTrinh(int maquytrinh,int mavanban);
	int updateNoiDungAndValueXuLy(int mavanban,int sothutu, String noidungxuly,boolean valueXuLy,Date thoigianxuly);
	int updateNoiDungAndValueChuyen(int mavanban,int sothutu,boolean valueChuyen);
	boolean checkExistVanBanTrongBuocXuLy(int mavanban);
	long countBuocXuLyTheoMaNguoiDung(int manguoidung,boolean valuechuyen, boolean valuexuly);
	List<BuocXuLyPheDuyetVanBan> thongKeTinhHinhXuLy(int manguoidung,Date tungay, Date denngay);
	List<BuocXuLyPheDuyetVanBan> getListBXLDaXuLy(boolean valuechuyen, boolean valuexuly, int mavanban);
}
