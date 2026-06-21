package com.quangvinh.dto.response;

import java.util.List;

public record NguoiDungResponse(
        Integer maNguoiDung,
        String tenNguoiDung,
        Integer gioiTinh,
        String email,
        String diaChi,
        String soDienThoai,
        String userName,
        boolean macDinh,
        RefResponse donVi,
        List<RefResponse> roles
) {}
