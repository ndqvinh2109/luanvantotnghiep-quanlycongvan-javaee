package com.quangvinh.repository;

import com.quangvinh.entity.VanBanDen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VanBanDenRepository extends JpaRepository<VanBanDen, Integer> {

    Page<VanBanDen> findAllByOrderByNgayDenDesc(Pageable pageable);

    @Query("""
            SELECT v FROM VanBanDen v
            WHERE (:tuKhoa IS NULL OR LOWER(v.trichYeu) LIKE LOWER(CONCAT('%', :tuKhoa, '%'))
                OR LOWER(v.soKyHieuVanBan) LIKE LOWER(CONCAT('%', :tuKhoa, '%')))
            AND (:maLoai IS NULL OR v.loaiVanBan.maLoai = :maLoai)
            AND (:maDonVi IS NULL OR v.donVi.maDonVi = :maDonVi)
            AND (:tuNgay IS NULL OR v.ngayDen >= :tuNgay)
            AND (:denNgay IS NULL OR v.ngayDen <= :denNgay)
            ORDER BY v.ngayDen DESC
            """)
    Page<VanBanDen> search(@Param("tuKhoa") String tuKhoa,
                           @Param("maLoai") Integer maLoai,
                           @Param("maDonVi") Integer maDonVi,
                           @Param("tuNgay") LocalDate tuNgay,
                           @Param("denNgay") LocalDate denNgay,
                           Pageable pageable);

    @Query("SELECT v FROM VanBanDen v WHERE v.trangThaiXuLy = :trangThai ORDER BY v.ngayDen DESC")
    List<VanBanDen> findByTrangThaiXuLy(@Param("trangThai") Integer trangThai);

    @Query("""
            SELECT COUNT(v) FROM VanBanDen v
            WHERE v.ngayDen BETWEEN :tuNgay AND :denNgay
            """)
    Long countByDateRange(@Param("tuNgay") LocalDate tuNgay, @Param("denNgay") LocalDate denNgay);
}
