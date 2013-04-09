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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="VANBAN")
@Inheritance(strategy = InheritanceType.JOINED)
public class VanBan {
	/*-------------------------------------------------*/
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="MA_DO_MAT")
	private CapDoBaoMat capdobaomat;
	
	public CapDoBaoMat getCapdobaomat() {
		return capdobaomat;
	}
	public void setCapdobaomat(CapDoBaoMat capdobaomat) {
		this.capdobaomat = capdobaomat;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="MA_LINH_VUC")
	private LinhVuc linhvuc;
	
	public LinhVuc getLinhvuc() {
		return linhvuc;
	}
	public void setLinhvuc(LinhVuc linhvuc) {
		this.linhvuc = linhvuc;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="MA_LOAI")
	private LoaiVanBan loaivanban;
	
	public LoaiVanBan getLoaivanban() {
		return loaivanban;
	}
	public void setLoaivanban(LoaiVanBan loaivanban) {
		this.loaivanban = loaivanban;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="MA_DO_KHAN")
	private CapDoKhan capdokhan;
	
	public CapDoKhan getCapdokhan() {
		return capdokhan;
	}
	public void setCapdokhan(CapDoKhan capdokhan) {
		this.capdokhan = capdokhan;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="STT")
	private ViTriLuuTru vitriluutru;
	
	public ViTriLuuTru getVitriluutru() {
		return vitriluutru;
	}
	public void setVitriluutru(ViTriLuuTru vitriluutru) {
		this.vitriluutru = vitriluutru;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="SO_HO_SO")
	private HoSoLuuTru hosoluutru;
	 
	public HoSoLuuTru getHosoluutru() {
		return hosoluutru;
	}
	public void setHosoluutru(HoSoLuuTru hosoluutru) {
		this.hosoluutru = hosoluutru;
	}
	@JsonIgnore
	@OneToMany(mappedBy="vanban",fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private List<FileDinhKem> filedinhkem = new ArrayList<FileDinhKem>(0);
	
	public List<FileDinhKem> getFiledinhkem() {
		
		return filedinhkem;
	}
	public void setFiledinhkem(List<FileDinhKem> filedinhkem) {
		this.filedinhkem = filedinhkem;
	}
	@JsonIgnore
	@OneToMany(mappedBy="vanban",fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private List<Comment> comment = new ArrayList<Comment>(0);
	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	@JsonIgnore
	@OneToMany(mappedBy="vanban",fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private List<BuocXuLyPheDuyetVanBan> buocXuLy = new ArrayList<BuocXuLyPheDuyetVanBan>(0);
	
	public List<BuocXuLyPheDuyetVanBan> getBuocXuLy() {
		return buocXuLy;
	}
	public void setBuocXuLy(List<BuocXuLyPheDuyetVanBan> buocXuLy) {
		this.buocXuLy = buocXuLy;
	}
	/*-------------------------------------------------*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_VAN_BAN")
	private int maVanBan;
	@Column(name="KY_HIEU")
	private String soKyHieuVanBan;
	@Temporal(TemporalType.DATE)
	@Column(name="NGAY_BAN_HANH")
	private Date ngayBanHanh;
	@Temporal(TemporalType.DATE)
	@Column(name="NGAY_HIEU_LUC")
	private Date ngayHieuLuc;
	@Temporal(TemporalType.DATE)
	@Column(name="NGAY_HET_HIEU_LUC")
	private Date ngayHetHieuLuc;
	@Column(name="TRICH_YEU")
	private String trichYeu;
	@Column(name="NGUOI_KY")
	private String nguoiKy;
	@Column(name="SO_TRANG")
	private int soTrang;
	@Column(name="TU_KHOA")
	private String tuKhoa;
	@Temporal(TemporalType.DATE)
	@Column(name="NGAY_NHAP_MAY")
	private Date ngayNhapMay;
	@Column(name="TRANG_THAI_XU_LY")
	private int trangThaiXuLy;
	@Column(name="ENABLED",columnDefinition="boolean default false")
	private boolean enabled;
	/*@Column(name="IS_BAN_HANH",columnDefinition="boolean default false")
	private boolean isBanHanh;*/
	
	
	public VanBan(){}
	
	
	
	
	/**
	 * @param maVanBan
	 */
	public VanBan(int maVanBan) {
		super();
		this.maVanBan = maVanBan;
	}
	
	
	
	
	
	/**
	 * @param capdobaomat
	 * @param linhvuc
	 * @param loaivanban
	 * @param capdokhan
	 * @param vitriluutru
	 * @param hosoluutru
	 * @param filedinhkem
	 * @param maVanBan
	 * @param soKyHieuVanBan
	 * @param ngayBanHanh
	 * @param ngayHieuLuc
	 * @param ngayHetHieuLuc
	 * @param trichYeu
	 * @param nguoiKy
	 * @param soTrang
	 * @param tuKhoa
	 * @param ngayNhapMay
	 * @param trangThaiXuLy
	 */
	public VanBan(CapDoBaoMat capdobaomat, LinhVuc linhvuc,
			LoaiVanBan loaivanban, CapDoKhan capdokhan,
			ViTriLuuTru vitriluutru, HoSoLuuTru hosoluutru,
			List<FileDinhKem> filedinhkem,String soKyHieuVanBan,
			Date ngayBanHanh, Date ngayHieuLuc, Date ngayHetHieuLuc,
			String trichYeu, String nguoiKy, int soTrang, String tuKhoa,
			Date ngayNhapMay, int trangThaiXuLy) {
		super();
		this.capdobaomat = capdobaomat;
		this.linhvuc = linhvuc;
		this.loaivanban = loaivanban;
		this.capdokhan = capdokhan;
		this.vitriluutru = vitriluutru;
		this.hosoluutru = hosoluutru;
		this.filedinhkem = filedinhkem;
		this.soKyHieuVanBan = soKyHieuVanBan;
		this.ngayBanHanh = ngayBanHanh;
		this.ngayHieuLuc = ngayHieuLuc;
		this.ngayHetHieuLuc = ngayHetHieuLuc;
		this.trichYeu = trichYeu;
		this.nguoiKy = nguoiKy;
		this.soTrang = soTrang;
		this.tuKhoa = tuKhoa;
		this.ngayNhapMay = ngayNhapMay;
		this.trangThaiXuLy = trangThaiXuLy;
	}
	public VanBan(CapDoBaoMat capdobaomat, LinhVuc linhvuc,
			LoaiVanBan loaivanban, CapDoKhan capdokhan,
			ViTriLuuTru vitriluutru, HoSoLuuTru hosoluutru,String soKyHieuVanBan,
			Date ngayBanHanh, Date ngayHieuLuc,	Date ngayHetHieuLuc,Date ngayNhapMay,
			String trichYeu,String nguoiKy, int soTrang,String tuKhoa, int trangThaiXuLy) {
		super();
		this.capdobaomat = capdobaomat;
		this.linhvuc = linhvuc;
		this.loaivanban = loaivanban;
		this.capdokhan = capdokhan;
		this.vitriluutru = vitriluutru;
		this.hosoluutru = hosoluutru;
		this.soKyHieuVanBan = soKyHieuVanBan;
		this.ngayBanHanh = ngayBanHanh;
		this.ngayHieuLuc = ngayHieuLuc;
		this.ngayHetHieuLuc = ngayHetHieuLuc;
		this.ngayNhapMay = ngayNhapMay;
		this.trichYeu = trichYeu;
		this.nguoiKy = nguoiKy;
		this.soTrang = soTrang;
		this.tuKhoa = tuKhoa;
		this.trangThaiXuLy = trangThaiXuLy;
	}
	
	
	public VanBan(CapDoBaoMat capdobaomat, LinhVuc linhvuc,
			LoaiVanBan loaivanban, CapDoKhan capdokhan,
			ViTriLuuTru vitriluutru, HoSoLuuTru hosoluutru, int maVanBan,
			String soKyHieuVanBan, Date ngayBanHanh, Date ngayHieuLuc,
			Date ngayHetHieuLuc, String trichYeu, String nguoiKy, int soTrang,
			String tuKhoa, Date ngayNhapMay, int trangThaiXuLy) {
		super();
		this.capdobaomat = capdobaomat;
		this.linhvuc = linhvuc;
		this.loaivanban = loaivanban;
		this.capdokhan = capdokhan;
		this.vitriluutru = vitriluutru;
		this.hosoluutru = hosoluutru;
		this.maVanBan = maVanBan;
		this.soKyHieuVanBan = soKyHieuVanBan;
		this.ngayBanHanh = ngayBanHanh;
		this.ngayHieuLuc = ngayHieuLuc;
		this.ngayHetHieuLuc = ngayHetHieuLuc;
		this.trichYeu = trichYeu;
		this.nguoiKy = nguoiKy;
		this.soTrang = soTrang;
		this.tuKhoa = tuKhoa;
		this.ngayNhapMay = ngayNhapMay;
		this.trangThaiXuLy = trangThaiXuLy;
	}
	
	
	public VanBan(CapDoBaoMat capdobaomat, LinhVuc linhvuc,
			LoaiVanBan loaivanban, CapDoKhan capdokhan,
			ViTriLuuTru vitriluutru, HoSoLuuTru hosoluutru,
			List<FileDinhKem> filedinhkem, int maVanBan, String soKyHieuVanBan,
			Date ngayBanHanh, Date ngayHieuLuc, Date ngayHetHieuLuc,
			String trichYeu, String nguoiKy, int soTrang, String tuKhoa,
			Date ngayNhapMay, int trangThaiXuLy) {
		super();
		this.capdobaomat = capdobaomat;
		this.linhvuc = linhvuc;
		this.loaivanban = loaivanban;
		this.capdokhan = capdokhan;
		this.vitriluutru = vitriluutru;
		this.hosoluutru = hosoluutru;
		this.filedinhkem = filedinhkem;
		this.maVanBan = maVanBan;
		this.soKyHieuVanBan = soKyHieuVanBan;
		this.ngayBanHanh = ngayBanHanh;
		this.ngayHieuLuc = ngayHieuLuc;
		this.ngayHetHieuLuc = ngayHetHieuLuc;
		this.trichYeu = trichYeu;
		this.nguoiKy = nguoiKy;
		this.soTrang = soTrang;
		this.tuKhoa = tuKhoa;
		this.ngayNhapMay = ngayNhapMay;
		this.trangThaiXuLy = trangThaiXuLy;
	}
	public int getMaVanBan() {
		return maVanBan;
	}
	public void setMaVanBan(int maVanBan) {
		this.maVanBan = maVanBan;
	}
	
	public String getSoKyHieuVanBan() {
		return soKyHieuVanBan;
	}
	public void setSoKyHieuVanBan(String soKyHieuVanBan) {
		this.soKyHieuVanBan = soKyHieuVanBan;
	}
	
	
	public Date getNgayBanHanh() {
		return ngayBanHanh;
	}
	public void setNgayBanHanh(Date ngayBanHanh) {
		this.ngayBanHanh = ngayBanHanh;
	}
	
	
	public Date getNgayHieuLuc() {
		return ngayHieuLuc;
	}
	public void setNgayHieuLuc(Date ngayHieuLuc) {
		this.ngayHieuLuc = ngayHieuLuc;
	}
	
	
	public Date getNgayHetHieuLuc() {
		return ngayHetHieuLuc;
	}
	public void setNgayHetHieuLuc(Date ngayHetHieuLuc) {
		this.ngayHetHieuLuc = ngayHetHieuLuc;
	}

	public String getTrichYeu() {
		return trichYeu;
	}
	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}
	
	public String getNguoiKy() {
		return nguoiKy;
	}
	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public String getTuKhoa() {
		return tuKhoa;
	}
	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}
	
	
	public Date getNgayNhapMay() {
		return ngayNhapMay;
	}
	public void setNgayNhapMay(Date ngayNhapMay) {
		this.ngayNhapMay = ngayNhapMay;
	}
	
	public int getTrangThaiXuLy() {
		return trangThaiXuLy;
	}
	public void setTrangThaiXuLy(int trangThaiXuLy) {
		this.trangThaiXuLy = trangThaiXuLy;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
