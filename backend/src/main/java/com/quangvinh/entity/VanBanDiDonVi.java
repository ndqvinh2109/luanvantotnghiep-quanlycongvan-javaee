package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "vanbandi_donvi")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VanBanDiDonVi {

    @Embeddable
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class VanBanDiDonViId implements Serializable {
        @Column(name = "ma_van_ban")
        private Integer maVanBan;
        @Column(name = "ma_don_vi")
        private Integer maDonVi;
    }

    @EmbeddedId
    private VanBanDiDonViId id = new VanBanDiDonViId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maVanBan")
    @JoinColumn(name = "ma_van_ban")
    private VanBanDi vanBanDi;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maDonVi")
    @JoinColumn(name = "ma_don_vi")
    private DonVi donVi;
}
