import { Card, Form, Input, Button, Typography, Alert, Space } from 'antd'
import { UserOutlined, LockOutlined, FileAddOutlined } from '@ant-design/icons'
import { useMutation } from '@tanstack/react-query'
import { useNavigate } from 'react-router-dom'
import { authApi } from '@/api/auth'
import { useAuthStore } from '@/store/authStore'
import type { LoginRequest } from '@/types'

const { Title, Text } = Typography

export default function LoginPage() {
  const navigate = useNavigate()
  const login = useAuthStore((s) => s.login)

  const { mutate, isPending, error } = useMutation({
    mutationFn: authApi.login,
    onSuccess: (data) => {
      login(data)
      navigate('/dashboard')
    },
  })

  return (
    <Card
      style={{ width: 400, boxShadow: '0 8px 32px rgba(0,0,0,0.15)' }}
      bordered={false}
    >
      <Space direction="vertical" size={24} style={{ width: '100%' }}>
        <div style={{ textAlign: 'center' }}>
          <FileAddOutlined style={{ fontSize: 48, color: '#1677ff' }} />
          <Title level={3} style={{ margin: '12px 0 4px' }}>
            Quản Lý Công Văn
          </Title>
          <Text type="secondary">Đăng nhập để tiếp tục</Text>
        </div>

        {error && (
          <Alert
            message="Tên đăng nhập hoặc mật khẩu không đúng"
            type="error"
            showIcon
          />
        )}

        <Form<LoginRequest>
          layout="vertical"
          onFinish={(values) => mutate(values)}
          size="large"
        >
          <Form.Item
            name="username"
            rules={[{ required: true, message: 'Vui lòng nhập tên đăng nhập' }]}
          >
            <Input prefix={<UserOutlined />} placeholder="Tên đăng nhập" />
          </Form.Item>

          <Form.Item
            name="password"
            rules={[{ required: true, message: 'Vui lòng nhập mật khẩu' }]}
          >
            <Input.Password prefix={<LockOutlined />} placeholder="Mật khẩu" />
          </Form.Item>

          <Form.Item style={{ marginBottom: 0 }}>
            <Button type="primary" htmlType="submit" block loading={isPending}>
              Đăng nhập
            </Button>
          </Form.Item>
        </Form>
      </Space>
    </Card>
  )
}
