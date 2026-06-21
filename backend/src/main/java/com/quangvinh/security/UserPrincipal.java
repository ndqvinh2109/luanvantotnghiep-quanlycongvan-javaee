package com.quangvinh.security;

import com.quangvinh.entity.NguoiDung;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserPrincipal implements UserDetails {

    private final Integer id;
    private final String username;
    private final String password;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal from(NguoiDung nguoiDung) {
        List<SimpleGrantedAuthority> authorities = nguoiDung.getNguoiDungRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.getRole().getTenRoles()))
                .toList();

        return new UserPrincipal(
                nguoiDung.getMaNguoiDung(),
                nguoiDung.getUserName(),
                nguoiDung.getPassWord(),
                nguoiDung.isMacDinh(),
                authorities
        );
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked()  { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
}
