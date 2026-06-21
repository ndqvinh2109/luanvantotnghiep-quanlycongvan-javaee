import { useState } from 'react'
import {
  Table, Button, Space, Card, Typography, Tag, Tabs, Tooltip,
} from 'antd'
import { EyeOutlined } from '@ant-design/icons'
import { useNavigate } from 'react-router-dom'
import type { ColumnsType } from 'antd/es/table'
import dayjs from 'dayjs'
import { useQuery } from '@tanstack/react-query'
import { vanBanDenApi } from '@/api/vanBanDen'
import { vanBanDiApi } from '@/api/vanBanDi'
import TrangThaiTag from '@/components/TrangThaiTag'
import type { VanBanDenResponse, VanBanDiResponse } from '@/types'

const { Title } = Typography

const STATUS_PENDING = [0, 1, 2]

export default function XuLyVanBanPage() {
  const navigate = useNavigate()
  const [page, setPage] = useState(0)
  const size = 20

  const { data: denData, isLoading: loadingDen } = useQuery({
    queryKey: ['xu-ly-van-ban-den', { page, size }],
    queryFn: () => vanBanDenApi.getAll({ page, size }),
  })

  const { data: diData, isLoading: loadingDi } = useQuery({
    queryKey: ['xu-ly-van-ban-di', { page, size }],
    queryFn: () => vanBanDiApi.getAll({ page, size }),
  })

  const denPending = denData?.content.filter((v) => STATUS_PENDING.includes(v.trangThaiXuLy)) ?? []
  const diPending = diData?.content.filter((v) => STATUS_PENDING.includes(v.trangThaiXuLy)) ?? []

  const denColumns: ColumnsType<VanBanDenResponse> = [
    { title: 'Số đến', dataIndex: 'soDen', key: 'soDen', width: 80, render: (v) => v ?? '—' },
    { title: 'Số ký hiệu', dataIndex: 'soKyHieuVanBan', key: 'soKyHieuVanBan', width: 160 },
    { title: 'Trích yếu', dataIndex: 'trichYeu', key: 'trichYeu', ellipsis: true },
    {
      title: 'Đơn vị gửi',
      key: 'donVi',
      width: 180,
      render: (_, r) => r.donVi?.ten ?? '—',
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
      width: 140,
      render: (v: number) => <TrangThaiTag value={v} />,
    },
    {
      title: '',
      key: 'action',
      width: 60,
      fixed: 'right',
      render: (_, record) => (
        <Tooltip title="Xem chi tiết">
          <Button type="text" size="small" icon={<EyeOutlined />}
            onClick={() => navigate(`/van-ban-den/${record.maVanBan}`)} />
        </Tooltip>
      ),
    },
  ]

  const diColumns: ColumnsType<VanBanDiResponse> = [
    { title: 'Số đi', dataIndex: 'soDi', key: 'soDi', width: 80, render: (v) => v ?? '—' },
    { title: 'Số ký hiệu', dataIndex: 'soKyHieuVanBan', key: 'soKyHieuVanBan', width: 160 },
    { title: 'Trích yếu', dataIndex: 'trichYeu', key: 'trichYeu', ellipsis: true },
    {
      title: 'Đơn vị nhận',
      key: 'donViNhan',
      width: 200,
      render: (_, r) => (
        <Space wrap size={4}>
          {r.donViNhanList.map((d) => <Tag key={d.id}>{d.ten}</Tag>)}
        </Space>
      ),
    },
    {
      title: 'Ngày đi',
      dataIndex: 'ngayDi',
      key: 'ngayDi',
      width: 110,
      render: (v: string) => v ? dayjs(v).format('DD/MM/YYYY') : '—',
    },
    {
      title: 'Trạng thái',
      dataIndex: 'trangThaiXuLy',
      key: 'trangThaiXuLy',
      width: 140,
      render: (v: number) => <TrangThaiTag value={v} />,
    },
    {
      title: '',
      key: 'action',
      width: 60,
      fixed: 'right',
      render: (_, record) => (
        <Tooltip title="Xem chi tiết">
          <Button type="text" size="small" icon={<EyeOutlined />}
            onClick={() => navigate(`/van-ban-di/${record.maVanBan}`)} />
        </Tooltip>
      ),
    },
  ]

  const tabItems = [
    {
      key: 'den',
      label: (
        <Space>
          Văn bản đến
          {denPending.length > 0 && (
            <Tag color="warning" style={{ marginLeft: 4 }}>{denPending.length}</Tag>
          )}
        </Space>
      ),
      children: (
        <Table<VanBanDenResponse>
          dataSource={denData?.content}
          columns={denColumns}
          rowKey="maVanBan"
          loading={loadingDen}
          scroll={{ x: 1000 }}
          rowClassName={(r) => STATUS_PENDING.includes(r.trangThaiXuLy) ? 'ant-table-row-warning' : ''}
          pagination={{
            current: page + 1,
            pageSize: size,
            total: denData?.totalElements ?? 0,
            showTotal: (total) => `Tổng ${total} văn bản`,
            onChange: (p) => setPage(p - 1),
          }}
          size="middle"
        />
      ),
    },
    {
      key: 'di',
      label: (
        <Space>
          Văn bản đi
          {diPending.length > 0 && (
            <Tag color="warning" style={{ marginLeft: 4 }}>{diPending.length}</Tag>
          )}
        </Space>
      ),
      children: (
        <Table<VanBanDiResponse>
          dataSource={diData?.content}
          columns={diColumns}
          rowKey="maVanBan"
          loading={loadingDi}
          scroll={{ x: 1000 }}
          rowClassName={(r) => STATUS_PENDING.includes(r.trangThaiXuLy) ? 'ant-table-row-warning' : ''}
          pagination={{
            current: page + 1,
            pageSize: size,
            total: diData?.totalElements ?? 0,
            showTotal: (total) => `Tổng ${total} văn bản`,
            onChange: (p) => setPage(p - 1),
          }}
          size="middle"
        />
      ),
    },
  ]

  return (
    <div>
      <div style={{ marginBottom: 16 }}>
        <Title level={4} style={{ margin: 0 }}>Xử lý văn bản</Title>
      </div>

      <Card>
        <Tabs defaultActiveKey="den" items={tabItems} onChange={() => setPage(0)} />
      </Card>
    </div>
  )
}
