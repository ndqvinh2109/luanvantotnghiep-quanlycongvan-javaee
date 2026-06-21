package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vanbandi")
@PrimaryKeyJoinColumn(name = "ma_van_ban")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VanBanDi extends VanBan {

    @Column(name = "so_di")
    private Integer soDi;

    @Column(name = "ngay_di")
    private LocalDate ngayDi;

    @OneToMany(mappedBy = "vanBanDi", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VanBanDiDonVi> vanBanDiDonVis = new ArrayList<>();
}
