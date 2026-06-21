package com.quangvinh.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Tên đăng nhập không được trống") String username,
        @NotBlank(message = "Mật khẩu không được trống")     String password
) {}
