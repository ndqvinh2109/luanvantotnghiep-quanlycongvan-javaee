package com.quangvinh.repository;

import com.quangvinh.entity.DonVi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonViRepository extends JpaRepository<DonVi, Integer> {

    @Query("SELECT d FROM DonVi d WHERE d.donViTrucThuoc IS NULL ORDER BY d.tenDonVi")
    List<DonVi> findRootDonVis();

    List<DonVi> findByDonViTrucThuocMaDonVi(Integer maDonViCha);
}
