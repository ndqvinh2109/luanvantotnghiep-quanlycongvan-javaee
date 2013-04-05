package com.quangvinh.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HOSOLUUTRU")
public class HoSoLuuTru {
	/*****************************************/
	@OneToMany(mappedBy="hosoluutru",fetch=FetchType.LAZY)
	private List<VanBan> vanban = new ArrayList<VanBan>(0);
	
	public List<VanBan> getVanban() {
		return vanban;
	}
	public void setVanban(List<VanBan> vanban) {
		this.vanban = vanban;
	}
	/******************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SO_HO_SO")
	private int soHoSo;
	
	@Column(name="MA_HO_SO")
	private String maHoSo;
	
	@Column(name="TIEU_DE_HO_SO")
	private String tieuDeHoSo;
	@Temporal(TemporalType.DATE)
	@Column(name="THOI_GIAN_BD")
	private Date thoiGianBatDau;
	@Temporal(TemporalType.DATE)
	@Column(name="THOI_GIAN_KET_THUC")
	private Date thoiGianKetThuc;
	
	@Column(name="THOI_GIAN_BAO_QUAN")
	private int thoiGianBaoQuan;
	
	public HoSoLuuTru(){}
	
	
	
	public HoSoLuuTru(List<VanBan> vanban, int soHoSo, String maHoSo,
			String tieuDeHoSo, Date thoiGianBatDau, Date thoiGianKetThuc,
			int thoiGianBaoQuan) {
		super();
		this.vanban = vanban;
		this.soHoSo = soHoSo;
		this.maHoSo = maHoSo;
		this.tieuDeHoSo = tieuDeHoSo;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.thoiGianBaoQuan = thoiGianBaoQuan;
	}
	public String getMaHoSo() {
		return maHoSo;
	}
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	public int getSoHoSo() {
		return soHoSo;
	}
	public void setSoHoSo(int soHoSo) {
		this.soHoSo = soHoSo;
	}
	
	public String getTieuDeHoSo() {
		return tieuDeHoSo;
	}
	public void setTieuDeHoSo(String tieuDeHoSo) {
		this.tieuDeHoSo = tieuDeHoSo;
	}
	
	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	
	
	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	
	
	public int getThoiGianBaoQuan() {
		return thoiGianBaoQuan;
	}
	public void setThoiGianBaoQuan(int thoiGianBaoQuan) {
		this.thoiGianBaoQuan = thoiGianBaoQuan;
	}
	

}
