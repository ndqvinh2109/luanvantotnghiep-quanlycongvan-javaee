import { createBrowserRouter, Navigate } from 'react-router-dom'
import MainLayout from '@/layouts/MainLayout'
import AuthLayout from '@/layouts/AuthLayout'
import ProtectedRoute from '@/components/ProtectedRoute'
import LoginPage from '@/pages/Login'
import DashboardPage from '@/pages/Dashboard'
import VanBanDenListPage from '@/pages/VanBanDen/ListPage'
import VanBanDenFormPage from '@/pages/VanBanDen/FormPage'
import VanBanDenDetailPage from '@/pages/VanBanDen/DetailPage'
import VanBanDiListPage from '@/pages/VanBanDi/ListPage'
import VanBanDiFormPage from '@/pages/VanBanDi/FormPage'
import VanBanDiDetailPage from '@/pages/VanBanDi/DetailPage'
import NguoiDungPage from '@/pages/NguoiDung'
import XuLyVanBanPage from '@/pages/XuLyVanBan'

export const router = createBrowserRouter([
  {
    path: '/',
    element: <Navigate to="/dashboard" replace />,
  },
  {
    element: <AuthLayout />,
    children: [{ path: '/login', element: <LoginPage /> }],
  },
  {
    element: (
      <ProtectedRoute>
        <MainLayout />
      </ProtectedRoute>
    ),
    children: [
      { path: '/dashboard', element: <DashboardPage /> },
      { path: '/van-ban-den', element: <VanBanDenListPage /> },
      { path: '/van-ban-den/them', element: <VanBanDenFormPage /> },
      { path: '/van-ban-den/:id', element: <VanBanDenDetailPage /> },
      { path: '/van-ban-den/:id/sua', element: <VanBanDenFormPage /> },
      { path: '/van-ban-di', element: <VanBanDiListPage /> },
      { path: '/van-ban-di/them', element: <VanBanDiFormPage /> },
      { path: '/van-ban-di/:id', element: <VanBanDiDetailPage /> },
      { path: '/van-ban-di/:id/sua', element: <VanBanDiFormPage /> },
      { path: '/xu-ly-van-ban', element: <XuLyVanBanPage /> },
      {
        path: '/admin/nguoi-dung',
        element: (
          <ProtectedRoute role="ROLE_QUAN_TRI_HE_THONG">
            <NguoiDungPage />
          </ProtectedRoute>
        ),
      },
    ],
  },
])
