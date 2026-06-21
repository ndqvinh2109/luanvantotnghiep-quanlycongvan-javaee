package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vanban")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter @NoArgsConstructor
public abstract class VanBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_van_ban")
    private Integer maVanBan;

    @Column(name = "ky_hieu")
    private String soKyHieuVanBan;

    @Column(name = "ngay_ban_hanh")
    private LocalDate ngayBanHanh;

    @Column(name = "ngay_hieu_luc")
    private LocalDate ngayHieuLuc;

    @Column(name = "ngay_het_hieu_luc")
    private LocalDate ngayHetHieuLuc;

    @Column(name = "trich_yeu", columnDefinition = "TEXT")
    private String trichYeu;

    @Column(name = "nguoi_ky")
    private String nguoiKy;

    @Column(name = "so_trang")
    private Integer soTrang;

    @Column(name = "tu_khoa")
    private String tuKhoa;

    @Column(name = "ngay_nhap_may")
    private LocalDate ngayNhapMay;

    @Column(name = "trang_thai_xu_ly")
    private Integer trangThaiXuLy;

    @Column(name = "enabled", columnDefinition = "boolean default false")
    private boolean enabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_do_mat")
    private CapDoBaoMat capDoBaoMat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_linh_vuc")
    private LinhVuc linhVuc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_loai")
    private LoaiVanBan loaiVanBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_do_khan")
    private CapDoKhan capDoKhan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stt")
    private ViTriLuuTru viTriLuuTru;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "so_ho_so")
    private HoSoLuuTru hoSoLuuTru;

    @OneToMany(mappedBy = "vanBan", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileDinhKem> fileDinhKems = new ArrayList<>();

    @OneToMany(mappedBy = "vanBan", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "vanBan", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BuocXuLyPheDuyetVanBan> buocXuLys = new ArrayList<>();
}
