package com.quangvinh.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DONVI")
public class DonVi {
	/*****************************************/
	@OneToMany(mappedBy="donvi",fetch=FetchType.LAZY)
	private List<NguoiDung> nguoidung = new ArrayList<NguoiDung>(0);
	
	public List<NguoiDung> getNguoidung() {
		return nguoidung;
	}
	public void setNguoidung(List<NguoiDung> nguoidung) {
		this.nguoidung = nguoidung;
	}
	
	@OneToMany(mappedBy="donvi",fetch=FetchType.LAZY)
	private List<VanBanDen> vanbanden = new ArrayList<VanBanDen>(0);
	
	public List<VanBanDen> getVanbanden() {
		return vanbanden;
	}
	public void setVanbanden(List<VanBanDen> vanbanden) {
		this.vanbanden = vanbanden;
	}
	
	@ManyToMany(mappedBy="donvi",fetch = FetchType.EAGER)
	private List<VanBanDi> vanbandi = new ArrayList<VanBanDi>(0);
	
	public List<VanBanDi> getVanbandi() {
		return vanbandi;
	}
	public void setVanbandi(List<VanBanDi> vanbandi) {
		this.vanbandi = vanbandi;
	}
	
	
	
	/*****************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_DON_VI")
	private int maDonVi;
	@Column(name="TEN_DON_VI")
	private String tenDonVi;
	@Column(name="KIEU_DON_VI")
	private int kieuDonVi;
	
	public DonVi(){}
	
	public DonVi(List<NguoiDung> nguoidung, List<VanBanDen> vanbanden,
			List<VanBanDi> vanbandi, int maDonVi, String tenDonVi) {
		super();
		this.nguoidung = nguoidung;
		this.vanbanden = vanbanden;
		this.vanbandi = vanbandi;
		this.maDonVi = maDonVi;
		this.tenDonVi = tenDonVi;
	}
	
	
	
	public int getMaDonVi() {
		return maDonVi;
	}
	
	public void setMaDonVi(int maDonVi) {
		this.maDonVi = maDonVi;
	}
	
	public String getTenDonVi() {
		return tenDonVi;
	}
	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}
	

}
