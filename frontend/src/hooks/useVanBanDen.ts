import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query'
import { vanBanDenApi } from '@/api/vanBanDen'
import type { VanBanDenRequest, VanBanDenSearchParams } from '@/types'
import { message } from 'antd'

const KEYS = {
  list: (p: object) => ['van-ban-den', p] as const,
  detail: (id: number) => ['van-ban-den', id] as const,
}

export const useVanBanDenList = (params: VanBanDenSearchParams) =>
  useQuery({
    queryKey: KEYS.list(params),
    queryFn: () =>
      params.tuKhoa || params.maLoai || params.maDonVi || params.tuNgay || params.denNgay
        ? vanBanDenApi.search(params)
        : vanBanDenApi.getAll({ page: params.page, size: params.size }),
  })

export const useVanBanDenDetail = (id: number) =>
  useQuery({ queryKey: KEYS.detail(id), queryFn: () => vanBanDenApi.getById(id), enabled: !!id })

export const useCreateVanBanDen = () => {
  const qc = useQueryClient()
  return useMutation({
    mutationFn: (data: VanBanDenRequest) => vanBanDenApi.create(data),
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ['van-ban-den'] })
      message.success('Thêm văn bản đến thành công')
    },
    onError: () => message.error('Có lỗi xảy ra, vui lòng thử lại'),
  })
}

export const useUpdateVanBanDen = (id: number) => {
  const qc = useQueryClient()
  return useMutation({
    mutationFn: (data: VanBanDenRequest) => vanBanDenApi.update(id, data),
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ['van-ban-den'] })
      message.success('Cập nhật văn bản đến thành công')
    },
    onError: () => message.error('Có lỗi xảy ra, vui lòng thử lại'),
  })
}

export const useDeleteVanBanDen = () => {
  const qc = useQueryClient()
  return useMutation({
    mutationFn: (id: number) => vanBanDenApi.delete(id),
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ['van-ban-den'] })
      message.success('Xóa văn bản đến thành công')
    },
    onError: () => message.error('Có lỗi xảy ra, vui lòng thử lại'),
  })
}
