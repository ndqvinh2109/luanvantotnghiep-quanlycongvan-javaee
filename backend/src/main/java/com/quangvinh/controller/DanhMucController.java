package com.quangvinh.controller;

import com.quangvinh.entity.*;
import com.quangvinh.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/danh-muc")
@RequiredArgsConstructor
@Tag(name = "Danh mục", description = "Các danh mục dùng chung (loại văn bản, cấp độ khẩn, ...)")
public class DanhMucController {

    private final LoaiVanBanRepository loaiVanBanRepository;
    private final CapDoKhanRepository capDoKhanRepository;
    private final CapDoBaoMatRepository capDoBaoMatRepository;
    private final LinhVucRepository linhVucRepository;
    private final DonViRepository donViRepository;
    private final RoleRepository roleRepository;

    @GetMapping("/loai-van-ban")
    @Operation(summary = "Danh sách loại văn bản")
    public ResponseEntity<List<LoaiVanBan>> getLoaiVanBan() {
        return ResponseEntity.ok(loaiVanBanRepository.findAll());
    }

    @GetMapping("/cap-do-khan")
    @Operation(summary = "Danh sách cấp độ khẩn")
    public ResponseEntity<List<CapDoKhan>> getCapDoKhan() {
        return ResponseEntity.ok(capDoKhanRepository.findAll());
    }

    @GetMapping("/cap-do-bao-mat")
    @Operation(summary = "Danh sách cấp độ bảo mật")
    public ResponseEntity<List<CapDoBaoMat>> getCapDoBaoMat() {
        return ResponseEntity.ok(capDoBaoMatRepository.findAll());
    }

    @GetMapping("/linh-vuc")
    @Operation(summary = "Danh sách lĩnh vực")
    public ResponseEntity<List<LinhVuc>> getLinhVuc() {
        return ResponseEntity.ok(linhVucRepository.findAll());
    }

    @GetMapping("/don-vi")
    @Operation(summary = "Danh sách đơn vị (cây tổ chức)")
    public ResponseEntity<List<DonVi>> getDonVi() {
        return ResponseEntity.ok(donViRepository.findAll());
    }

    @GetMapping("/roles")
    @Operation(summary = "Danh sách vai trò")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(roleRepository.findAll());
    }
}
