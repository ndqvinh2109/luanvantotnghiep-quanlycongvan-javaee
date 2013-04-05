package com.quangvinh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CHUCVU")
public class ChucVu {
	/****************************************/
	@ManyToOne
	@JoinColumn(name="MA_NGUOI_DUNG")
	private NguoiDung nguoidung;
	
	public NguoiDung getNguoidung() {
		return nguoidung;
	}
	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}
	/****************************************/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_CHUC_VU")
	private int maChucVu;
	@Column(name="TEN_CHUC_VU")
	private String tenChucVu;
	
	public ChucVu(){}
	
	public ChucVu(NguoiDung nguoidung, int maChucVu, String tenChucVu) {
		super();
		this.nguoidung = nguoidung;
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}
	
	public int getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}
	
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	
}
