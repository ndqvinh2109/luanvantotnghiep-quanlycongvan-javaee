import api from './axios'
import type { NguoiDungRequest, NguoiDungResponse } from '@/types'

export const nguoiDungApi = {
  getAll: () =>
    api.get<NguoiDungResponse[]>('/admin/nguoi-dung').then((r) => r.data),

  getById: (id: number) =>
    api.get<NguoiDungResponse>(`/admin/nguoi-dung/${id}`).then((r) => r.data),

  create: (data: NguoiDungRequest) =>
    api.post<NguoiDungResponse>('/admin/nguoi-dung', data).then((r) => r.data),

  delete: (id: number) =>
    api.delete(`/admin/nguoi-dung/${id}`),
}
