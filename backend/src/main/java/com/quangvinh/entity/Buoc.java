package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buoc")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Buoc {

    @Embeddable
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class BuocId implements Serializable {
        @Column(name = "so_thu_tu")
        private Integer soThuTu;
        @Column(name = "ma_quy_trinh")
        private Integer maQuyTrinh;
    }

    @EmbeddedId
    private BuocId id = new BuocId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maQuyTrinh")
    @JoinColumn(name = "ma_quy_trinh")
    private QuyTrinh quyTrinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_cong_viec")
    private CongViec congViec;

    @Column(name = "so_ngay")
    private Integer soNgay;

    @OneToMany(mappedBy = "buoc", fetch = FetchType.LAZY)
    private List<BuocXuLyPheDuyetVanBan> buocXuLys = new ArrayList<>();
}
