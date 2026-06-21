-- ============================================================
-- V2: Seed reference data (roles, urgency levels, secrecy levels)
-- ============================================================

INSERT INTO roles (ten_roles) VALUES
    ('ROLE_QUAN_TRI_HE_THONG'),
    ('ROLE_VAN_THU'),
    ('ROLE_XU_LY'),
    ('ROLE_LANH_DAO')
ON CONFLICT DO NOTHING;

INSERT INTO capdobaomat (cap_do_mat, ten_do_mat) VALUES
    ('binh thuong', 'Bình thường'),
    ('mat',         'Mật'),
    ('toi mat',     'Tối mật'),
    ('tuyet mat',   'Tuyệt mật')
ON CONFLICT DO NOTHING;

INSERT INTO capdokhan (gia_tri_cap_do, ten_do_khan) VALUES
    (1, 'Bình thường'),
    (2, 'Khẩn'),
    (3, 'Thượng khẩn'),
    (4, 'Hỏa tốc'),
    (5, 'Hỏa tốc hẹn giờ')
ON CONFLICT DO NOTHING;
