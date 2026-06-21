package com.quangvinh.service;

import com.quangvinh.dto.response.FileDinhKemResponse;
import com.quangvinh.entity.FileDinhKem;
import com.quangvinh.entity.VanBanDen;
import com.quangvinh.exception.ResourceNotFoundException;
import com.quangvinh.repository.FileDinhKemRepository;
import com.quangvinh.repository.VanBanDenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileDinhKemService {

    private final FileDinhKemRepository fileDinhKemRepository;
    private final VanBanDenRepository vanBanDenRepository;

    @Value("${app.file-upload.dir}")
    private String uploadDir;

    public List<FileDinhKemResponse> getByVanBan(Integer maVanBan) {
        return fileDinhKemRepository.findByVanBanMaVanBan(maVanBan).stream()
                .map(this::toResponse).toList();
    }

    @Transactional
    public FileDinhKemResponse upload(Integer maVanBan, MultipartFile file) throws IOException {
        VanBanDen vanBan = vanBanDenRepository.findById(maVanBan)
                .orElseThrow(() -> new ResourceNotFoundException("VanBanDen", maVanBan));

        String originalName = file.getOriginalFilename();
        String storedName = UUID.randomUUID() + "_" + originalName;
        Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        Files.createDirectories(uploadPath);
        Files.copy(file.getInputStream(), uploadPath.resolve(storedName), StandardCopyOption.REPLACE_EXISTING);

        FileDinhKem fdk = FileDinhKem.builder()
                .tenFile(originalName)
                .duongDan(storedName)
                .kichThuoc(file.getSize())
                .loaiFile(file.getContentType())
                .vanBan(vanBan)
                .build();

        return toResponse(fileDinhKemRepository.save(fdk));
    }

    @Transactional
    public void delete(Integer maFile) {
        FileDinhKem fdk = fileDinhKemRepository.findById(maFile)
                .orElseThrow(() -> new ResourceNotFoundException("FileDinhKem", maFile));
        Path filePath = Paths.get(uploadDir).resolve(fdk.getDuongDan()).normalize();
        try { Files.deleteIfExists(filePath); } catch (IOException ignored) {}
        fileDinhKemRepository.delete(fdk);
    }

    private FileDinhKemResponse toResponse(FileDinhKem f) {
        return new FileDinhKemResponse(f.getMaFile(), f.getTenFile(),
                f.getDuongDan(), f.getKichThuoc(), f.getLoaiFile());
    }
}
