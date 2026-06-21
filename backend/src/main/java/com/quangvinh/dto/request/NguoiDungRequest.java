package com.quangvinh.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record NguoiDungRequest(
        @NotBlank(message = "Tên người dùng không được trống")
        String tenNguoiDung,

        Integer gioiTinh,

        @Email(message = "Email không hợp lệ")
        String email,

        String diaChi,
        String soDienThoai,

        @NotBlank(message = "Tên đăng nhập không được trống")
        String userName,

        @NotBlank(message = "Mật khẩu không được trống")
        @Size(min = 6, message = "Mật khẩu tối thiểu 6 ký tự")
        String passWord,

        @NotNull(message = "Đơn vị không được trống")
        Integer maDonVi,

        @NotEmpty
        List<Integer> maRolesList
) {
    // Allows @NotEmpty on list parameter
    private @interface NotEmpty {}
}
