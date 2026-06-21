import { useState } from 'react'
import { Outlet, useNavigate, useLocation } from 'react-router-dom'
import {
  Layout, Menu, Avatar, Dropdown, Badge, Typography, Space, Button, theme,
} from 'antd'
import {
  DashboardOutlined, FileTextOutlined, FileDoneOutlined, CheckSquareOutlined,
  TeamOutlined, MenuFoldOutlined, MenuUnfoldOutlined, LogoutOutlined,
  UserOutlined, BellOutlined, FileAddOutlined,
} from '@ant-design/icons'
import { useAuthStore } from '@/store/authStore'

const { Header, Sider, Content } = Layout
const { Text } = Typography

const menuItems = [
  { key: '/dashboard',      icon: <DashboardOutlined />,    label: 'Tổng quan' },
  {
    key: 'van-ban',
    icon: <FileTextOutlined />,
    label: 'Quản lý văn bản',
    children: [
      { key: '/van-ban-den', icon: <FileTextOutlined />,  label: 'Văn bản đến' },
      { key: '/van-ban-di',  icon: <FileDoneOutlined />,  label: 'Văn bản đi' },
    ],
  },
  { key: '/xu-ly-van-ban',  icon: <CheckSquareOutlined />, label: 'Xử lý văn bản' },
  { key: '/admin/nguoi-dung', icon: <TeamOutlined />,     label: 'Người dùng' },
]

export default function MainLayout() {
  const [collapsed, setCollapsed] = useState(false)
  const { token } = theme.useToken()
  const navigate = useNavigate()
  const location = useLocation()
  const { user, logout, hasRole } = useAuthStore()

  const visibleItems = menuItems.filter((item) => {
    if (item.key === '/admin/nguoi-dung') return hasRole('ROLE_QUAN_TRI_HE_THONG')
    return true
  })

  const userMenu = {
    items: [
      { key: 'logout', icon: <LogoutOutlined />, label: 'Đăng xuất', danger: true },
    ],
    onClick: ({ key }: { key: string }) => {
      if (key === 'logout') { logout(); navigate('/login') }
    },
  }

  return (
    <Layout style={{ minHeight: '100vh' }}>
      <Sider
        trigger={null}
        collapsible
        collapsed={collapsed}
        width={240}
        style={{ background: token.colorBgContainer, borderRight: `1px solid ${token.colorBorderSecondary}` }}
      >
        <div style={{ height: 64, display: 'flex', alignItems: 'center', justifyContent: 'center', padding: '0 16px' }}>
          <Space>
            <FileAddOutlined style={{ fontSize: 24, color: token.colorPrimary }} />
            {!collapsed && (
              <Text strong style={{ fontSize: 14, color: token.colorPrimary }}>
                Quản Lý Công Văn
              </Text>
            )}
          </Space>
        </div>

        <Menu
          mode="inline"
          selectedKeys={[location.pathname]}
          defaultOpenKeys={['van-ban']}
          items={visibleItems}
          onClick={({ key }) => navigate(key)}
          style={{ borderRight: 'none' }}
        />
      </Sider>

      <Layout>
        <Header
          style={{
            padding: '0 24px',
            background: token.colorBgContainer,
            borderBottom: `1px solid ${token.colorBorderSecondary}`,
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'space-between',
          }}
        >
          <Button
            type="text"
            icon={collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
            onClick={() => setCollapsed(!collapsed)}
            style={{ fontSize: 16, width: 40, height: 40 }}
          />

          <Space size={16}>
            <Badge count={0}>
              <Button type="text" icon={<BellOutlined style={{ fontSize: 18 }} />} />
            </Badge>

            <Dropdown menu={userMenu} placement="bottomRight">
              <Space style={{ cursor: 'pointer' }}>
                <Avatar icon={<UserOutlined />} style={{ background: token.colorPrimary }} />
                <Text>{user?.tenNguoiDung}</Text>
              </Space>
            </Dropdown>
          </Space>
        </Header>

        <Content style={{ margin: 24, minHeight: 'calc(100vh - 112px)' }}>
          <Outlet />
        </Content>
      </Layout>
    </Layout>
  )
}
