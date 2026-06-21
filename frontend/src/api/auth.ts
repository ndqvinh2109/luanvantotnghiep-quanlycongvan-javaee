import api from './axios'
import type { AuthResponse, LoginRequest } from '@/types'

export const authApi = {
  login: (data: LoginRequest) =>
    api.post<AuthResponse>('/auth/login', data).then((r) => r.data),
}
