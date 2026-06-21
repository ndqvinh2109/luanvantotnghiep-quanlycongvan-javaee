package com.quangvinh.repository;

import com.quangvinh.entity.VanBanDi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface VanBanDiRepository extends JpaRepository<VanBanDi, Integer> {

    Page<VanBanDi> findAllByOrderByNgayDiDesc(Pageable pageable);

    @Query("""
            SELECT v FROM VanBanDi v
            WHERE (:tuKhoa IS NULL OR LOWER(v.trichYeu) LIKE LOWER(CONCAT('%', :tuKhoa, '%'))
                OR LOWER(v.soKyHieuVanBan) LIKE LOWER(CONCAT('%', :tuKhoa, '%')))
            AND (:maLoai IS NULL OR v.loaiVanBan.maLoai = :maLoai)
            AND (:tuNgay IS NULL OR v.ngayDi >= :tuNgay)
            AND (:denNgay IS NULL OR v.ngayDi <= :denNgay)
            ORDER BY v.ngayDi DESC
            """)
    Page<VanBanDi> search(@Param("tuKhoa") String tuKhoa,
                          @Param("maLoai") Integer maLoai,
                          @Param("tuNgay") LocalDate tuNgay,
                          @Param("denNgay") LocalDate denNgay,
                          Pageable pageable);
}
