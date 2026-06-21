import api from './axios'
import type { CapDoBaoMat, CapDoKhan, DonVi, LinhVuc, LoaiVanBan, Role } from '@/types'

export const danhMucApi = {
  getLoaiVanBan: () =>
    api.get<LoaiVanBan[]>('/danh-muc/loai-van-ban').then((r) => r.data),

  getCapDoKhan: () =>
    api.get<CapDoKhan[]>('/danh-muc/cap-do-khan').then((r) => r.data),

  getCapDoBaoMat: () =>
    api.get<CapDoBaoMat[]>('/danh-muc/cap-do-bao-mat').then((r) => r.data),

  getLinhVuc: () =>
    api.get<LinhVuc[]>('/danh-muc/linh-vuc').then((r) => r.data),

  getDonVi: () =>
    api.get<DonVi[]>('/danh-muc/don-vi').then((r) => r.data),

  getRoles: () =>
    api.get<Role[]>('/danh-muc/roles').then((r) => r.data),
}
