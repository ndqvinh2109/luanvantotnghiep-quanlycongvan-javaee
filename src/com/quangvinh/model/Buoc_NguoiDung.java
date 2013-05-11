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
@Table(name="BUOC_NGUOIDUNG")
public class Buoc_NguoiDung {
	/**
	 * Object Relational Mapping
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
	@ManyToOne
	@JoinColumn(name="MA_QUY_TRINH")
	private QuyTrinh quytrinh;
	
	public QuyTrinh getQuytrinh() {
		return quytrinh;
	}

	public void setQuytrinh(QuyTrinh quytrinh) {
		this.quytrinh = quytrinh;
	}
	/*@ManyToOne
	@JoinColumns({@JoinColumn(name="MA_QUY_TRINH",updatable=false,insertable=false),@JoinColumn(name="SO_THU_TU",updatable=false,insertable=false)})
	private Buoc buoc;
	
	public Buoc getBuoc() {
		return buoc;
	}
	public void setBuoc(Buoc buoc) {
		this.buoc = buoc;
	}*/
		
	

	/**
	 * End	
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_BUOC_NGUOI_DUNG")
	private int maBuocNguoiDung;

	public int getMaBuocNguoiDung() {
		return maBuocNguoiDung;
	}

	public void setMaBuocNguoiDung(int maBuocNguoiDung) {
		this.maBuocNguoiDung = maBuocNguoiDung;
	}
	
	@Column(name="SO_THU_TU")
	private int sothutu;

	public int getSothutu() {
		return sothutu;
	}

	public void setSothutu(int sothutu) {
		this.sothutu = sothutu;
	}
	
	
	
}
