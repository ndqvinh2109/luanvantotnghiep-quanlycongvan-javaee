-- ============================================================
-- V2: Seed data — sourced from sql/data.sql (legacy system)
-- Passwords converted from SHA-1 → BCrypt (cost 10):
--   ndqvinh  original "admin"  → BCrypt below
--   all others original "123456" → BCrypt below
-- Binary filedinhkem blobs are omitted (file-path storage used).
-- ============================================================

-- capdobaomat
INSERT INTO capdobaomat (ma_do_mat, cap_do_mat, ten_do_mat) VALUES (1, 'binh thuong', 'Bình thường');
INSERT INTO capdobaomat (ma_do_mat, cap_do_mat, ten_do_mat) VALUES (2, 'mat', 'Mật');
INSERT INTO capdobaomat (ma_do_mat, cap_do_mat, ten_do_mat) VALUES (3, 'toi mat', 'Tối mật');
INSERT INTO capdobaomat (ma_do_mat, cap_do_mat, ten_do_mat) VALUES (4, 'tuyet mat', 'Tuyệt mật');

-- capdokhan
INSERT INTO capdokhan (ma_do_khan, gia_tri_cap_do, ten_do_khan) VALUES (1, 1, 'Bình thường');
INSERT INTO capdokhan (ma_do_khan, gia_tri_cap_do, ten_do_khan) VALUES (2, 2, 'Khẩn');
INSERT INTO capdokhan (ma_do_khan, gia_tri_cap_do, ten_do_khan) VALUES (3, 3, 'Thượng khẩn');
INSERT INTO capdokhan (ma_do_khan, gia_tri_cap_do, ten_do_khan) VALUES (4, 4, 'Hỏa tốc');
INSERT INTO capdokhan (ma_do_khan, gia_tri_cap_do, ten_do_khan) VALUES (5, 5, 'Hỏa tốc hẹn giờ');

-- congviec
INSERT INTO congviec (ma_cong_viec, noi_dung_cong_viec, ten_cong_viec) VALUES (1, 'Quyết toán thuế thu nhập doanh nghiệp năm 2009', 'Quyết toán thuế');
INSERT INTO congviec (ma_cong_viec, noi_dung_cong_viec, ten_cong_viec) VALUES (2, 'Báo cáo mức thuế suất', 'Báo cáo');
INSERT INTO congviec (ma_cong_viec, noi_dung_cong_viec, ten_cong_viec) VALUES (3, 'Hướng dẫn thực hiện lệ phí trước bạ', 'Hướng dẫn');
INSERT INTO congviec (ma_cong_viec, noi_dung_cong_viec, ten_cong_viec) VALUES (4, 'Bổ sung điều chỉnh bảng giá tối thiểu tính lệ phí trước bạ', 'Bổ sung');
INSERT INTO congviec (ma_cong_viec, noi_dung_cong_viec, ten_cong_viec) VALUES (5, 'Về việc tiền thuê đất', 'Về việc tiền thuê đất');
INSERT INTO congviec (ma_cong_viec, noi_dung_cong_viec, ten_cong_viec) VALUES (6, 'Quyết toán thuế thu nhập cá nhân', 'Quyết toán thuế thu nhập cá nhân');
INSERT INTO congviec (ma_cong_viec, noi_dung_cong_viec, ten_cong_viec) VALUES (7, 'Hướng dẫn chế độ thu,nộp', 'Hướng dẫn chế độ thu,nộp');

