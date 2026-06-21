package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "buocxulypheduyetvanban")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BuocXuLyPheDuyetVanBan {

    @Embeddable
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class BuocXuLyId implements Serializable {
        @Column(name = "so_thu_tu")
        private Integer soThuTu;
        @Column(name = "ma_quy_trinh")
        private Integer maQuyTrinh;
        @Column(name = "ma_van_ban")
        private Integer maVanBan;
    }

    @EmbeddedId
    private BuocXuLyId id = new BuocXuLyId();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ma_quy_trinh", insertable = false, updatable = false),
            @JoinColumn(name = "so_thu_tu",    insertable = false, updatable = false)
    })
    private Buoc buoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_van_ban", insertable = false, updatable = false)
    private VanBan vanBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_nguoi_dung")
    private NguoiDung nguoiDung;

    @Column(name = "noi_dung_xu_ly", columnDefinition = "TEXT")
    private String noiDungXuLy;

    @Column(name = "thoi_gian_bd")
    private LocalDate thoiGianBatDau;

    @Column(name = "thoi_gian_kt")
    private LocalDate thoiGianHoanThanh;

    @Column(name = "thoi_gian_xu_ly")
    private LocalDate thoiGianXuLy;

    @Column(name = "value_xu_ly", columnDefinition = "boolean default false")
    private boolean valueXuLy;

    @Column(name = "value_chuyen", columnDefinition = "boolean default false")
    private boolean valueChuyen;
}
