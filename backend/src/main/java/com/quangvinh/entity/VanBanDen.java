package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vanbanden")
@PrimaryKeyJoinColumn(name = "ma_van_ban")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VanBanDen extends VanBan {

    @Column(name = "so_den")
    private Integer soDen;

    @Column(name = "ngay_den")
    private LocalDate ngayDen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_don_vi")
    private DonVi donVi;
}
