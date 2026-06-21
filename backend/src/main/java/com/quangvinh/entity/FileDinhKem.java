package com.quangvinh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "filedinhkem")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class FileDinhKem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_file")
    private Integer maFile;

    @Column(name = "ten_file")
    private String tenFile;

    @Column(name = "duong_dan")
    private String duongDan;

    @Column(name = "kich_thuoc")
    private Long kichThuoc;

    @Column(name = "loai_file")
    private String loaiFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_van_ban")
    private VanBan vanBan;
}
