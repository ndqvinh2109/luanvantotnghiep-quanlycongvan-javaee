package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hosoluutru")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class HoSoLuuTru {

    @Id
    @Column(name = "so_ho_so")
    private Integer soHoSo;

    @Column(name = "ma_ho_so")
    private String maHoSo;

    @Column(name = "tieu_de_ho_so")
    private String tieuDeHoSo;

    @Column(name = "thoi_gian_bao_quan")
    private Integer thoiGianBaoQuan;

    @Column(name = "thoi_gian_bd")
    private java.time.LocalDate thoiGianBd;

    @Column(name = "thoi_gian_ket_thuc")
    private java.time.LocalDate thoiGianKetThuc;
}
