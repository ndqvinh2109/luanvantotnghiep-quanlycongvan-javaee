package com.quangvinh.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NGUOIDUNG")
public class NguoiDung {
	/*---------------------Relational Mapping----------------------------*/
	
	@OneToMany(mappedBy="nguoidung",fetch=FetchType.LAZY)
	private List<Roles> roles = new ArrayList<Roles>(0);
	
	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
	
	@OneToMany(mappedBy="nguoidung",fetch=FetchType.LAZY)
	private List<BuocXuLyPheDuyetVanBan> buocXuLy = new ArrayList<BuocXuLyPheDuyetVanBan>(0);
	
	public List<BuocXuLyPheDuyetVanBan> getBuocXuLy() {
		return buocXuLy;
	}

	public void setBuocXuLy(List<BuocXuLyPheDuyetVanBan> buocXuLy) {
		this.buocXuLy = buocXuLy;
	}
	@OneToMany(mappedBy="nguoidung",fetch=FetchType.LAZY)
	private List<Buoc> buoc = new ArrayList<Buoc>(0);
	
	public List<Buoc> getBuoc() {
		return buoc;
	}

	public void setBuoc(List<Buoc> buoc) {
		this.buoc = buoc;
	}
	
	@OneToMany(mappedBy="nguoidung",fetch=FetchType.LAZY)
	private List<Message> message = new ArrayList<Message>(0);
		
	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}


	@OneToMany(mappedBy="nguoidung",fetch=FetchType.LAZY)
	private List<ChucVu> chucvu = new ArrayList<ChucVu>(0);
	

	public List<ChucVu> getChucvu() {
		return chucvu;
	}

	public void setChucvu(List<ChucVu> chucvu) {
		this.chucvu = chucvu;
	}
	@ManyToOne
	@JoinColumn(name="MA_DON_VI")
	private DonVi donvi;
	
	public DonVi getDonvi() {
		return donvi;
	}

	public void setDonvi(DonVi donvi) {
		this.donvi = donvi;
	}
	
	
	/*--------------------------------------------------*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_NGUOI_DUNG")
	private int maNguoiDung;
	@Column(name="TEN_NGUOI_DUNG")
	private String tenNguoiDung;
	@Column(name="GIOI_TINH")
	private int gioiTinh;
	@Column(name="EMAIL")
	private String email;
	@Column(name="DIA_CHI")
	private String diaChi;
	@Column(name="SO_DIEN_THOAI")
	private String soDienThoai;
	@Column(name="USERNAME")
	private String userName;
	@Column(name="PASSWORD")
	private String passWord;
	@Column(name="MAC_DINH",columnDefinition="boolean default false")
	private boolean macDinh;
	
	public NguoiDung(){}
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isMacDinh() {
		return macDinh;
	}

	public void setMacDinh(boolean macDinh) {
		this.macDinh = macDinh;
	}

	
	

	public int getMaNguoiDung() {
		return maNguoiDung;
	}
	
	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	
	public String getTenNguoiDung() {
		return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}
	
	
	
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
}
