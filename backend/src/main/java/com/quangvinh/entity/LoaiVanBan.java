package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loaivanban")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LoaiVanBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai")
    private Integer maLoai;

    @Column(name = "ten_loai")
    private String tenLoai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_quy_trinh")
    private QuyTrinh quyTrinh;
}
