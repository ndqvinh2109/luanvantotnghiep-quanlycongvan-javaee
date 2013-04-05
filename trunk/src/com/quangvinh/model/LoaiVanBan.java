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
@Table(name="LOAIVANBAN")
public class LoaiVanBan {
	/***************************************/
	@ManyToOne
	@JoinColumn(name="MA_QUY_TRINH")
	private QuyTrinh quytrinh;
	
	public QuyTrinh getQuytrinh() {
		return quytrinh;
	}
	public void setQuytrinh(QuyTrinh quytrinh) {
		this.quytrinh = quytrinh;
	}
	
	@OneToMany(mappedBy="loaivanban",fetch=FetchType.LAZY)
	private List<VanBan> vanban = new ArrayList<VanBan>(0);
	
	public List<VanBan> getVanban() {
		return vanban;
	}
	public void setVanban(List<VanBan> vanban) {
		this.vanban = vanban;
	}
	/***************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_LOAI")
	private int maLoaiVanBan;
	@Column(name="TEN_LOAI")
	private String tenLoaiVanBan;
	public LoaiVanBan(){}
	
	
	public LoaiVanBan(QuyTrinh quytrinh, List<VanBan> vanban, int maLoaiVanBan,
			String tenLoaiVanBan) {
		super();
		this.quytrinh = quytrinh;
		this.vanban = vanban;
		this.maLoaiVanBan = maLoaiVanBan;
		this.tenLoaiVanBan = tenLoaiVanBan;
	}
	
	public int getMaLoaiVanBan() {
		return maLoaiVanBan;
	}
	public void setMaLoaiVanBan(int maLoaiVanBan) {
		this.maLoaiVanBan = maLoaiVanBan;
	}
	
	public String getTenLoaiVanBan() {
		return tenLoaiVanBan;
	}
	public void setTenLoaiVanBan(String tenLoaiVanBan) {
		this.tenLoaiVanBan = tenLoaiVanBan;
	}
	
}
