package com.quangvinh.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUYTRINH")
public class QuyTrinh {
	/*-------------------------------*/
	@OneToMany(mappedBy="quytrinh",fetch=FetchType.LAZY)
	private List<Buoc> buoc = new ArrayList<Buoc>(0);
	
	public List<Buoc> getBuoc() {
		return buoc;
	}
	public void setBuoc(List<Buoc> buoc) {
		this.buoc = buoc;
	}
	@OneToMany(mappedBy="quytrinh",fetch=FetchType.LAZY)
	private List<LoaiVanBan> loaivanban = new ArrayList<LoaiVanBan>(0);
	
	public List<LoaiVanBan> getLoaivanban() {
		return loaivanban;
	}
	public void setLoaivanban(List<LoaiVanBan> loaivanban) {
		this.loaivanban = loaivanban;
	}
	
	@OneToMany(mappedBy="quytrinh",fetch=FetchType.LAZY)
	private List<Buoc_NguoiDung> buocnguoidung = new ArrayList<Buoc_NguoiDung>(0);
	public List<Buoc_NguoiDung> getBuocnguoidung() {
		return buocnguoidung;
	}
	public void setBuocnguoidung(List<Buoc_NguoiDung> buocnguoidung) {
		this.buocnguoidung = buocnguoidung;
	}
	
	/*-------------------------------*/
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_QUY_TRINH")
	private int maQuyTrinh;
	@Column(name="MO_TA")
	private String moTa;
	
	public QuyTrinh(){}
	
	public QuyTrinh(List<Buoc> buoc, List<LoaiVanBan> loaivanban,
			int maQuyTrinh, String moTa) {
		super();
		this.buoc = buoc;
		this.loaivanban = loaivanban;
		this.maQuyTrinh = maQuyTrinh;
		this.moTa = moTa;
	}
	
	public int getMaQuyTrinh() {
		return maQuyTrinh;
	}
	public void setMaQuyTrinh(int maQuyTrinh) {
		this.maQuyTrinh = maQuyTrinh;
	}
	
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
}
