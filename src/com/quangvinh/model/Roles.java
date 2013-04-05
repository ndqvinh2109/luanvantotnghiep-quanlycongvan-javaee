package com.quangvinh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="ROLES")
public class Roles {
	/****************************************/
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="MA_NGUOI_DUNG")
	private NguoiDung nguoidung;
	
	public NguoiDung getNguoidung() {
		return nguoidung;
	}
	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}
	/****************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_ROLES")
	private int maRoles;
	@Column(name="TEN_ROLES")
	private String tenRoles;
	public Roles(){}
	
	

	
	public int getMaRoles() {
		return maRoles;
	}
	public void setMaRoles(int maRoles) {
		this.maRoles = maRoles;
	}
	
	public String getTenRoles() {
		return tenRoles;
	}
	public void setTenRoles(String tenRoles) {
		this.tenRoles = tenRoles;
	}
	
}
