package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "capdokhan")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CapDoKhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_do_khan")
    private Integer maDoKhan;

    @Column(name = "gia_tri_cap_do")
    private Integer giaTriCapDo;

    @Column(name = "ten_do_khan")
    private String tenDoKhan;
}
