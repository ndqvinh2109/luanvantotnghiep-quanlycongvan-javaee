package com.quangvinh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VANBANDI_DONVI")
public class VanBanDi_DonVi {

	/**
	 *   Many to Many Van Ban Di and Don Vi
	 */
	
		@ManyToOne
		@JoinColumn(name="MA_VAN_BAN")
		private VanBanDi vanbandi;

		public VanBanDi getVanbandi() {
			return vanbandi;
		}
	
		public void setVanbandi(VanBanDi vanbandi) {
			this.vanbandi = vanbandi;
		}
	
		@ManyToOne
		@JoinColumn(name="MA_DON_VI")
		private DonVi donvi;

		public DonVi getDonvi() {
			return donvi;
		}

		public void setDonvi(DonVi donvi) {
			this.donvi = donvi;
		}
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="MAVANBANDI_DONVI")
		private int maVanBanDi_DonVi;

		public int getMaVanBanDi_DonVi() {
			return maVanBanDi_DonVi;
		}

		public void setMaVanBanDi_DonVi(int maVanBanDi_DonVi) {
			this.maVanBanDi_DonVi = maVanBanDi_DonVi;
		}
		
		
		
	

	
	
	
	
	/**
	 *  The End
	 */
		
}
