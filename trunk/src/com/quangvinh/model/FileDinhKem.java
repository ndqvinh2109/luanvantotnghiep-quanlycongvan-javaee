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
@Table(name="FILEDINHKEM")
public class FileDinhKem {
	/***********************************************/
	@JsonIgnore
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
	@Column(name="MA_FILE")
	private int maFile;
	@Column(name="TEN_FILE")
	private String tenFile;
	@Column(name="MO_TA")
	private String moTa;
	@Column(name="NOI_DUNG")
	private byte[] noiDung;
	@Column(name="KIEU_TAP_TIN")
    private String kieuTapTin;
    
    
	public FileDinhKem(){}
	
	
	public FileDinhKem(VanBan vanban, int maFile, String tenFile, String moTa,
			byte[] noiDung, String kieuTapTin) {
		super();
		this.vanban = vanban;
		this.maFile = maFile;
		this.tenFile = tenFile;
		this.moTa = moTa;
		this.noiDung = noiDung;
		this.kieuTapTin = kieuTapTin;
	}
	public int getMaFile() {
		return maFile;
	}
	public void setMaFile(int maFile) {
		this.maFile = maFile;
	}
	public String getTenFile() {
		return tenFile;
	}
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public byte[] getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(byte[] noiDung) {
		this.noiDung = noiDung;
	}
	public String getKieuTapTin() {
		return kieuTapTin;
	}
	public void setKieuTapTin(String kieuTapTin) {
		this.kieuTapTin = kieuTapTin;
	}
	
	
	
	
	
	
}