-- donvi (root units first; unit 21 self-ref corrected to NULL)
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (1,  1, 'Bộ Công an', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (2,  1, 'Bộ Công thương', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (3,  1, 'Bộ Giáo dục và Đào tạo', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (4,  1, 'Bộ Giao thông Vận tải', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (5,  1, 'Bộ Kế hoạch và Đầu tư', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (6,  1, 'Bộ Khoa học và Công nghệ', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (7,  1, 'Bộ Lao động, Thương binh và Xã hội', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (8,  1, 'Bộ Ngoại giao', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (9,  1, 'Bộ Nội vụ', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (10, 1, 'Bộ Nông nghiệp và Phát triển nông thôn', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (11, 1, 'Bộ Quốc phòng', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (12, 1, 'Bộ Tài chính', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (13, 1, 'Bộ Tài nguyên và Môi trường', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (14, 1, 'Bộ Thông tin và Truyền thông', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (15, 1, 'Bộ Tư pháp', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (16, 1, 'Bộ Văn hóa, Thể thao và Du lịch', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (17, 1, 'Bộ Xây dựng', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (18, 1, 'Bộ Y tế', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (19, 1, 'Chính phủ', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (20, 1, 'Chủ tịch Nước', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (21, 2, 'Chi Cục Thuế Thành Phố Cần Thơ', NULL);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (22, 2, 'Chi Cục Thuế Quận Cái Răng', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (23, 2, 'Chi Cục Thuế Quận Ô Môn', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (24, 2, 'Chi Cục Thuế Quận Bình Thủy', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (25, 2, 'Chi Cục Thuế Quận Ninh Kiều', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (26, 3, 'Phòng Tổ Chức Cán Bộ', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (27, 3, 'Phòng Thanh Tra', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (28, 3, 'Phòng Quản trị - Tài vụ', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (29, 3, 'Phòng Hành chính lưu trữ', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (30, 3, 'Phòng Pháp chế', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (31, 3, 'Phòng Tuyên truyền và hỗ trợ người nộp thuế', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (32, 3, 'Phòng Kiểm tra Nội Bộ', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (33, 3, 'Phòng Kê Khai và Kế toán thuế', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (34, 3, 'Phòng Quản lý nợ và Cưỡng chế nợ thuế', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (35, 3, 'Phòng Tin học', 21);
INSERT INTO donvi (ma_don_vi, kieu_don_vi, ten_don_vi, donvitructhuoc) VALUES (36, 3, 'Phòng Thuế thu nhập Cá nhân', 21);

-- Sync sequence
SELECT setval('donvi_ma_don_vi_seq', (SELECT MAX(ma_don_vi) FROM donvi));

-- roles
INSERT INTO roles (ma_roles, ten_roles, ten_roles_chi_tiet) VALUES (1, 'ROLE_QUAN_TRI_HE_THONG', 'Quản trị hệ thống');
INSERT INTO roles (ma_roles, ten_roles, ten_roles_chi_tiet) VALUES (2, 'ROLE_LANH_DAO',          'Lãnh đạo');
INSERT INTO roles (ma_roles, ten_roles, ten_roles_chi_tiet) VALUES (3, 'ROLE_VAN_THU',           'Văn thư');
INSERT INTO roles (ma_roles, ten_roles, ten_roles_chi_tiet) VALUES (4, 'ROLE_XU_LY',             'Chuyên viên');
SELECT setval('roles_ma_roles_seq', (SELECT MAX(ma_roles) FROM roles));

-- nguoidung  (BCrypt cost-10 hashes)
--   ndqvinh  → original password "admin"
--   others   → original password "123456"
INSERT INTO nguoidung (ma_nguoi_dung, dia_chi, email, gioi_tinh, mac_dinh, password, so_dien_thoai, ten_nguoi_dung, username, ma_don_vi)
VALUES (1, 'Cái Răng',   'user1@gmail.com',   1, true, '$2y$10$0bvUttmp5RGVd6bvE18Oruo5xWcutFb0pShcA5lo9ttjO5nUYEZC2', '0123456789', 'Nguyễn Đặng Quang Vinh', 'ndqvinh',  21);
INSERT INTO nguoidung (ma_nguoi_dung, dia_chi, email, gioi_tinh, mac_dinh, password, so_dien_thoai, ten_nguoi_dung, username, ma_don_vi)
VALUES (2, 'Bình Thủy',  'user2@gmail.com',   1, true, '$2y$10$.FiSZdmyINX8lRukr0z/Q.ni8JezU/Levc6H0Xu.DUEPm6RvR3Scq', '0123456789', 'Huỳnh Thị Mỹ Hạnh',    'htmhanh',  21);
INSERT INTO nguoidung (ma_nguoi_dung, dia_chi, email, gioi_tinh, mac_dinh, password, so_dien_thoai, ten_nguoi_dung, username, ma_don_vi)
VALUES (3, 'Ninh Kiều',  'user3@gmail.com',   0, true, '$2y$10$.FiSZdmyINX8lRukr0z/Q.ni8JezU/Levc6H0Xu.DUEPm6RvR3Scq', '0123456789', 'Lưu Minh Thái',         'lthai',    21);
INSERT INTO nguoidung (ma_nguoi_dung, dia_chi, email, gioi_tinh, mac_dinh, password, so_dien_thoai, ten_nguoi_dung, username, ma_don_vi)
VALUES (4, 'Ô Môn',      'user4@gmail.com',   0, true, '$2y$10$.FiSZdmyINX8lRukr0z/Q.ni8JezU/Levc6H0Xu.DUEPm6RvR3Scq', '0123456789', 'Hoàng Đức Nhã',         'hdnha',    21);
INSERT INTO nguoidung (ma_nguoi_dung, dia_chi, email, gioi_tinh, mac_dinh, password, so_dien_thoai, ten_nguoi_dung, username, ma_don_vi)
VALUES (5, 'Trà Nóc',    'user5@gmail.com',   1, true, '$2y$10$.FiSZdmyINX8lRukr0z/Q.ni8JezU/Levc6H0Xu.DUEPm6RvR3Scq', '0123456789', 'Phạm Ngọc Quyền',       'pnquyen',  21);
INSERT INTO nguoidung (ma_nguoi_dung, dia_chi, email, gioi_tinh, mac_dinh, password, so_dien_thoai, ten_nguoi_dung, username, ma_don_vi)
VALUES (6, 'Phong Điền', 'dqthang@gmail.com', 0, true, '$2y$10$.FiSZdmyINX8lRukr0z/Q.ni8JezU/Levc6H0Xu.DUEPm6RvR3Scq', '0908762443', 'Đặng Quốc Thắng',       'dqthang',  22);
INSERT INTO nguoidung (ma_nguoi_dung, dia_chi, email, gioi_tinh, mac_dinh, password, so_dien_thoai, ten_nguoi_dung, username, ma_don_vi)
VALUES (7, 'Bến Tre',    'avsang@gmail.com',  0, true, '$2y$10$.FiSZdmyINX8lRukr0z/Q.ni8JezU/Levc6H0Xu.DUEPm6RvR3Scq', '0908726443', 'Âu Văn Sang',           'avsang',   22);
INSERT INTO nguoidung (ma_nguoi_dung, dia_chi, email, gioi_tinh, mac_dinh, password, so_dien_thoai, ten_nguoi_dung, username, ma_don_vi)
VALUES (8, 'Cần Thơ',    'htnguyet@gmail.com',1, true, '$2y$10$.FiSZdmyINX8lRukr0z/Q.ni8JezU/Levc6H0Xu.DUEPm6RvR3Scq', '0908123456', 'Huỳnh Thị Nguyệt',      'htnguyet', 25);
INSERT INTO nguoidung (ma_nguoi_dung, dia_chi, email, gioi_tinh, mac_dinh, password, so_dien_thoai, ten_nguoi_dung, username, ma_don_vi)
VALUES (9, 'Bến Tre',    'ntdat@gmail.com',   0, true, '$2y$10$.FiSZdmyINX8lRukr0z/Q.ni8JezU/Levc6H0Xu.DUEPm6RvR3Scq', '0908762443', 'Nguyễn Tấn Đạt',        'ntdat',    23);
SELECT setval('nguoidung_ma_nguoi_dung_seq', (SELECT MAX(ma_nguoi_dung) FROM nguoidung));

-- chucvu
INSERT INTO chucvu (ma_chuc_vu, ten_chuc_vu, ma_nguoi_dung) VALUES (1, 'Giám đốc',          1);
INSERT INTO chucvu (ma_chuc_vu, ten_chuc_vu, ma_nguoi_dung) VALUES (2, 'Phó Giám Đốc',      2);
INSERT INTO chucvu (ma_chuc_vu, ten_chuc_vu, ma_nguoi_dung) VALUES (3, 'Trưởng Chi Nhánh',  3);
INSERT INTO chucvu (ma_chuc_vu, ten_chuc_vu, ma_nguoi_dung) VALUES (4, 'Phó Trưởng Chi Nhánh', 4);
INSERT INTO chucvu (ma_chuc_vu, ten_chuc_vu, ma_nguoi_dung) VALUES (5, 'Trưởng Phòng',      5);
SELECT setval('chucvu_ma_chuc_vu_seq', (SELECT MAX(ma_chuc_vu) FROM chucvu));

-- nguoidung_roles
INSERT INTO nguoidung_roles (ma_nguoi_dung, ma_roles) VALUES (1, 1);
INSERT INTO nguoidung_roles (ma_nguoi_dung, ma_roles) VALUES (5, 2);
INSERT INTO nguoidung_roles (ma_nguoi_dung, ma_roles) VALUES (5, 3);
INSERT INTO nguoidung_roles (ma_nguoi_dung, ma_roles) VALUES (3, 4);
INSERT INTO nguoidung_roles (ma_nguoi_dung, ma_roles) VALUES (4, 4);
INSERT INTO nguoidung_roles (ma_nguoi_dung, ma_roles) VALUES (8, 4);
INSERT INTO nguoidung_roles (ma_nguoi_dung, ma_roles) VALUES (9, 4);
INSERT INTO nguoidung_roles (ma_nguoi_dung, ma_roles) VALUES (7, 4);
INSERT INTO nguoidung_roles (ma_nguoi_dung, ma_roles) VALUES (6, 4);
INSERT INTO nguoidung_roles (ma_nguoi_dung, ma_roles) VALUES (2, 4);

-- hosoluutru
INSERT INTO hosoluutru (so_ho_so, ma_ho_so, thoi_gian_bao_quan, thoi_gian_bd, thoi_gian_ket_thuc, tieu_de_ho_so)
VALUES (1, 'hs001', 5, '2013-01-01', '2013-01-12', 'Hồ sơ về thuế TNCN');
INSERT INTO hosoluutru (so_ho_so, ma_ho_so, thoi_gian_bao_quan, thoi_gian_bd, thoi_gian_ket_thuc, tieu_de_ho_so)
VALUES (2, 'hs002', 5, '2013-01-01', '2013-01-31', 'Hướng dẫn về thuế');
INSERT INTO hosoluutru (so_ho_so, ma_ho_so, thoi_gian_bao_quan, thoi_gian_bd, thoi_gian_ket_thuc, tieu_de_ho_so)
VALUES (3, 'hs003', 5, '2013-01-01', '2013-01-20', 'Tăng cường công tác quản lý');

-- linhvuc
INSERT INTO linhvuc (ma_linh_vuc, ten_linh_vuc) VALUES (1, 'Kinh tế');
INSERT INTO linhvuc (ma_linh_vuc, ten_linh_vuc) VALUES (2, 'Thể Thao');
INSERT INTO linhvuc (ma_linh_vuc, ten_linh_vuc) VALUES (3, 'Chính trị');
INSERT INTO linhvuc (ma_linh_vuc, ten_linh_vuc) VALUES (4, 'Khoa học');
INSERT INTO linhvuc (ma_linh_vuc, ten_linh_vuc) VALUES (5, 'Công nghệ');
SELECT setval('linhvuc_ma_linh_vuc_seq', (SELECT MAX(ma_linh_vuc) FROM linhvuc));

-- quytrinh
INSERT INTO quytrinh (ma_quy_trinh, mo_ta) VALUES (1, 'Quy trình bản cam kết');
INSERT INTO quytrinh (ma_quy_trinh, mo_ta) VALUES (2, 'Quy trình bản ghi nhớ');
INSERT INTO quytrinh (ma_quy_trinh, mo_ta) VALUES (3, 'Quy trình bản thỏa thuận');
INSERT INTO quytrinh (ma_quy_trinh, mo_ta) VALUES (4, 'Quy trình báo cáo');
INSERT INTO quytrinh (ma_quy_trinh, mo_ta) VALUES (5, 'Quy trình biên bản');
INSERT INTO quytrinh (ma_quy_trinh, mo_ta) VALUES (6, 'Quy trình chỉ thị');
SELECT setval('quytrinh_ma_quy_trinh_seq', (SELECT MAX(ma_quy_trinh) FROM quytrinh));

-- loaivanban
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (1,  'Bản cam kết',   1);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (2,  'Bản ghi nhớ',   2);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (3,  'Bản thỏa thuận',3);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (4,  'Báo cáo',       4);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (5,  'Biên bản',      5);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (6,  'Chỉ thị',       1);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (7,  'Chương trình',  2);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (8,  'Công điện',     3);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (9,  'Công ước',      4);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (10, 'Công văn',      5);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (11, 'Đề án',         1);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (12, 'Dự án',         2);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (13, 'Thông báo',     3);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (14, 'Quyết định',    4);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (15, 'Nghị quyết',    5);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (16, 'Nghị định',     1);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (17, 'Luật',          2);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (18, 'Quy định',      3);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (19, 'Quy chế',       4);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (20, 'Hướng dẫn',     5);
INSERT INTO loaivanban (ma_loai, ten_loai, ma_quy_trinh) VALUES (21, 'Kế hoạch',      1);
SELECT setval('loaivanban_ma_loai_seq', (SELECT MAX(ma_loai) FROM loaivanban));

-- vitriluutru
INSERT INTO vitriluutru (stt, vi_tri) VALUES (1, 'Hộc thứ 1, Kệ số 1');
INSERT INTO vitriluutru (stt, vi_tri) VALUES (2, 'Hộc thứ 2, Kệ số 1');
INSERT INTO vitriluutru (stt, vi_tri) VALUES (3, 'Hộc thứ 3, Kệ số 1');
INSERT INTO vitriluutru (stt, vi_tri) VALUES (4, 'Hộc thứ 4, Kệ số 1');
SELECT setval('vitriluutru_stt_seq', (SELECT MAX(stt) FROM vitriluutru));

-- vanban
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (2,  true,  '2013-04-27','2013-07-05','2013-04-27','2013-04-27','Hoàng Đức Nhã',           '1482-CT-TTHT',   6, 3,'Công văn số 1482-CT-TTHT về thuế TNCN',                                                                                             '1482-CT-TTHT',  1,1,3,3,10,3);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (3,  true,  '2013-04-27','2013-08-15','2013-04-27','2013-04-27','Đỗ Văn Cường',            '1487-CT-TTHT',  10, 3,'Công văn số 1487-CT-TTHT về chính sách thuế',                                                                                        '1487-CT-TTHT',  1,1,3,3,10,4);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (4,  true,  '2013-04-27','2013-11-08','2013-04-27','2013-04-27','Phạm Ngọc Quyền',         '1438-CT-TTHT',   9, 3,'Công văn số 1438-CT-TTHT về thuế suất thuế GTGT',                                                                                   '1438-CT-TTHT',  1,2,3,4,10,4);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (5,  true,  '2013-04-27','2013-08-16','2013-04-27','2013-04-27','Nguyễn Đặng Quang Vinh',  '1455-CT-QLĐ',    6, 3,'Công văn số 1455-CT-QLĐ của Cục thuế về chính sách thuế sử dụng đất phi nông nghiệp',                                                '1455-CT-QLĐ',   1,1,3,3,10,2);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (6,  false, '2013-04-16','2013-05-31','2013-04-16','2013-05-12','Nguyễn Đức Chi',           '755-QĐ-BTC',     4, 1,'Quyết định số 755-QĐ-BTC ngày 16-4-2013 đính chính Thông tư 16-2013-TT-BTC',                                                        '755-QĐ-BTC',    1,4,2,3,10,2);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (7,  false, '2012-11-22','2013-05-31','2012-11-22','2013-05-12','Nguyễn Sinh Hùng',         '26-2012-QH13',   3, 1,'Luật số 26-2012-QH13 sửa đổi, bổ sung một số điều của Luật thuế Thu nhập cá nhân',                                                   '26-2012-QH13',  4,1,2,3,10,3);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (8,  false, '2012-11-19','2013-05-31','2012-11-19','2013-05-12','Vũ Đức Đam',               '1368-QĐ-VPCP',   3, 1,'Quyết định số 1368-QĐ-VPCP quy định chức năng, nhiệm vụ của các Vụ, Cục thuộc Văn phòng Chính phủ',                                  '1368-QĐ-VPCP',  1,4,2,3,1, 3);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (9,  false, '2012-11-15','2013-07-26','2012-11-15','2013-05-12','Vũ Thị Mai',               '197-2012-TT-BTC',3, 1,'Thông tư số 197-2012-TT-BTC hướng dẫn chế độ thu, nộp phí sử dụng đường bộ',                                                        '197-2012-TT-BTC',1,4,1,3,1,3);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (10, false, '2012-11-02','2013-08-16','2012-11-02','2013-05-12','Vương Đình Huệ',           '04-CT-BTC',      2, 1,'Chỉ thị số 04-CT-BTC tăng cường công tác quản lý, điều hành và bình ổn giá cuối năm 2012',                                            '04-CT-BTC',     1,4,2,3,10,2);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (11, false, '2012-10-03','2013-09-13','2012-10-03','2013-05-12','Nguyễn Tấn Dũng',          '75-2012-NĐ-CP',  4, 1,'Nghị định số 75-2012-NĐ-CP quy định chi tiết một số điều của Luật khiếu nại',                                                        '75-2012-NĐ-CP', 1,1,3,3,10,3);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (14, true,  '2013-03-25','2013-05-31','2013-05-13','2013-05-13','abcd',                      '1486-CT-TTHT',   3, 3,'Công văn số 1486-CT-TTHT về chính sách thuế',                                                                                        '1487-CT-TTHT',  2,4,2,3,10,3);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (15, true,  '2013-03-22','2013-08-17','2013-05-13','2013-05-13','Phạm Ngọc Quyền',          '1436-CT-TTHT',   3, 3,'Công văn số 1436-CT-TTHT về thuế suất thuế GTGT',                                                                                   '1436-CT-TTHT',  1,4,1,3,10,2);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (16, true,  '2013-03-22','2013-08-08','2013-03-22','2013-05-13','Nguyễn Tấn Đạt',           '1456-CT-QLĐ',    4, 3,'Công văn số 1456-CT-QLĐ của Cục thuế về chính sách thuế sử dụng đất phi nông nghiệp',                                                '1455-CT-QLĐ',   4,1,1,3,10,1);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (17, true,  '2013-03-21','2013-07-17','2013-03-21','2013-05-13','Trần Thị Lệ Nga',          '1432-CT-TTHT',   4, 3,'Công văn số 1432-CT-TTHT hướng dẫn về thuế thu nhập doanh nghiệp',                                                                   '1432-CT-TTHT',  1,4,1,3,10,3);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (18, true,  '2013-03-12','2013-08-09','2013-03-12','2013-05-13','Phạm Ngọc Quyền',          '1226-CT-TTHT',   4, 3,'Công văn số 1226-CT-TTHT về hóa đơn đặt in sai ký hiệu mẫu số hóa đơn',                                                             '1226-CT-TTHT',  2,4,1,3,10,1);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (19, true,  '2013-03-07','2013-06-21','2013-03-07','2013-05-13','Phạm Ngọc Quyền',          '1141-CT-TTHT',   3, 3,'Công văn số 1141-CT-TTHT về thuế TNDN',                                                                                             '1141-CT-TTHT',  2,1,3,3,10,4);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (20, true,  '2013-03-07','2013-10-04','2013-03-07','2013-05-13','Hoàng Đức Nhã',            '1148-CT-TTHT',   3, 3,'Công văn số 1148-CT-TTHT về thuế nhà thầu',                                                                                         '1148-CT-TTHT',  1,1,1,3,10,2);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (21, true,  '2013-03-05','2013-05-31','2013-03-05','2013-05-13','Hoàng Đức Nhã',            '1108-CT-TTHT',   3, 1,'Công văn số 1108-CT-TTHT về thuế TNCN',                                                                                             '1108-CT-TTHT',  1,4,1,3,10,2);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (22, true,  '2013-02-28','2013-07-19','2013-02-28','2013-05-13','Hoàng Đức Nhã',            '1061-CT-TTHT',   3, 1,'Công văn số 1061-CT-TTHT về chính sách thuế',                                                                                        '1061-CT-TTHT',  2,1,2,3,10,2);
INSERT INTO vanban (ma_van_ban, enabled, ngay_ban_hanh, ngay_het_hieu_luc, ngay_hieu_luc, ngay_nhap_may, nguoi_ky, ky_hieu, so_trang, trang_thai_xu_ly, trich_yeu, tu_khoa, ma_do_mat, ma_do_khan, so_ho_so, ma_linh_vuc, ma_loai, stt)
VALUES (23, true,  '2013-02-25','2013-08-16','2013-02-25','2013-05-13','Hoàng Đức Nhã',            '928-CT-TTHT',    3, 1,'Công văn số 928-CT-TTHT về thuế TNCN',                                                                                              '928-CT-TTHT',   1,4,1,3,10,2);
SELECT setval('vanban_ma_van_ban_seq', (SELECT MAX(ma_van_ban) FROM vanban));

-- vanbanden
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-04-27', 1,  2,  12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-04-27', 2,  3,  12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-04-27', 3,  4,  14);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-04-27', 4,  5,  12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-05-13', 6,  14, 12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-05-13', 7,  15, 12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-05-13', 8,  16, 12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-05-13', 9,  17, 12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-05-13', 10, 18, 12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-05-13', 11, 19, 12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-05-13', 12, 20, 12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-05-13', 13, 21, 12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-05-13', 14, 22, 12);
INSERT INTO vanbanden (ngay_den, so_den, ma_van_ban, ma_don_vi) VALUES ('2013-05-13', 15, 23, 12);

-- vanbandi
INSERT INTO vanbandi (ngay_di, so_di, ma_van_ban) VALUES (NULL, 0, 6);
INSERT INTO vanbandi (ngay_di, so_di, ma_van_ban) VALUES (NULL, 0, 7);
INSERT INTO vanbandi (ngay_di, so_di, ma_van_ban) VALUES (NULL, 0, 8);
INSERT INTO vanbandi (ngay_di, so_di, ma_van_ban) VALUES (NULL, 0, 9);
INSERT INTO vanbandi (ngay_di, so_di, ma_van_ban) VALUES (NULL, 0, 10);
INSERT INTO vanbandi (ngay_di, so_di, ma_van_ban) VALUES (NULL, 0, 11);

-- buoc
INSERT INTO buoc (ma_quy_trinh, so_thu_tu, so_ngay, ma_cong_viec) VALUES (5, 1, 2, 6);

-- buoc_nguoidung
INSERT INTO buoc_nguoidung (so_thu_tu, ma_nguoi_dung, ma_quy_trinh) VALUES (1, 3, 5);
INSERT INTO buoc_nguoidung (so_thu_tu, ma_nguoi_dung, ma_quy_trinh) VALUES (1, 5, 5);
INSERT INTO buoc_nguoidung (so_thu_tu, ma_nguoi_dung, ma_quy_trinh) VALUES (1, 4, 5);

-- buocxulypheduyetvanban
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  2,  1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-13', true, true, 3);
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  3,  1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-13', true, true, 3);
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  4,  1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-13', true, true, 3);
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  5,  1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-13', true, true, 3);
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  14, 1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-13', true, true, 3);
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  15, 1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-13', true, true, 3);
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  16, 1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-16', true, true, 3);
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  17, 1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-13', true, true, 4);
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  18, 1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-16', true, true, 4);
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  19, 1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-16', true, true, 4);
INSERT INTO buocxulypheduyetvanban (ma_quy_trinh, ma_van_ban, so_thu_tu, noi_dung_xu_ly, thoi_gian_bd, thoi_gian_kt, thoi_gian_xu_ly, value_chuyen, value_xu_ly, ma_nguoi_dung)
VALUES (5,  20, 1, 'Đã xử lý xong', '2013-05-13', '2013-05-15', '2013-05-13', true, true, 4);
