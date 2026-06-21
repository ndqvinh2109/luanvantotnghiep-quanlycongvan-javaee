package com.quangvinh.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record VanBanDenRequest(
        @NotBlank(message = "Số ký hiệu không được trống")
        String soKyHieuVanBan,

        @NotNull(message = "Ngày ban hành không được trống")
        LocalDate ngayBanHanh,

        LocalDate ngayHieuLuc,
        LocalDate ngayHetHieuLuc,

        @NotBlank(message = "Trích yếu không được trống")
        String trichYeu,

        String nguoiKy,
        Integer soTrang,
        String tuKhoa,

        @NotNull(message = "Ngày đến không được trống")
        LocalDate ngayDen,

        Integer soDen,

        @NotNull(message = "Đơn vị không được trống")
        Integer maDonVi,

        Integer maLoai,
        Integer maDoKhan,
        Integer maDoMat,
        Integer maLinhVuc
) {}
