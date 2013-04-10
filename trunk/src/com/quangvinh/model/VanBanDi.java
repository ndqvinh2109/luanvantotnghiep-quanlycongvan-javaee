package com.quangvinh.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="VANBANDI")
@PrimaryKeyJoinColumn(name="MA_VAN_BAN")
public class VanBanDi extends VanBan{
	/*******************************************/
	@JsonIgnore
	@OneToMany(mappedBy="vanbandi",fetch=FetchType.LAZY)
	private List<VanBanDi_DonVi> vanbandi_donvi = new ArrayList<VanBanDi_DonVi>(0);
		
	public List<VanBanDi_DonVi> getVanbandi_donvi() {
		return vanbandi_donvi;
	}

	public void setVanbandi_donvi(List<VanBanDi_DonVi> vanbandi_donvi) {
		this.vanbandi_donvi = vanbandi_donvi;
	}
	/*******************************************/
	@Column(name="SO_DI")
	private int SoDi;
	@Temporal(TemporalType.DATE)
	@Column(name="NGAY_DI")
	private Date NgayDi;
	
	public VanBanDi(){}
	
	public VanBanDi(CapDoBaoMat capdobaomat, LinhVuc linhvuc,
			LoaiVanBan loaivanban, CapDoKhan capdokhan,
			ViTriLuuTru vitriluutru, HoSoLuuTru hosoluutru,
			String soKyHieuVanBan, Date ngayBanHanh, Date ngayHieuLuc,
			Date ngayHetHieuLuc,Date ngayNhapMay, String trichYeu, String nguoiKy, int soTrang,
			String tuKhoa, int trangThaiXuLy) {
		super(capdobaomat,linhvuc,loaivanban,capdokhan,vitriluutru,hosoluutru,
				soKyHieuVanBan,ngayBanHanh,ngayHieuLuc,ngayHetHieuLuc,ngayNhapMay,
				trichYeu, nguoiKy,soTrang,tuKhoa, trangThaiXuLy);
		
	}
	
	
	public VanBanDi(CapDoBaoMat capdobaomat, LinhVuc linhvuc,
			LoaiVanBan loaivanban, CapDoKhan capdokhan,
			ViTriLuuTru vitriluutru, HoSoLuuTru hosoluutru, int maVanBan,
			String soKyHieuVanBan, Date ngayBanHanh, Date ngayHieuLuc,
			Date ngayHetHieuLuc, String trichYeu, String nguoiKy, int soTrang,
			String tuKhoa, Date ngayNhapMay, int trangThaiXuLy,
			int soDi, Date ngayDi) {
		super(capdobaomat, linhvuc, loaivanban, capdokhan, vitriluutru,
				hosoluutru, maVanBan, soKyHieuVanBan, ngayBanHanh, ngayHieuLuc,
				ngayHetHieuLuc, trichYeu, nguoiKy, soTrang, tuKhoa,
				ngayNhapMay, trangThaiXuLy);
		SoDi = soDi;
		NgayDi = ngayDi;
	}
	
	
	
	
	public int getSoDi() {
		return SoDi;
	}
	public void setSoDi(int soDi) {
		SoDi = soDi;
	}
	
	public Date getNgayDi() {
		return NgayDi;
	}
	public void setNgayDi(Date ngayDi) {
		NgayDi = ngayDi;
	}
}
