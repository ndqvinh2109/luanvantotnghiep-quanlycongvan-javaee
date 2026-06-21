package com.quangvinh.dto.response;

import java.time.LocalDate;
import java.util.List;

public record VanBanDiResponse(
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
        Integer soDi,
        LocalDate ngayDi,
        RefResponse loaiVanBan,
        RefResponse capDoKhan,
        RefResponse capDoBaoMat,
        RefResponse linhVuc,
        List<RefResponse> donViNhanList,
        List<FileDinhKemResponse> fileDinhKems
) {}
