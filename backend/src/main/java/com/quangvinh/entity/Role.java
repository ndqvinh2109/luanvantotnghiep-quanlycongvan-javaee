package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_roles")
    private Integer maRoles;

    @Column(name = "ten_roles")
    private String tenRoles;

    @Column(name = "ten_roles_chi_tiet")
    private String tenRolesChiTiet;
}
