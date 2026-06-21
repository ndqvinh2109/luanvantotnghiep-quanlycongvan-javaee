package com.quangvinh.controller;

import com.quangvinh.dto.response.FileDinhKemResponse;
import com.quangvinh.service.FileDinhKemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
@Tag(name = "File đính kèm", description = "Upload và download file đính kèm")
public class FileDinhKemController {

    private final FileDinhKemService fileDinhKemService;

    @GetMapping("/van-ban/{maVanBan}")
    @Operation(summary = "Danh sách file đính kèm của văn bản")
    public ResponseEntity<List<FileDinhKemResponse>> getByVanBan(@PathVariable Integer maVanBan) {
        return ResponseEntity.ok(fileDinhKemService.getByVanBan(maVanBan));
    }

    @PostMapping("/van-ban/{maVanBan}")
    @PreAuthorize("hasAnyRole('VAN_THU', 'XU_LY', 'LANH_DAO')")
    @Operation(summary = "Upload file đính kèm")
    public ResponseEntity<FileDinhKemResponse> upload(@PathVariable Integer maVanBan,
                                                      @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(fileDinhKemService.upload(maVanBan, file));
    }

    @DeleteMapping("/{maFile}")
    @PreAuthorize("hasRole('VAN_THU')")
    @Operation(summary = "Xóa file đính kèm")
    public ResponseEntity<Void> delete(@PathVariable Integer maFile) {
        fileDinhKemService.delete(maFile);
        return ResponseEntity.noContent().build();
    }
}
