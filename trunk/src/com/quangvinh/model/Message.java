package com.quangvinh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MESSAGE")
public class Message {
	/*************************************/
	
	@ManyToOne
	@JoinColumn(name="MA_NGUOI_DUNG")
	private NguoiDung nguoidung;
		
	public NguoiDung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}

	/*************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_MESSAGE")
	private int maMessage;
	@Column(name="NOI_DUNG")
	private String noiDung;
	@Column(name="TAC_GIA")
	private String tacGia;
	@Column(name="TEN_TAC_GIA")
	private String tenTacGia;
	@Column(name="NGAY_GUI")
	private Date thoiDiemGui;
	@Column(name="IS_READ",columnDefinition="boolean default false")
	private boolean isRead;
	
	public Message(){}

	
	

	public Message(NguoiDung nguoidung, int maMessage, String noiDung,
			String tacGia, String tenTacGia, Date thoiDiemGui, boolean isRead) {
		super();
		this.nguoidung = nguoidung;
		this.maMessage = maMessage;
		this.noiDung = noiDung;
		this.tacGia = tacGia;
		this.tenTacGia = tenTacGia;
		this.thoiDiemGui = thoiDiemGui;
		this.isRead = isRead;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public int getMaMessage() {
		return maMessage;
	}

	public void setMaMessage(int maMessage) {
		this.maMessage = maMessage;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	@Temporal(TemporalType.DATE)
	public Date getThoiDiemGui() {
		return thoiDiemGui;
	}

	public void setThoiDiemGui(Date thoiDiemGui) {
		this.thoiDiemGui = thoiDiemGui;
	}

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	
	
	
	
	
	
}
