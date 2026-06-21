import api from './axios'
import type { PageResponse, VanBanDiRequest, VanBanDiResponse } from '@/types'

export const vanBanDiApi = {
  getAll: (params: { page?: number; size?: number }) =>
    api.get<PageResponse<VanBanDiResponse>>('/van-ban-di', { params }).then((r) => r.data),

  search: (params: { tuKhoa?: string; maLoai?: number; tuNgay?: string; denNgay?: string; page?: number; size?: number }) =>
    api.get<PageResponse<VanBanDiResponse>>('/van-ban-di/search', { params }).then((r) => r.data),

  getById: (id: number) =>
    api.get<VanBanDiResponse>(`/van-ban-di/${id}`).then((r) => r.data),

  create: (data: VanBanDiRequest) =>
    api.post<VanBanDiResponse>('/van-ban-di', data).then((r) => r.data),

  update: (id: number, data: VanBanDiRequest) =>
    api.put<VanBanDiResponse>(`/van-ban-di/${id}`, data).then((r) => r.data),

  delete: (id: number) =>
    api.delete(`/van-ban-di/${id}`),
}
