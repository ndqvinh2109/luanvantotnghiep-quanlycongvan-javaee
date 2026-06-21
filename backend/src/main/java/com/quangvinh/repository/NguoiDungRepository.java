package com.quangvinh.repository;

import com.quangvinh.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {

    Optional<NguoiDung> findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

    @Query("SELECT nd FROM NguoiDung nd JOIN nd.nguoiDungRoles ndr WHERE ndr.role.tenRoles = :roleName")
    List<NguoiDung> findByRoleName(String roleName);

    @Query("SELECT nd FROM NguoiDung nd WHERE nd.donVi.maDonVi = :maDonVi")
    List<NguoiDung> findByDonVi(Integer maDonVi);
}
