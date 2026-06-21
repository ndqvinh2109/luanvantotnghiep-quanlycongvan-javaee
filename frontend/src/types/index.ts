// ─── Auth ───────────────────────────────────────────────────────────────────

export interface LoginRequest {
  username: string
  password: string
}

export interface AuthResponse {
  accessToken: string
  refreshToken: string
  tokenType: string
  userId: number
  username: string
  tenNguoiDung: string
  roles: string[]
}

// ─── Shared ──────────────────────────────────────────────────────────────────

export interface RefResponse {
  id: number
  ten: string
}

export interface PageResponse<T> {
  content: T[]
  page: number
  size: number
  totalElements: number
  totalPages: number
  last: boolean
}

export interface FileDinhKemResponse {
  maFile: number
  tenFile: string
  duongDan: string
  kichThuoc: number
  loaiFile: string
}

// ─── Văn bản đến ─────────────────────────────────────────────────────────────

export interface VanBanDenResponse {
  maVanBan: number
  soKyHieuVanBan: string
  ngayBanHanh: string
  ngayHieuLuc: string | null
  ngayHetHieuLuc: string | null
  trichYeu: string
  nguoiKy: string | null
  soTrang: number | null
  tuKhoa: string | null
  ngayNhapMay: string
  trangThaiXuLy: number
  enabled: boolean
  soDen: number | null
  ngayDen: string
  donVi: RefResponse | null
  loaiVanBan: RefResponse | null
  capDoKhan: RefResponse | null
  capDoBaoMat: RefResponse | null
  linhVuc: RefResponse | null
  fileDinhKems: FileDinhKemResponse[]
}

export interface VanBanDenRequest {
  soKyHieuVanBan: string
  ngayBanHanh: string
  ngayHieuLuc?: string
  ngayHetHieuLuc?: string
  trichYeu: string
  nguoiKy?: string
  soTrang?: number
  tuKhoa?: string
  ngayDen: string
  soDen?: number
  maDonVi: number
  maLoai?: number
  maDoKhan?: number
  maDoMat?: number
  maLinhVuc?: number
}

export interface VanBanDenSearchParams {
  tuKhoa?: string
  maLoai?: number
  maDonVi?: number
  tuNgay?: string
  denNgay?: string
  page?: number
  size?: number
}

// ─── Văn bản đi ──────────────────────────────────────────────────────────────

export interface VanBanDiResponse {
  maVanBan: number
  soKyHieuVanBan: string
  ngayBanHanh: string
  ngayHieuLuc: string | null
  ngayHetHieuLuc: string | null
  trichYeu: string
  nguoiKy: string | null
  soTrang: number | null
  tuKhoa: string | null
  ngayNhapMay: string
  trangThaiXuLy: number
  enabled: boolean
  soDi: number | null
  ngayDi: string | null
  loaiVanBan: RefResponse | null
  capDoKhan: RefResponse | null
  capDoBaoMat: RefResponse | null
  linhVuc: RefResponse | null
  donViNhanList: RefResponse[]
  fileDinhKems: FileDinhKemResponse[]
}

export interface VanBanDiRequest {
  soKyHieuVanBan: string
  ngayBanHanh: string
  ngayHieuLuc?: string
  ngayHetHieuLuc?: string
  trichYeu: string
  nguoiKy?: string
  soTrang?: number
  tuKhoa?: string
  ngayDi?: string
  soDi?: number
  maDonViList: number[]
  maLoai?: number
  maDoKhan?: number
  maDoMat?: number
  maLinhVuc?: number
}

// ─── Người dùng ──────────────────────────────────────────────────────────────

export interface NguoiDungResponse {
  maNguoiDung: number
  tenNguoiDung: string
  gioiTinh: number | null
  email: string | null
  diaChi: string | null
  soDienThoai: string | null
  userName: string
  macDinh: boolean
  donVi: RefResponse | null
  roles: RefResponse[]
}

export interface NguoiDungRequest {
  tenNguoiDung: string
  gioiTinh?: number
  email?: string
  diaChi?: string
  soDienThoai?: string
  userName: string
  passWord: string
  maDonVi: number
  maRolesList: number[]
}

// ─── Danh mục ────────────────────────────────────────────────────────────────

export interface CapDoKhan {
  maDoKhan: number
  giaTriCapDo: number
  tenDoKhan: string
}

export interface CapDoBaoMat {
  maDoMat: number
  capDoMat: string
  tenDoMat: string
}

export interface LinhVuc {
  maLinhVuc: number
  tenLinhVuc: string
}

export interface LoaiVanBan {
  maLoai: number
  tenLoai: string
  quyTrinh: { maQuyTrinh: number; moTa: string } | null
}

export interface DonVi {
  maDonVi: number
  tenDonVi: string
  kieuDonVi: number | null
  donViTrucThuoc: DonVi | null
  donViConList: DonVi[]
}

export interface Role {
  maRoles: number
  tenRoles: string
}

// ─── Trạng thái xử lý ────────────────────────────────────────────────────────

export const TRANG_THAI_XU_LY: Record<number, { label: string; color: string }> = {
  0: { label: 'Chờ tiếp nhận', color: 'default' },
  1: { label: 'Đã tiếp nhận', color: 'processing' },
  2: { label: 'Đang xử lý',   color: 'warning' },
  3: { label: 'Hoàn thành',   color: 'success' },
  4: { label: 'Từ chối',      color: 'error' },
}
