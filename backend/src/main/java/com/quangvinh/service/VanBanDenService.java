package com.quangvinh.service;

import com.quangvinh.dto.request.VanBanDenRequest;
import com.quangvinh.dto.response.FileDinhKemResponse;
import com.quangvinh.dto.response.PageResponse;
import com.quangvinh.dto.response.RefResponse;
import com.quangvinh.dto.response.VanBanDenResponse;
import com.quangvinh.entity.*;
import com.quangvinh.exception.ResourceNotFoundException;
import com.quangvinh.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VanBanDenService {

    private final VanBanDenRepository vanBanDenRepository;
    private final DonViRepository donViRepository;
    private final LoaiVanBanRepository loaiVanBanRepository;
    private final CapDoKhanRepository capDoKhanRepository;
    private final CapDoBaoMatRepository capDoBaoMatRepository;
    private final LinhVucRepository linhVucRepository;

    public PageResponse<VanBanDenResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return PageResponse.from(
                vanBanDenRepository.findAllByOrderByNgayDenDesc(pageable).map(this::toResponse)
        );
    }

    public PageResponse<VanBanDenResponse> search(String tuKhoa, Integer maLoai, Integer maDonVi,
                                                   LocalDate tuNgay, LocalDate denNgay,
                                                   int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return PageResponse.from(
                vanBanDenRepository.search(tuKhoa, maLoai, maDonVi, tuNgay, denNgay, pageable)
                        .map(this::toResponse)
        );
    }

    public VanBanDenResponse getById(Integer id) {
        return toResponse(findOrThrow(id));
    }

    @Transactional
    public VanBanDenResponse create(VanBanDenRequest req) {
        VanBanDen vanBan = new VanBanDen();
        applyRequest(vanBan, req);
        vanBan.setNgayNhapMay(LocalDate.now());
        vanBan.setTrangThaiXuLy(0);
        return toResponse(vanBanDenRepository.save(vanBan));
    }

    @Transactional
    public VanBanDenResponse update(Integer id, VanBanDenRequest req) {
        VanBanDen vanBan = findOrThrow(id);
        applyRequest(vanBan, req);
        return toResponse(vanBanDenRepository.save(vanBan));
    }

    @Transactional
    public void delete(Integer id) {
        if (!vanBanDenRepository.existsById(id)) {
            throw new ResourceNotFoundException("VanBanDen", id);
        }
        vanBanDenRepository.deleteById(id);
    }

    private void applyRequest(VanBanDen v, VanBanDenRequest req) {
        v.setSoKyHieuVanBan(req.soKyHieuVanBan());
        v.setNgayBanHanh(req.ngayBanHanh());
        v.setNgayHieuLuc(req.ngayHieuLuc());
        v.setNgayHetHieuLuc(req.ngayHetHieuLuc());
        v.setTrichYeu(req.trichYeu());
        v.setNguoiKy(req.nguoiKy());
        v.setSoTrang(req.soTrang());
        v.setTuKhoa(req.tuKhoa());
        v.setSoDen(req.soDen());
        v.setNgayDen(req.ngayDen());
        v.setDonVi(donViRepository.findById(req.maDonVi())
                .orElseThrow(() -> new ResourceNotFoundException("DonVi", req.maDonVi())));
        if (req.maLoai() != null) {
            v.setLoaiVanBan(loaiVanBanRepository.findById(req.maLoai())
                    .orElseThrow(() -> new ResourceNotFoundException("LoaiVanBan", req.maLoai())));
        }
        if (req.maDoKhan() != null) {
            v.setCapDoKhan(capDoKhanRepository.findById(req.maDoKhan())
                    .orElseThrow(() -> new ResourceNotFoundException("CapDoKhan", req.maDoKhan())));
        }
        if (req.maDoMat() != null) {
            v.setCapDoBaoMat(capDoBaoMatRepository.findById(req.maDoMat())
                    .orElseThrow(() -> new ResourceNotFoundException("CapDoBaoMat", req.maDoMat())));
        }
        if (req.maLinhVuc() != null) {
            v.setLinhVuc(linhVucRepository.findById(req.maLinhVuc())
                    .orElseThrow(() -> new ResourceNotFoundException("LinhVuc", req.maLinhVuc())));
        }
    }

    private VanBanDen findOrThrow(Integer id) {
        return vanBanDenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VanBanDen", id));
    }

    private VanBanDenResponse toResponse(VanBanDen v) {
        return new VanBanDenResponse(
                v.getMaVanBan(), v.getSoKyHieuVanBan(), v.getNgayBanHanh(),
                v.getNgayHieuLuc(), v.getNgayHetHieuLuc(), v.getTrichYeu(),
                v.getNguoiKy(), v.getSoTrang(), v.getTuKhoa(), v.getNgayNhapMay(),
                v.getTrangThaiXuLy(), v.isEnabled(),
                v.getSoDen(), v.getNgayDen(),
                toRef(v.getDonVi()),
                toRef(v.getLoaiVanBan()),
                toRef(v.getCapDoKhan()),
                toRef(v.getCapDoBaoMat()),
                toRef(v.getLinhVuc()),
                v.getFileDinhKems().stream().map(f ->
                        new FileDinhKemResponse(f.getMaFile(), f.getTenFile(),
                                f.getDuongDan(), f.getKichThuoc(), f.getKieuTapTin())
                ).toList()
        );
    }

    private RefResponse toRef(DonVi d) {
        return d == null ? null : new RefResponse(d.getMaDonVi(), d.getTenDonVi());
    }
    private RefResponse toRef(LoaiVanBan l) {
        return l == null ? null : new RefResponse(l.getMaLoai(), l.getTenLoai());
    }
    private RefResponse toRef(CapDoKhan c) {
        return c == null ? null : new RefResponse(c.getMaDoKhan(), c.getTenDoKhan());
    }
    private RefResponse toRef(CapDoBaoMat c) {
        return c == null ? null : new RefResponse(c.getMaDoMat(), c.getTenDoMat());
    }
    private RefResponse toRef(LinhVuc l) {
        return l == null ? null : new RefResponse(l.getMaLinhVuc(), l.getTenLinhVuc());
    }
}
