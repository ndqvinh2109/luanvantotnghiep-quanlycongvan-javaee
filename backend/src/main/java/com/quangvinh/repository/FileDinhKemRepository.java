package com.quangvinh.repository;

import com.quangvinh.entity.FileDinhKem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileDinhKemRepository extends JpaRepository<FileDinhKem, Integer> {
    List<FileDinhKem> findByVanBanMaVanBan(Integer maVanBan);
}
