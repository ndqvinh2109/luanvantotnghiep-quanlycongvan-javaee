package com.quangvinh.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record VanBanDiRequest(
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
        LocalDate ngayDi,
        Integer soDi,

        @NotEmpty(message = "Phải chọn ít nhất một đơn vị nhận")
        List<Integer> maDonViList,

        Integer maLoai,
        Integer maDoKhan,
        Integer maDoMat,
        Integer maLinhVuc
) {}
