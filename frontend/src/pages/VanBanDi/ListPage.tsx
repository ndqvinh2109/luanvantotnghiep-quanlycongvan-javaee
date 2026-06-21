import { useState } from 'react'
import { Table, Button, Space, Input, Card, Row, Col, Typography, Tooltip, Tag, Popconfirm } from 'antd'
import { PlusOutlined, SearchOutlined, ReloadOutlined, EyeOutlined, EditOutlined, DeleteOutlined } from '@ant-design/icons'
import { useNavigate } from 'react-router-dom'
import type { ColumnsType } from 'antd/es/table'
import dayjs from 'dayjs'
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query'
import { vanBanDiApi } from '@/api/vanBanDi'
import TrangThaiTag from '@/components/TrangThaiTag'
import type { VanBanDiResponse } from '@/types'
import { useAuthStore } from '@/store/authStore'
import { message } from 'antd'

const { Title } = Typography

export default function VanBanDiListPage() {
  const navigate = useNavigate()
  const qc = useQueryClient()
  const hasRole = useAuthStore((s) => s.hasRole)
  const canEdit = hasRole('ROLE_VAN_THU') || hasRole('ROLE_QUAN_TRI_HE_THONG')

  const [page, setPage] = useState(0)
  const [size, setSize] = useState(20)
  const [tuKhoa, setTuKhoa] = useState('')
  const [searchKey, setSearchKey] = useState('')

  const { data, isLoading } = useQuery({
    queryKey: ['van-ban-di', { page, size, tuKhoa: searchKey }],
    queryFn: () =>
      searchKey
        ? vanBanDiApi.search({ tuKhoa: searchKey, page, size })
        : vanBanDiApi.getAll({ page, size }),
  })

  const deleteMutation = useMutation({
    mutationFn: (id: number) => vanBanDiApi.delete(id),
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ['van-ban-di'] })
      message.success('Xóa văn bản đi thành công')
    },
  })

  const columns: ColumnsType<VanBanDiResponse> = [
    { title: 'Số đi', dataIndex: 'soDi', key: 'soDi', width: 80, render: (v) => v ?? '—' },
    { title: 'Số ký hiệu', dataIndex: 'soKyHieuVanBan', key: 'soKyHieuVanBan', width: 160 },
    { title: 'Trích yếu', dataIndex: 'trichYeu', key: 'trichYeu', ellipsis: true },
    {
      title: 'Đơn vị nhận',
      key: 'donViNhan',
      width: 200,
      render: (_, r) => r.donViNhanList.map((d) => <Tag key={d.id}>{d.ten}</Tag>),
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
      width: 130,
      render: (v: number) => <TrangThaiTag value={v} />,
    },
    {
      title: 'Thao tác',
      key: 'action',
      width: 120,
      fixed: 'right',
      render: (_, record) => (
        <Space size={4}>
          <Tooltip title="Xem">
            <Button type="text" size="small" icon={<EyeOutlined />}
              onClick={() => navigate(`/van-ban-di/${record.maVanBan}`)} />
          </Tooltip>
          {canEdit && (
            <>
              <Tooltip title="Sửa">
                <Button type="text" size="small" icon={<EditOutlined />}
                  onClick={() => navigate(`/van-ban-di/${record.maVanBan}/sua`)} />
              </Tooltip>
              <Popconfirm title="Xác nhận xóa?" okText="Xóa" cancelText="Hủy" okButtonProps={{ danger: true }}
                onConfirm={() => deleteMutation.mutate(record.maVanBan)}>
                <Button type="text" size="small" danger icon={<DeleteOutlined />} />
              </Popconfirm>
            </>
          )}
        </Space>
      ),
    },
  ]

  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 16, alignItems: 'center' }}>
        <Title level={4} style={{ margin: 0 }}>Văn bản đi</Title>
        {canEdit && (
          <Button type="primary" icon={<PlusOutlined />} onClick={() => navigate('/van-ban-di/them')}>
            Thêm văn bản đi
          </Button>
        )}
      </div>

      <Card style={{ marginBottom: 16 }}>
        <Row gutter={[16, 12]}>
          <Col xs={24} sm={16} md={10}>
            <Input placeholder="Tìm theo số ký hiệu, trích yếu..."
              value={tuKhoa} onChange={(e) => setTuKhoa(e.target.value)}
              onPressEnter={() => { setSearchKey(tuKhoa); setPage(0) }}
              prefix={<SearchOutlined />} allowClear />
          </Col>
          <Col>
            <Space>
              <Button type="primary" icon={<SearchOutlined />}
                onClick={() => { setSearchKey(tuKhoa); setPage(0) }} />
              <Button icon={<ReloadOutlined />}
                onClick={() => { setTuKhoa(''); setSearchKey(''); setPage(0) }} />
            </Space>
          </Col>
        </Row>
      </Card>

      <Card>
        <Table<VanBanDiResponse>
          dataSource={data?.content}
          columns={columns}
          rowKey="maVanBan"
          loading={isLoading}
          scroll={{ x: 1000 }}
          pagination={{
            current: page + 1,
            pageSize: size,
            total: data?.totalElements ?? 0,
            showSizeChanger: true,
            showTotal: (total) => `Tổng ${total} văn bản`,
            onChange: (p, s) => { setPage(p - 1); setSize(s) },
          }}
          size="middle"
        />
      </Card>
    </div>
  )
}
