package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quytrinh")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class QuyTrinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_quy_trinh")
    private Integer maQuyTrinh;

    @Column(name = "mo_ta")
    private String moTa;

    @OneToMany(mappedBy = "quyTrinh", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Buoc> buocs = new ArrayList<>();

    @OneToMany(mappedBy = "quyTrinh", fetch = FetchType.LAZY)
    private List<LoaiVanBan> loaiVanBans = new ArrayList<>();
}
