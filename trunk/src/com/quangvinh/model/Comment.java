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
@Table(name="COMMENT")
public class Comment {
	/***********************************************/
	@ManyToOne
	@JoinColumn(name="MA_VAN_BAN")
	private VanBan vanban;
	
	public VanBan getVanban() {
		return vanban;
	}
	public void setVanban(VanBan vanban) {
		this.vanban = vanban;
	}
	/***********************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MA_COMMENT")
	private int maComment;
	@Column(name="NOI_DUNG")
	private String noiDung;
	@Column(name="TAC_GIA")
	private String tacGia;
	@Column(name="NGAY_GUI")
	private Date ngayGui;
	
	@Column(name="USERNAME")
	private String userName;
	
	public Comment(){}
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Comment(VanBan vanban, int maComment, String noiDung, String tacGia,
			Date ngayGui, String userName) {
		super();
		this.vanban = vanban;
		this.maComment = maComment;
		this.noiDung = noiDung;
		this.tacGia = tacGia;
		this.ngayGui = ngayGui;
		this.userName = userName;
	}
	public int getMaComment() {
		return maComment;
	}
	public void setMaComment(int maComment) {
		this.maComment = maComment;
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
	public Date getNgayGui() {
		return ngayGui;
	}
	public void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}
	
}
