package com.quangvinh.dto.response;

public record FileDinhKemResponse(
        Integer maFile,
        String tenFile,
        String duongDan,
        Long kichThuoc,
        String kieuTapTin
) {}
