package com.quangvinh.controller;

import com.quangvinh.dto.request.VanBanDenRequest;
import com.quangvinh.dto.response.PageResponse;
import com.quangvinh.dto.response.VanBanDenResponse;
import com.quangvinh.service.VanBanDenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/van-ban-den")
@RequiredArgsConstructor
@Tag(name = "Văn bản đến", description = "Quản lý văn bản đến")
public class VanBanDenController {

    private final VanBanDenService vanBanDenService;

    @GetMapping
    @Operation(summary = "Danh sách văn bản đến (có phân trang)")
    public ResponseEntity<PageResponse<VanBanDenResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(vanBanDenService.getAll(page, size));
    }

    @GetMapping("/search")
    @Operation(summary = "Tìm kiếm văn bản đến")
    public ResponseEntity<PageResponse<VanBanDenResponse>> search(
            @RequestParam(required = false) String tuKhoa,
            @RequestParam(required = false) Integer maLoai,
            @RequestParam(required = false) Integer maDonVi,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate tuNgay,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate denNgay,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(vanBanDenService.search(tuKhoa, maLoai, maDonVi, tuNgay, denNgay, page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Chi tiết văn bản đến")
    public ResponseEntity<VanBanDenResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(vanBanDenService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('VAN_THU')")
    @Operation(summary = "Nhập văn bản đến mới")
    public ResponseEntity<VanBanDenResponse> create(@Valid @RequestBody VanBanDenRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vanBanDenService.create(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('VAN_THU')")
    @Operation(summary = "Cập nhật văn bản đến")
    public ResponseEntity<VanBanDenResponse> update(@PathVariable Integer id,
                                                    @Valid @RequestBody VanBanDenRequest request) {
        return ResponseEntity.ok(vanBanDenService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('VAN_THU')")
    @Operation(summary = "Xóa văn bản đến")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        vanBanDenService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
