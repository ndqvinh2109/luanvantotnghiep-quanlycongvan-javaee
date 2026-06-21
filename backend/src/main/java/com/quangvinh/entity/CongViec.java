package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "congviec")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CongViec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_cong_viec")
    private Integer maCongViec;

    @Column(name = "ten_cong_viec")
    private String tenCongViec;

    @Column(name = "noi_dung_cong_viec")
    private String noiDungCongViec;
}
