package com.quangvinh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BUOC")
public class Buoc {
	/*----------------------------Relational Mapping-----------------------------------------*/
	@SuppressWarnings("serial")
	@Embeddable
	public static class Pk_QuyTrinh implements Serializable{
		@Column(name="SO_THU_TU")
		private int soThuTu;
		
		public int getSoThuTu() {
			return soThuTu;
		}
		public void setSoThuTu(int soThuTu) {
			this.soThuTu = soThuTu;
		}
		@Column(name="MA_QUY_TRINH")
		private int maQuyTrinh;
		
		public int getMaQuyTrinh() {
			return maQuyTrinh;
		}
		public void setMaQuyTrinh(int maQuyTrinh) {
			this.maQuyTrinh = maQuyTrinh;
		}
		
	}
	@EmbeddedId
	Pk_QuyTrinh pkQuyTrinh = new Pk_QuyTrinh();
	
	public Pk_QuyTrinh getPkQuyTrinh() {
		return pkQuyTrinh;
	}

	public void setPkQuyTrinh(Pk_QuyTrinh pkQuyTrinh) {
		this.pkQuyTrinh = pkQuyTrinh;
	}
	@ManyToOne
	@JoinColumn(name="MA_QUY_TRINH",insertable=false,updatable=false,nullable=false)
	private QuyTrinh quytrinh;
	
	public QuyTrinh getQuytrinh() {
		return quytrinh;
	}

	public void setQuytrinh(QuyTrinh quytrinh) {
		this.quytrinh = quytrinh;
	}
	@OneToMany(mappedBy="buoc",fetch=FetchType.LAZY)
	private List<BuocXuLyPheDuyetVanBan> buocXuLy = new ArrayList<BuocXuLyPheDuyetVanBan>(0);
	
	public List<BuocXuLyPheDuyetVanBan> getBuocXuLy() {
		return buocXuLy;
	}

	public void setBuocXuLy(List<BuocXuLyPheDuyetVanBan> buocXuLy) {
		this.buocXuLy = buocXuLy;
	}
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
	@JoinColumn(name="MA_CONG_VIEC")
	private CongViec congviec;
	
	
	public CongViec getCongviec() {
		return congviec;
	}

	public void setCongviec(CongViec congviec) {
		this.congviec = congviec;
	}
	/*------------------------------------------------------------------*/
	@Column(name="SO_NGAY")
	private int soNgay;
	
	public Buoc(){}
	
	

	
	public Buoc(Pk_QuyTrinh pkQuyTrinh, QuyTrinh quytrinh,
			List<BuocXuLyPheDuyetVanBan> buocXuLy, NguoiDung nguoidung,
			int soNgay) {
		super();
		this.pkQuyTrinh = pkQuyTrinh;
		this.quytrinh = quytrinh;
		this.buocXuLy = buocXuLy;
		this.nguoidung = nguoidung;
		this.soNgay = soNgay;
	}

	public int getSoNgay() {
		return soNgay;
	}
	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}

	
}
