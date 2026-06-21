package com.quangvinh.dto.response;

import java.util.List;

public record AuthResponse(
        String accessToken,
        String refreshToken,
        String tokenType,
        Integer userId,
        String username,
        String tenNguoiDung,
        List<String> roles
) {
    public AuthResponse(String accessToken, String refreshToken,
                        Integer userId, String username,
                        String tenNguoiDung, List<String> roles) {
        this(accessToken, refreshToken, "Bearer", userId, username, tenNguoiDung, roles);
    }
}
