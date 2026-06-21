import { Navigate } from 'react-router-dom'
import { Result, Button } from 'antd'
import { useAuthStore } from '@/store/authStore'

interface Props {
  children: React.ReactNode
  role?: string
}

export default function ProtectedRoute({ children, role }: Props) {
  const { isAuthenticated, hasRole } = useAuthStore()

  if (!isAuthenticated) return <Navigate to="/login" replace />

  if (role && !hasRole(role)) {
    return (
      <Result
        status="403"
        title="403"
        subTitle="Bạn không có quyền truy cập trang này."
        extra={<Button type="primary" href="/dashboard">Về trang chủ</Button>}
      />
    )
  }

  return <>{children}</>
}
