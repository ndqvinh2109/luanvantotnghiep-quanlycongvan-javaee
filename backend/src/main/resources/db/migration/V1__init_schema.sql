-- ============================================================
-- V1: Schema — aligned with legacy data.sql column names
-- ============================================================

CREATE TABLE IF NOT EXISTS capdobaomat (
    ma_do_mat   SERIAL PRIMARY KEY,
    cap_do_mat  VARCHAR(100),
    ten_do_mat  VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS capdokhan (
    ma_do_khan     SERIAL PRIMARY KEY,
    gia_tri_cap_do INTEGER,
    ten_do_khan    VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS congviec (
    ma_cong_viec       SERIAL PRIMARY KEY,
    ten_cong_viec      VARCHAR(200),
    noi_dung_cong_viec TEXT
);

CREATE TABLE IF NOT EXISTS donvi (
    ma_don_vi      SERIAL PRIMARY KEY,
    ten_don_vi     VARCHAR(300) NOT NULL,
    kieu_don_vi    INTEGER,
    donvitructhuoc INTEGER REFERENCES donvi(ma_don_vi)
);

CREATE TABLE IF NOT EXISTS linhvuc (
    ma_linh_vuc  SERIAL PRIMARY KEY,
    ten_linh_vuc VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS hosoluutru (
    so_ho_so           INTEGER PRIMARY KEY,
    ma_ho_so           VARCHAR(50),
    tieu_de_ho_so      VARCHAR(500),
    thoi_gian_bao_quan INTEGER,
    thoi_gian_bd       DATE,
    thoi_gian_ket_thuc DATE
);

CREATE TABLE IF NOT EXISTS vitriluutru (
    stt     SERIAL PRIMARY KEY,
    vi_tri  VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS quytrinh (
    ma_quy_trinh SERIAL PRIMARY KEY,
    mo_ta        TEXT
);

CREATE TABLE IF NOT EXISTS loaivanban (
    ma_loai      SERIAL PRIMARY KEY,
    ten_loai     VARCHAR(200),
    ma_quy_trinh INTEGER REFERENCES quytrinh(ma_quy_trinh)
);

CREATE TABLE IF NOT EXISTS roles (
    ma_roles          SERIAL PRIMARY KEY,
    ten_roles         VARCHAR(100) NOT NULL UNIQUE,
    ten_roles_chi_tiet VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS nguoidung (
    ma_nguoi_dung  SERIAL PRIMARY KEY,
    ten_nguoi_dung VARCHAR(200),
    gioi_tinh      INTEGER,
    email          VARCHAR(200),
    dia_chi        TEXT,
    so_dien_thoai  VARCHAR(20),
    username       VARCHAR(100) NOT NULL UNIQUE,
    password       VARCHAR(255) NOT NULL,
    mac_dinh       BOOLEAN DEFAULT FALSE,
    ma_don_vi      INTEGER REFERENCES donvi(ma_don_vi)
);

CREATE TABLE IF NOT EXISTS chucvu (
    ma_chuc_vu    SERIAL PRIMARY KEY,
    ten_chuc_vu   VARCHAR(200),
    ma_nguoi_dung INTEGER REFERENCES nguoidung(ma_nguoi_dung)
);

CREATE TABLE IF NOT EXISTS nguoidung_roles (
    id            SERIAL,
    ma_nguoi_dung INTEGER NOT NULL REFERENCES nguoidung(ma_nguoi_dung) ON DELETE CASCADE,
    ma_roles      INTEGER NOT NULL REFERENCES roles(ma_roles),
    PRIMARY KEY (ma_nguoi_dung, ma_roles)
);

CREATE TABLE IF NOT EXISTS vanban (
    ma_van_ban        SERIAL PRIMARY KEY,
    ky_hieu           VARCHAR(100),
    ngay_ban_hanh     DATE,
    ngay_hieu_luc     DATE,
    ngay_het_hieu_luc DATE,
    trich_yeu         TEXT,
    nguoi_ky          VARCHAR(200),
    so_trang          INTEGER,
    tu_khoa           VARCHAR(500),
    ngay_nhap_may     DATE,
    trang_thai_xu_ly  INTEGER DEFAULT 0,
    enabled           BOOLEAN DEFAULT FALSE,
    ma_do_mat         INTEGER REFERENCES capdobaomat(ma_do_mat),
    ma_linh_vuc       INTEGER REFERENCES linhvuc(ma_linh_vuc),
    ma_loai           INTEGER REFERENCES loaivanban(ma_loai),
    ma_do_khan        INTEGER REFERENCES capdokhan(ma_do_khan),
    stt               INTEGER REFERENCES vitriluutru(stt),
    so_ho_so          INTEGER REFERENCES hosoluutru(so_ho_so)
);

CREATE TABLE IF NOT EXISTS vanbanden (
    ma_van_ban INTEGER PRIMARY KEY REFERENCES vanban(ma_van_ban) ON DELETE CASCADE,
    so_den     INTEGER,
    ngay_den   DATE,
    ma_don_vi  INTEGER REFERENCES donvi(ma_don_vi)
);

CREATE TABLE IF NOT EXISTS vanbandi (
    ma_van_ban INTEGER PRIMARY KEY REFERENCES vanban(ma_van_ban) ON DELETE CASCADE,
    so_di      INTEGER,
    ngay_di    DATE
);

CREATE TABLE IF NOT EXISTS vanbandi_donvi (
    ma_van_ban INTEGER NOT NULL REFERENCES vanbandi(ma_van_ban) ON DELETE CASCADE,
    ma_don_vi  INTEGER NOT NULL REFERENCES donvi(ma_don_vi),
    PRIMARY KEY (ma_van_ban, ma_don_vi)
);

CREATE TABLE IF NOT EXISTS filedinhkem (
    ma_file      SERIAL PRIMARY KEY,
    ten_file     VARCHAR(500),
    kieu_tap_tin VARCHAR(200),
    mo_ta        TEXT,
    duong_dan    VARCHAR(1000),
    kich_thuoc   BIGINT,
    ma_van_ban   INTEGER REFERENCES vanban(ma_van_ban) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS comment (
    ma_comment    SERIAL PRIMARY KEY,
    noi_dung      TEXT,
    thoi_gian     TIMESTAMP,
    ma_van_ban    INTEGER REFERENCES vanban(ma_van_ban) ON DELETE CASCADE,
    ma_nguoi_dung INTEGER REFERENCES nguoidung(ma_nguoi_dung)
);

CREATE TABLE IF NOT EXISTS buoc (
    so_thu_tu    INTEGER NOT NULL,
    ma_quy_trinh INTEGER NOT NULL REFERENCES quytrinh(ma_quy_trinh) ON DELETE CASCADE,
    ma_cong_viec INTEGER REFERENCES congviec(ma_cong_viec),
    so_ngay      INTEGER,
    PRIMARY KEY (so_thu_tu, ma_quy_trinh)
);

CREATE TABLE IF NOT EXISTS buoc_nguoidung (
    ma_buoc_nguoi_dung SERIAL PRIMARY KEY,
    so_thu_tu          INTEGER,
    ma_nguoi_dung      INTEGER REFERENCES nguoidung(ma_nguoi_dung),
    ma_quy_trinh       INTEGER,
    FOREIGN KEY (so_thu_tu, ma_quy_trinh) REFERENCES buoc(so_thu_tu, ma_quy_trinh)
);

CREATE TABLE IF NOT EXISTS buocxulypheduyetvanban (
    so_thu_tu       INTEGER NOT NULL,
    ma_quy_trinh    INTEGER NOT NULL,
    ma_van_ban      INTEGER NOT NULL REFERENCES vanban(ma_van_ban) ON DELETE CASCADE,
    ma_nguoi_dung   INTEGER REFERENCES nguoidung(ma_nguoi_dung),
    noi_dung_xu_ly  TEXT,
    thoi_gian_bd    DATE,
    thoi_gian_kt    DATE,
    thoi_gian_xu_ly DATE,
    value_xu_ly     BOOLEAN DEFAULT FALSE,
    value_chuyen    BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (so_thu_tu, ma_quy_trinh, ma_van_ban),
    FOREIGN KEY (so_thu_tu, ma_quy_trinh) REFERENCES buoc(so_thu_tu, ma_quy_trinh)
);

CREATE TABLE IF NOT EXISTS message (
    ma_message    SERIAL PRIMARY KEY,
    noi_dung      TEXT,
    thoi_gian     TIMESTAMP,
    da_doc        BOOLEAN DEFAULT FALSE,
    ma_nguoi_dung INTEGER REFERENCES nguoidung(ma_nguoi_dung),
    ma_nguoi_nhan INTEGER REFERENCES nguoidung(ma_nguoi_dung)
);

-- Indexes
CREATE INDEX IF NOT EXISTS idx_vanbanden_ngay_den   ON vanbanden(ngay_den);
CREATE INDEX IF NOT EXISTS idx_vanban_trang_thai    ON vanban(trang_thai_xu_ly);
CREATE INDEX IF NOT EXISTS idx_vanbandi_ngay_di     ON vanbandi(ngay_di);
CREATE INDEX IF NOT EXISTS idx_vanban_loai          ON vanban(ma_loai);
CREATE INDEX IF NOT EXISTS idx_message_nguoi_nhan   ON message(ma_nguoi_nhan, da_doc);
