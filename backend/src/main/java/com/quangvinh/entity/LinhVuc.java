package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "linhvuc")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LinhVuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_linh_vuc")
    private Integer maLinhVuc;

    @Column(name = "ten_linh_vuc")
    private String tenLinhVuc;
}
