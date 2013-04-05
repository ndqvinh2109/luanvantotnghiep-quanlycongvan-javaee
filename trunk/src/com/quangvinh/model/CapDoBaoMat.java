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
@Table(name="CAPDOBAOMAT")
public class CapDoBaoMat {
	/*******************************************/
	@OneToMany(mappedBy="capdobaomat",fetch=FetchType.LAZY)
	private List<VanBan> vanban = new ArrayList<VanBan>(0);
	
	public List<VanBan> getVanban() {
		return vanban;
	}
	public void setVanban(List<VanBan> vanban) {
		this.vanban = vanban;
	}
	
	/********************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_DO_MAT")
	private int maDoMat;
	@Column(name="TEN_DO_MAT")
	private String tenDoMat;
	@Column(name="CAP_DO_MAT")
	private String capDoMat;
	public CapDoBaoMat(){}
	
	public CapDoBaoMat(List<VanBan> vanban, int maDoMat, String tenDoMat,
			String capDoMat) {
		super();
		this.vanban = vanban;
		this.maDoMat = maDoMat;
		this.tenDoMat = tenDoMat;
		this.capDoMat = capDoMat;
	}
	
	public int getMaDoMat() {
		return maDoMat;
	}
	public void setMaDoMat(int maDoMat) {
		this.maDoMat = maDoMat;
	}
	
	public String getTenDoMat() {
		return tenDoMat;
	}
	public void setTenDoMat(String tenDoMat) {
		this.tenDoMat = tenDoMat;
	}
	
	public String getCapDoMat() {
		return capDoMat;
	}
	public void setCapDoMat(String capDoMat) {
		this.capDoMat = capDoMat;
	}
	
}
