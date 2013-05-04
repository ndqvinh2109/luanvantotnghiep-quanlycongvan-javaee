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
@Table(name="LINHVUC")
public class LinhVuc {
	/**************************************/
	@JsonIgnore
	@OneToMany(mappedBy="linhvuc",fetch=FetchType.LAZY)
	private List<VanBan> vanban = new ArrayList<VanBan>(0);
	
	public List<VanBan> getVanban() {
		return vanban;
	}
	public void setVanban(List<VanBan> vanban) {
		this.vanban = vanban;
	}
	/**************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_LINH_VUC")
	private int maLinhVuc;
	@Column(name="TEN_LINH_VUC")
	private String tenLinhVuc;
	public LinhVuc(){}
	
	
	public LinhVuc(List<VanBan> vanban, int maLinhVuc, String tenLinhVuc) {
		super();
		this.vanban = vanban;
		this.maLinhVuc = maLinhVuc;
		this.tenLinhVuc = tenLinhVuc;
	}
	
	public int getMaLinhVuc() {
		return maLinhVuc;
	}
	public void setMaLinhVuc(int maLinhVuc) {
		this.maLinhVuc = maLinhVuc;
	}
	
	public String getTenLinhVuc() {
		return tenLinhVuc;
	}
	public void setTenLinhVuc(String tenLinhVuc) {
		this.tenLinhVuc = tenLinhVuc;
	}
	
}
