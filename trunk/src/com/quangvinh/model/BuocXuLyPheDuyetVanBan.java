package com.quangvinh.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BUOCXULYPHEDUYETVANBAN")
public class BuocXuLyPheDuyetVanBan {
	
	/*-------------------------------------------------*/
	
	@SuppressWarnings("serial")
	@Embeddable
	public static class Pk_BuocXuLyVanBan implements Serializable{
		
	@Column(name="SO_THU_TU")
	private int soThuTu;
	
	public int getSoThuTu() {
		return soThuTu;
	}
	public void setSoThuTu(int soThuTu) {
		this.soThuTu = soThuTu;
	}
	
	@Column(name="MA_QUY_TRINH")
	private int maQuyTrinh;
	
	public int getMaQuyTrinh() {
		return maQuyTrinh;
	}
	public void setMaQuyTrinh(int maQuyTrinh) {
		this.maQuyTrinh = maQuyTrinh;
	}
	
	@Column(name="MA_VAN_BAN")
	private int maVanBan;
	public int getMaVanBan() {
		return maVanBan;
	}
	public void setMaVanBan(int maVanBan) {
		this.maVanBan = maVanBan;
	}
	
	}
	@EmbeddedId
	Pk_BuocXuLyVanBan pkBuocXuLy = new Pk_BuocXuLyVanBan();
	
	public Pk_BuocXuLyVanBan getPkBuocXuLy() {
		return pkBuocXuLy;
	}
	public void setPkBuocXuLy(Pk_BuocXuLyVanBan pkBuocXuLy) {
		this.pkBuocXuLy = pkBuocXuLy;
	}
	@ManyToOne
	@JoinColumns({@JoinColumn(name="MA_QUY_TRINH",updatable=false,insertable=false),@JoinColumn(name="SO_THU_TU",updatable=false,insertable=false)})
	private Buoc buoc;
	
	public Buoc getBuoc() {
		return buoc;
	}
	public void setBuoc(Buoc buoc) {
		this.buoc = buoc;
	}
	@ManyToOne
	@JoinColumn(name="MA_VAN_BAN",insertable=false,updatable=false)
	private VanBan vanban;
	
	public VanBan getVanban() {
		return vanban;
	}
	public void setVanban(VanBan vanban) {
		this.vanban = vanban;
	}
	@ManyToOne
	@JoinColumn(name="MA_NGUOI_DUNG")
	private NguoiDung nguoidung;
	
	public NguoiDung getNguoidung() {
		return nguoidung;
	}
	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}
	/*-------------------------------------------------------*/
	@Column(name="NOI_DUNG_XU_LY")
	private String noiDungXLPD;
	@Temporal(TemporalType.DATE)
	@Column(name="THOI_GIAN_BD")
	private Date thoiGianBatDau;
	@Temporal(TemporalType.DATE)
	@Column(name="THOI_GIAN_KT")
	private Date thoiGianHoanThanh;
	@Column(name="VALUE_XU_LY",columnDefinition="boolean default false")
	private boolean valueXuLy;
	@Column(name="VALUE_CHUYEN",columnDefinition="boolean default false")
	private boolean valueChuyen;
	public BuocXuLyPheDuyetVanBan(){}
	
	
	
	
	public boolean isValueXuLy() {
		return valueXuLy;
	}
	public void setValueXuLy(boolean valueXuLy) {
		this.valueXuLy = valueXuLy;
	}
	public boolean isValueChuyen() {
		return valueChuyen;
	}
	public void setValueChuyen(boolean valueChuyen) {
		this.valueChuyen = valueChuyen;
	}
	public BuocXuLyPheDuyetVanBan(Pk_BuocXuLyVanBan pkBuocXuLy, Buoc buoc,
			VanBan vanban, NguoiDung nguoidung, String noiDungXLPD,
			Date thoiGianBatDau, Date thoiGianHoanThanh, boolean valueXuLy,
			boolean valueChuyen) {
		super();
		this.pkBuocXuLy = pkBuocXuLy;
		this.buoc = buoc;
		this.vanban = vanban;
		this.nguoidung = nguoidung;
		this.noiDungXLPD = noiDungXLPD;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianHoanThanh = thoiGianHoanThanh;
		this.valueXuLy = valueXuLy;
		this.valueChuyen = valueChuyen;
	}
	public String getNoiDungXLPD() {
		return noiDungXLPD;
	}
	public void setNoiDungXLPD(String noiDungXLPD) {
		this.noiDungXLPD = noiDungXLPD;
	}
	

	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	
	public Date getThoiGianHoanThanh() {
		return thoiGianHoanThanh;
	}
	public void setThoiGianHoanThanh(Date thoiGianHoanThanh) {
		this.thoiGianHoanThanh = thoiGianHoanThanh;
	}
	
}
