import api from './axios'
import type {
  PageResponse,
  VanBanDenRequest,
  VanBanDenResponse,
  VanBanDenSearchParams,
  FileDinhKemResponse,
} from '@/types'

export const vanBanDenApi = {
  getAll: (params: { page?: number; size?: number }) =>
    api.get<PageResponse<VanBanDenResponse>>('/van-ban-den', { params }).then((r) => r.data),

  search: (params: VanBanDenSearchParams) =>
    api.get<PageResponse<VanBanDenResponse>>('/van-ban-den/search', { params }).then((r) => r.data),

  getById: (id: number) =>
    api.get<VanBanDenResponse>(`/van-ban-den/${id}`).then((r) => r.data),

  create: (data: VanBanDenRequest) =>
    api.post<VanBanDenResponse>('/van-ban-den', data).then((r) => r.data),

  update: (id: number, data: VanBanDenRequest) =>
    api.put<VanBanDenResponse>(`/van-ban-den/${id}`, data).then((r) => r.data),

  delete: (id: number) =>
    api.delete(`/van-ban-den/${id}`),

  uploadFile: (maVanBan: number, file: File) => {
    const form = new FormData()
    form.append('file', file)
    return api
      .post<FileDinhKemResponse>(`/files/van-ban/${maVanBan}`, form, {
        headers: { 'Content-Type': 'multipart/form-data' },
      })
      .then((r) => r.data)
  },

  deleteFile: (maFile: number) =>
    api.delete(`/files/${maFile}`),
}
