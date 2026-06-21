package com.quangvinh.repository;

import com.quangvinh.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    Page<Message> findByNguoiNhanMaNguoiDungOrderByThoiGianDesc(Integer maNguoiNhan, Pageable pageable);

    Page<Message> findByNguoiDungMaNguoiDungOrderByThoiGianDesc(Integer maNguoiGui, Pageable pageable);

    long countByNguoiNhanMaNguoiDungAndDaDocFalse(Integer maNguoiNhan);
}
