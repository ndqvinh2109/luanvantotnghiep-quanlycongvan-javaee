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
@Table(name="ROLES")
public class Roles {
	/****************************************/
	/*@JsonIgnore
	@ManyToOne
	@JoinColumn(name="MA_NGUOI_DUNG")
	private NguoiDung nguoidung;
	
	public NguoiDung getNguoidung() {
		return nguoidung;
	}
	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}*/
	
	@JsonIgnore
	@OneToMany(mappedBy="roles",fetch=FetchType.LAZY)
	private List<NguoiDung_Roles> nguoidungroles = new ArrayList<NguoiDung_Roles>(0);
	
	public List<NguoiDung_Roles> getNguoidungroles() {
		return nguoidungroles;
	}

	public void setNguoidungroles(List<NguoiDung_Roles> nguoidungroles) {
		this.nguoidungroles = nguoidungroles;
	}
	
	/****************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_ROLES")
	private int maRoles;
	@Column(name="TEN_ROLES")
	private String tenRoles;
	@Column(name="TEN_ROLES_CHI_TIET")
	private String tenRolesChiTiet;
	
	
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
	public String getTenRolesChiTiet() {
		return tenRolesChiTiet;
	}
	public void setTenRolesChiTiet(String tenRolesChiTiet) {
		this.tenRolesChiTiet = tenRolesChiTiet;
	}
	
}
