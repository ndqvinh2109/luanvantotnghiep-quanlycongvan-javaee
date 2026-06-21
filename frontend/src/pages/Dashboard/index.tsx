import { Row, Col, Card, Statistic, Typography, Table, Tag, Spin } from 'antd'
import {
  FileTextOutlined, FileDoneOutlined, CheckCircleOutlined, ClockCircleOutlined,
} from '@ant-design/icons'
import { useQuery } from '@tanstack/react-query'
import { vanBanDenApi } from '@/api/vanBanDen'
import { vanBanDiApi } from '@/api/vanBanDi'
import type { VanBanDenResponse } from '@/types'
import { TRANG_THAI_XU_LY } from '@/types'
import { useAuthStore } from '@/store/authStore'
import dayjs from 'dayjs'

const { Title } = Typography

export default function DashboardPage() {
  const user = useAuthStore((s) => s.user)

  const { data: vanBanDen, isLoading: loadingDen } = useQuery({
    queryKey: ['van-ban-den', { page: 0, size: 5 }],
    queryFn: () => vanBanDenApi.getAll({ page: 0, size: 5 }),
  })

  const { data: vanBanDi, isLoading: loadingDi } = useQuery({
    queryKey: ['van-ban-di', { page: 0, size: 1 }],
    queryFn: () => vanBanDiApi.getAll({ page: 0, size: 1 }),
  })

  const statCards = [
    {
      title: 'Tổng văn bản đến',
      value: vanBanDen?.totalElements ?? 0,
      icon: <FileTextOutlined style={{ fontSize: 24, color: '#1677ff' }} />,
      color: '#e6f4ff',
    },
    {
      title: 'Tổng văn bản đi',
      value: vanBanDi?.totalElements ?? 0,
      icon: <FileDoneOutlined style={{ fontSize: 24, color: '#52c41a' }} />,
      color: '#f6ffed',
    },
    {
      title: 'Đang xử lý',
      value: vanBanDen?.content.filter((v) => v.trangThaiXuLy === 2).length ?? 0,
      icon: <ClockCircleOutlined style={{ fontSize: 24, color: '#faad14' }} />,
      color: '#fffbe6',
    },
    {
      title: 'Hoàn thành',
      value: vanBanDen?.content.filter((v) => v.trangThaiXuLy === 3).length ?? 0,
      icon: <CheckCircleOutlined style={{ fontSize: 24, color: '#52c41a' }} />,
      color: '#f6ffed',
    },
  ]

  const columns = [
    { title: 'Số ký hiệu', dataIndex: 'soKyHieuVanBan', key: 'soKyHieuVanBan', width: 140 },
    {
      title: 'Trích yếu',
      dataIndex: 'trichYeu',
      key: 'trichYeu',
      ellipsis: true,
    },
    {
      title: 'Ngày đến',
      dataIndex: 'ngayDen',
      key: 'ngayDen',
      width: 110,
      render: (v: string) => dayjs(v).format('DD/MM/YYYY'),
    },
    {
      title: 'Trạng thái',
      dataIndex: 'trangThaiXuLy',
      key: 'trangThaiXuLy',
      width: 130,
      render: (v: number) => {
        const info = TRANG_THAI_XU_LY[v] ?? { label: 'Không rõ', color: 'default' }
        return <Tag color={info.color}>{info.label}</Tag>
      },
    },
  ]

  return (
    <div>
      <Title level={4} style={{ marginBottom: 24 }}>
        Xin chào, {user?.tenNguoiDung} 👋
      </Title>

      <Spin spinning={loadingDen || loadingDi}>
        <Row gutter={[16, 16]} style={{ marginBottom: 24 }}>
          {statCards.map((card) => (
            <Col xs={24} sm={12} lg={6} key={card.title}>
              <Card style={{ background: card.color, border: 'none' }}>
                <div style={{ display: 'flex', alignItems: 'center', gap: 16 }}>
                  <div>{card.icon}</div>
                  <Statistic title={card.title} value={card.value} />
                </div>
              </Card>
            </Col>
          ))}
        </Row>

        <Card title="Văn bản đến mới nhất">
          <Table<VanBanDenResponse>
            dataSource={vanBanDen?.content}
            columns={columns}
            rowKey="maVanBan"
            pagination={false}
            size="small"
          />
        </Card>
      </Spin>
    </div>
  )
}
