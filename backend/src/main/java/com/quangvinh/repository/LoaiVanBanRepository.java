package com.quangvinh.repository;

import com.quangvinh.entity.LoaiVanBan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoaiVanBanRepository extends JpaRepository<LoaiVanBan, Integer> {
    List<LoaiVanBan> findByQuyTrinhMaQuyTrinh(Integer maQuyTrinh);
}
