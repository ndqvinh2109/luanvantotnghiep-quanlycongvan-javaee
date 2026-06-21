package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nguoidung")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class NguoiDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nguoi_dung")
    private Integer maNguoiDung;

    @Column(name = "ten_nguoi_dung")
    private String tenNguoiDung;

    @Column(name = "gioi_tinh")
    private Integer gioiTinh;

    @Column(name = "email")
    private String email;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "username", unique = true, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String passWord;

    /** macDinh maps to the "enabled" flag used by Spring Security */
    @Column(name = "mac_dinh", columnDefinition = "boolean default false")
    private boolean macDinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_don_vi")
    private DonVi donVi;

    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NguoiDungRole> nguoiDungRoles = new ArrayList<>();
}
