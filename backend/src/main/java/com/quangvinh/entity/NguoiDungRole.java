package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "nguoidung_roles")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NguoiDungRole {

    @Embeddable
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class NguoiDungRoleId implements Serializable {
        @Column(name = "ma_nguoi_dung")
        private Integer maNguoiDung;
        @Column(name = "ma_roles")
        private Integer maRoles;
    }

    @EmbeddedId
    private NguoiDungRoleId id = new NguoiDungRoleId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maNguoiDung")
    @JoinColumn(name = "ma_nguoi_dung")
    private NguoiDung nguoiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("maRoles")
    @JoinColumn(name = "ma_roles")
    private Role role;
}
