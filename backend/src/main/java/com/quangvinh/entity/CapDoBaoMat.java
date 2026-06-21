package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "capdobaomat")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CapDoBaoMat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_do_mat")
    private Integer maDoMat;

    @Column(name = "cap_do_mat")
    private String capDoMat;

    @Column(name = "ten_do_mat")
    private String tenDoMat;
}
