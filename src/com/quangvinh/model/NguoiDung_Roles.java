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
@Table(name="NGUOIDUNG_ROLES")
public class NguoiDung_Roles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int Id;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	/**
	 *  Relation Mapping
	 */
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
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="MA_ROLES")
	private Roles roles;

	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	public NguoiDung_Roles(){}
	
	public NguoiDung_Roles(int id, NguoiDung nguoidung, Roles roles) {
		super();
		Id = id;
		this.nguoidung = nguoidung;
		this.roles = roles;
	}
	
	
	
	
	/**
	 *  End
	 */
}
