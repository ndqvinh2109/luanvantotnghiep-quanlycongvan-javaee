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

    @Column(name = "vi_tri")
    private String viTri;
}
