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
@Table(name="CONGVIEC")
public class CongViec {
	/************************Relational Mapping******************************/
	@JsonIgnore
	@OneToMany(mappedBy="congviec",fetch=FetchType.LAZY)
	private List<Buoc> buoc = new ArrayList<Buoc>(0);
	
	public List<Buoc> getBuoc() {
		return buoc;
	}

	public void setBuoc(List<Buoc> buoc) {
		this.buoc = buoc;
	}
	
	/*************************************************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_CONG_VIEC")
	private int maCongViec;
	@Column(name="TEN_CONG_VIEC")
	private String tenCongViec;
	@Column(name="NOI_DUNG_CONG_VIEC")
	private String noiDungCongViec;

	
	public String getTenCongViec() {
		return tenCongViec;
	}

	public void setTenCongViec(String tenCongViec) {
		this.tenCongViec = tenCongViec;
	}

	public CongViec(){}
	
	
	public CongViec(List<Buoc> buoc,String tenCongViec,
			String noiDungCongViec) {
		super();
		this.buoc = buoc;
		
		this.tenCongViec = tenCongViec;
		this.noiDungCongViec = noiDungCongViec;
	}

	public int getMaCongViec() {
		return maCongViec;
	}

	public void setMaCongViec(int maCongViec) {
		this.maCongViec = maCongViec;
	}

	

	public String getNoiDungCongViec() {
		return noiDungCongViec;
	}

	public void setNoiDungCongViec(String noiDungCongViec) {
		this.noiDungCongViec = noiDungCongViec;
	}
	
	
	
}
