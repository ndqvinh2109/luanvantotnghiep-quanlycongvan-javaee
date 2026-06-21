import { useQuery } from '@tanstack/react-query'
import { danhMucApi } from '@/api/danhMuc'

export const useLoaiVanBan = () =>
  useQuery({ queryKey: ['loai-van-ban'], queryFn: danhMucApi.getLoaiVanBan, staleTime: Infinity })

export const useCapDoKhan = () =>
  useQuery({ queryKey: ['cap-do-khan'], queryFn: danhMucApi.getCapDoKhan, staleTime: Infinity })

export const useCapDoBaoMat = () =>
  useQuery({ queryKey: ['cap-do-bao-mat'], queryFn: danhMucApi.getCapDoBaoMat, staleTime: Infinity })

export const useLinhVuc = () =>
  useQuery({ queryKey: ['linh-vuc'], queryFn: danhMucApi.getLinhVuc, staleTime: Infinity })

export const useDonVi = () =>
  useQuery({ queryKey: ['don-vi'], queryFn: danhMucApi.getDonVi, staleTime: Infinity })

export const useRoles = () =>
  useQuery({ queryKey: ['roles'], queryFn: danhMucApi.getRoles, staleTime: Infinity })
