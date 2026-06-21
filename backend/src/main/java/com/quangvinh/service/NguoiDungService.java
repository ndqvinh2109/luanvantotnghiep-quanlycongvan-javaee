package com.quangvinh.service;

import com.quangvinh.dto.request.NguoiDungRequest;
import com.quangvinh.dto.response.NguoiDungResponse;
import com.quangvinh.dto.response.RefResponse;
import com.quangvinh.entity.*;
import com.quangvinh.exception.ApiException;
import com.quangvinh.exception.ResourceNotFoundException;
import com.quangvinh.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NguoiDungService {

    private final NguoiDungRepository nguoiDungRepository;
    private final DonViRepository donViRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public List<NguoiDungResponse> getAll() {
        return nguoiDungRepository.findAll().stream().map(this::toResponse).toList();
    }

    public NguoiDungResponse getById(Integer id) {
        return toResponse(findOrThrow(id));
    }

    @Transactional
    public NguoiDungResponse create(NguoiDungRequest req) {
        if (nguoiDungRepository.existsByUserName(req.userName())) {
            throw new ApiException(HttpStatus.CONFLICT, "Tên đăng nhập đã tồn tại: " + req.userName());
        }
        if (req.email() != null && nguoiDungRepository.existsByEmail(req.email())) {
            throw new ApiException(HttpStatus.CONFLICT, "Email đã được sử dụng: " + req.email());
        }

        DonVi donVi = donViRepository.findById(req.maDonVi())
                .orElseThrow(() -> new ResourceNotFoundException("DonVi", req.maDonVi()));

        NguoiDung nd = NguoiDung.builder()
                .tenNguoiDung(req.tenNguoiDung())
                .gioiTinh(req.gioiTinh())
                .email(req.email())
                .diaChi(req.diaChi())
                .soDienThoai(req.soDienThoai())
                .userName(req.userName())
                .passWord(passwordEncoder.encode(req.passWord()))
                .macDinh(true)
                .donVi(donVi)
                .build();

        NguoiDung saved = nguoiDungRepository.save(nd);

        req.maRolesList().forEach(maRole -> {
            Role role = roleRepository.findById(maRole)
                    .orElseThrow(() -> new ResourceNotFoundException("Role", maRole));
            NguoiDungRole ndr = new NguoiDungRole();
            ndr.setId(new NguoiDungRole.NguoiDungRoleId(saved.getMaNguoiDung(), role.getMaRoles()));
            ndr.setNguoiDung(saved);
            ndr.setRole(role);
            saved.getNguoiDungRoles().add(ndr);
        });

        return toResponse(nguoiDungRepository.save(saved));
    }

    @Transactional
    public void delete(Integer id) {
        if (!nguoiDungRepository.existsById(id)) {
            throw new ResourceNotFoundException("NguoiDung", id);
        }
        nguoiDungRepository.deleteById(id);
    }

    private NguoiDung findOrThrow(Integer id) {
        return nguoiDungRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NguoiDung", id));
    }

    private NguoiDungResponse toResponse(NguoiDung nd) {
        List<RefResponse> roles = nd.getNguoiDungRoles().stream()
                .map(r -> new RefResponse(r.getRole().getMaRoles(), r.getRole().getTenRoles()))
                .toList();
        RefResponse donViRef = nd.getDonVi() == null ? null
                : new RefResponse(nd.getDonVi().getMaDonVi(), nd.getDonVi().getTenDonVi());
        return new NguoiDungResponse(
                nd.getMaNguoiDung(), nd.getTenNguoiDung(), nd.getGioiTinh(),
                nd.getEmail(), nd.getDiaChi(), nd.getSoDienThoai(),
                nd.getUserName(), nd.isMacDinh(), donViRef, roles
        );
    }
}
