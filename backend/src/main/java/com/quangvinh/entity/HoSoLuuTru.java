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

    @Column(name = "ten_ho_so")
    private String tenHoSo;

    @Column(name = "mo_ta")
    private String moTa;
}
