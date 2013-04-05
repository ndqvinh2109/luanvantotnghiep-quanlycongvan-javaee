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

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="CAPDOKHAN")
public class CapDoKhan {
	/********************************************/
	@JsonIgnore
	@OneToMany(mappedBy="capdokhan",fetch=FetchType.LAZY)
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
	@Column(name="MA_DO_KHAN")
	private int maDoKhan;
	@Column(name="GIA_TRI_CAP_DO")
	private int giaTriCapDo;
	@Column(name="TEN_DO_KHAN")
	private String tenDoKhan;
	
	public CapDoKhan(){}
	
	
	
	/**
	 * @param vanban
	 * @param maDoKhan
	 * @param giaTriCapDo
	 * @param tenDoKhan
	 */
	public CapDoKhan(List<VanBan> vanban, int maDoKhan, int giaTriCapDo,
			String tenDoKhan) {
		super();
		this.vanban = vanban;
		this.maDoKhan = maDoKhan;
		this.giaTriCapDo = giaTriCapDo;
		this.tenDoKhan = tenDoKhan;
	}
	public int getMaDoKhan() {
		return maDoKhan;
	}
	public void setMaDoKhan(int maDoKhan) {
		this.maDoKhan = maDoKhan;
	}
	
	public String getTenDoKhan() {
		return tenDoKhan;
	}
	public void setTenDoKhan(String tenDoKhan) {
		this.tenDoKhan = tenDoKhan;
	}
	public int getGiaTriCapDo() {
		return giaTriCapDo;
	}
	public void setGiaTriCapDo(int giaTriCapDo) {
		this.giaTriCapDo = giaTriCapDo;
	}
	
	
	
	
}
