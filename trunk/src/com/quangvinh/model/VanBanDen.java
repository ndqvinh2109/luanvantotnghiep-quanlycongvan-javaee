package com.quangvinh.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="VANBANDEN")

@PrimaryKeyJoinColumn(name="MA_VAN_BAN")
public class VanBanDen extends VanBan{
	/*******************************************/
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="MA_DON_VI")
	private DonVi donvi;
	
	public DonVi getDonvi() {
		return donvi;
	}
	public void setDonvi(DonVi donvi) {
		this.donvi = donvi;
	}
	/*******************************************/
	@Column(name="SO_DEN")
	private int SoDen;
	@Temporal(TemporalType.DATE)
	@Column(name="NGAY_DEN")
	private Date NgayDen;
	
	public VanBanDen(){}
	
	public VanBanDen(CapDoBaoMat capdobaomat, LinhVuc linhvuc,
			LoaiVanBan loaivanban, CapDoKhan capdokhan,
			ViTriLuuTru vitriluutru, HoSoLuuTru hosoluutru,
			String soKyHieuVanBan, Date ngayBanHanh, Date ngayHieuLuc,
			Date ngayHetHieuLuc,Date ngayNhapMay, String trichYeu, String nguoiKy, int soTrang,
			String tuKhoa, int trangThaiXuLy,DonVi donvi, int soDen, Date ngayDen) {
		super(capdobaomat,linhvuc,loaivanban,capdokhan,vitriluutru,hosoluutru,
				soKyHieuVanBan,ngayBanHanh,ngayHieuLuc,ngayHetHieuLuc,ngayNhapMay,
				trichYeu, nguoiKy,soTrang,tuKhoa, trangThaiXuLy);
		this.donvi = donvi;
		SoDen = soDen;
		NgayDen = ngayDen;
	}
	
	
	public VanBanDen(CapDoBaoMat capdobaomat, LinhVuc linhvuc,
			LoaiVanBan loaivanban, CapDoKhan capdokhan,
			ViTriLuuTru vitriluutru, HoSoLuuTru hosoluutru,
			String soKyHieuVanBan, Date ngayBanHanh, Date ngayHieuLuc,
			Date ngayHetHieuLuc,Date ngayNhapMay, String trichYeu, String nguoiKy, int soTrang,
			String tuKhoa, int trangThaiXuLy,DonVi donvi) {
		super(capdobaomat,linhvuc,loaivanban,capdokhan,vitriluutru,hosoluutru,
				soKyHieuVanBan,ngayBanHanh,ngayHieuLuc,ngayHetHieuLuc,ngayNhapMay,
				trichYeu, nguoiKy,soTrang,tuKhoa, trangThaiXuLy);
		this.donvi = donvi;
		
	}
	
	public VanBanDen(CapDoBaoMat capdobaomat, LinhVuc linhvuc,
			LoaiVanBan loaivanban, CapDoKhan capdokhan,
			ViTriLuuTru vitriluutru, HoSoLuuTru hosoluutru,
			List<FileDinhKem> filedinhkem, String soKyHieuVanBan,
			Date ngayBanHanh, Date ngayHieuLuc, Date ngayHetHieuLuc,
			String trichYeu, String nguoiKy, int soTrang, String tuKhoa,
			Date ngayNhapMay, int trangThaiXuLy,DonVi donvi) {
		super(capdobaomat, linhvuc,loaivanban, capdokhan, vitriluutru, hosoluutru,
				filedinhkem, soKyHieuVanBan, ngayBanHanh, ngayHieuLuc, ngayHetHieuLuc,
				trichYeu, nguoiKy, soTrang, tuKhoa, ngayNhapMay, trangThaiXuLy);
		this.donvi = donvi;
		
	}
	
	
	
	
	public VanBanDen(CapDoBaoMat capdobaomat, LinhVuc linhvuc,
			LoaiVanBan loaivanban, CapDoKhan capdokhan,
			ViTriLuuTru vitriluutru, HoSoLuuTru hosoluutru, int maVanBan,
			String soKyHieuVanBan, Date ngayBanHanh, Date ngayHieuLuc,
			Date ngayHetHieuLuc, String trichYeu, String nguoiKy, int soTrang,
			String tuKhoa, Date ngayNhapMay, int trangThaiXuLy, DonVi donvi,
			int soDen, Date ngayDen) {
		super(capdobaomat, linhvuc, loaivanban, capdokhan, vitriluutru,
				hosoluutru, maVanBan, soKyHieuVanBan, ngayBanHanh, ngayHieuLuc,
				ngayHetHieuLuc, trichYeu, nguoiKy, soTrang, tuKhoa,
				ngayNhapMay, trangThaiXuLy);
		this.donvi = donvi;
		SoDen = soDen;
		NgayDen = ngayDen;
	}
	
	
	/**
	 * @param soDen
	 * @param ngayDen
	 */
	public VanBanDen(int soDen, Date ngayDen,int maVanBan) {
		super(maVanBan);
		SoDen = soDen;
		NgayDen = ngayDen;
	}
	
	public int getSoDen() {
		return SoDen;
	}
	public void setSoDen(int soDen) {
		SoDen = soDen;
	}
	
	public Date getNgayDen() {
		return NgayDen;
	}
	public void setNgayDen(Date ngayDen) {
		NgayDen = ngayDen;
	}
	
}
