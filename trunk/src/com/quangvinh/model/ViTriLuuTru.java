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
@Table(name="VITRILUUTRU")
public class ViTriLuuTru {
	/****************************************/
	@OneToMany(mappedBy="vitriluutru",fetch=FetchType.LAZY)
	private List<VanBan> vanban = new ArrayList<VanBan>(0);
	
	public List<VanBan> getVanban() {
		return vanban;
	}
	public void setVanban(List<VanBan> vanban) {
		this.vanban = vanban;
	}
	/****************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STT")
	private int stt;
	@Column(name="VI_TRI")
	private String viTri;
	public ViTriLuuTru(){}
	
	public ViTriLuuTru(List<VanBan> vanban, int stt, String viTri) {
		super();
		this.vanban = vanban;
		this.stt = stt;
		this.viTri = viTri;
	}
	
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	
	
}
