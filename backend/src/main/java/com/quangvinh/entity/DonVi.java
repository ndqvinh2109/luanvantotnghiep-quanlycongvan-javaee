package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donvi")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DonVi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_don_vi")
    private Integer maDonVi;

    @Column(name = "ten_don_vi")
    private String tenDonVi;

    @Column(name = "kieu_don_vi")
    private Integer kieuDonVi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donvitructhuoc")
    private DonVi donViTrucThuoc;

    @OneToMany(mappedBy = "donViTrucThuoc", fetch = FetchType.LAZY)
    private List<DonVi> donViConList = new ArrayList<>();
}
