package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vitriluutru")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ViTriLuuTru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stt")
    private Integer stt;

    @Column(name = "ten_vi_tri")
    private String tenViTri;

    @Column(name = "mo_ta")
    private String moTa;
}
