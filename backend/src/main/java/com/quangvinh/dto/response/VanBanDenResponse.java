package com.quangvinh.dto.response;

import java.time.LocalDate;
import java.util.List;

public record VanBanDenResponse(
        Integer maVanBan,
        String soKyHieuVanBan,
        LocalDate ngayBanHanh,
        LocalDate ngayHieuLuc,
        LocalDate ngayHetHieuLuc,
        String trichYeu,
        String nguoiKy,
        Integer soTrang,
        String tuKhoa,
        LocalDate ngayNhapMay,
        Integer trangThaiXuLy,
        boolean enabled,
        Integer soDen,
        LocalDate ngayDen,
        RefResponse donVi,
        RefResponse loaiVanBan,
        RefResponse capDoKhan,
        RefResponse capDoBaoMat,
        RefResponse linhVuc,
        List<FileDinhKemResponse> fileDinhKems
) {}
