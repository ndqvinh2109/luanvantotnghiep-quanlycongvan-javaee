package com.quangvinh.controller;

import com.quangvinh.dto.request.NguoiDungRequest;
import com.quangvinh.dto.response.NguoiDungResponse;
import com.quangvinh.service.NguoiDungService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/nguoi-dung")
@RequiredArgsConstructor
@PreAuthorize("hasRole('QUAN_TRI_HE_THONG')")
@Tag(name = "Người dùng", description = "Quản lý người dùng (Admin only)")
public class NguoiDungController {

    private final NguoiDungService nguoiDungService;

    @GetMapping
    @Operation(summary = "Danh sách người dùng")
    public ResponseEntity<List<NguoiDungResponse>> getAll() {
        return ResponseEntity.ok(nguoiDungService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Chi tiết người dùng")
    public ResponseEntity<NguoiDungResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(nguoiDungService.getById(id));
    }

    @PostMapping
    @Operation(summary = "Thêm người dùng mới")
    public ResponseEntity<NguoiDungResponse> create(@Valid @RequestBody NguoiDungRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nguoiDungService.create(request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Xóa người dùng")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        nguoiDungService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
