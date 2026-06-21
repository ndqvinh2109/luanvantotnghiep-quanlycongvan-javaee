import { create } from 'zustand'
import { persist } from 'zustand/middleware'
import type { AuthResponse } from '@/types'

interface AuthState {
  user: Omit<AuthResponse, 'accessToken' | 'refreshToken' | 'tokenType'> | null
  accessToken: string | null
  isAuthenticated: boolean
  login: (response: AuthResponse) => void
  logout: () => void
  hasRole: (role: string) => boolean
}

export const useAuthStore = create<AuthState>()(
  persist(
    (set, get) => ({
      user: null,
      accessToken: null,
      isAuthenticated: false,

      login: (response) => {
        localStorage.setItem('accessToken', response.accessToken)
        localStorage.setItem('refreshToken', response.refreshToken)
        set({
          accessToken: response.accessToken,
          isAuthenticated: true,
          user: {
            userId: response.userId,
            username: response.username,
            tenNguoiDung: response.tenNguoiDung,
            roles: response.roles,
          },
        })
      },

      logout: () => {
        localStorage.removeItem('accessToken')
        localStorage.removeItem('refreshToken')
        set({ user: null, accessToken: null, isAuthenticated: false })
      },

      hasRole: (role) => get().user?.roles.includes(role) ?? false,
    }),
    {
      name: 'auth-storage',
      partialize: (state) => ({
        user: state.user,
        accessToken: state.accessToken,
        isAuthenticated: state.isAuthenticated,
      }),
    }
  )
)
