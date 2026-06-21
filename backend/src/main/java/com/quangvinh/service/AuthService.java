package com.quangvinh.service;

import com.quangvinh.dto.request.LoginRequest;
import com.quangvinh.dto.response.AuthResponse;
import com.quangvinh.security.JwtTokenProvider;
import com.quangvinh.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        List<String> roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return new AuthResponse(
                tokenProvider.generateAccessToken(authentication),
                tokenProvider.generateRefreshToken(authentication),
                principal.getId(),
                principal.getUsername(),
                roles.toString(),
                roles
        );
    }
}
