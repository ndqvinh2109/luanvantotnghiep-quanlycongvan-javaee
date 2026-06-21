import { useState } from 'react'
import {
  Table, Button, Space, Input, Select, DatePicker, Card, Row, Col,
  Popconfirm, Typography, Tooltip, Tag,
} from 'antd'
import {
  PlusOutlined, SearchOutlined, ReloadOutlined,
  EditOutlined, DeleteOutlined, EyeOutlined,
} from '@ant-design/icons'
import { useNavigate } from 'react-router-dom'
import type { ColumnsType } from 'antd/es/table'
import dayjs from 'dayjs'
import { useVanBanDenList, useDeleteVanBanDen } from '@/hooks/useVanBanDen'
import { useLoaiVanBan, useDonVi } from '@/hooks/useDanhMuc'
import TrangThaiTag from '@/components/TrangThaiTag'
import type { VanBanDenResponse, VanBanDenSearchParams } from '@/types'
import { useAuthStore } from '@/store/authStore'

const { RangePicker } = DatePicker
const { Title } = Typography

export default function VanBanDenListPage() {
  const navigate = useNavigate()
  const hasRole = useAuthStore((s) => s.hasRole)
  const canEdit = hasRole('ROLE_VAN_THU') || hasRole('ROLE_QUAN_TRI_HE_THONG')

  const [params, setParams] = useState<VanBanDenSearchParams>({ page: 0, size: 20 })
  const [tuKhoa, setTuKhoa] = useState('')
  const [maLoai, setMaLoai] = useState<number>()
  const [maDonVi, setMaDonVi] = useState<number>()
  const [dateRange, setDateRange] = useState<[dayjs.Dayjs | null, dayjs.Dayjs | null] | null>(null)

  const { data, isLoading, refetch } = useVanBanDenList(params)
  const { data: loaiVanBans } = useLoaiVanBan()
  const { data: donVis } = useDonVi()
  const deleteMutation = useDeleteVanBanDen()

  const handleSearch = () => {
    setParams({
      tuKhoa: tuKhoa || undefined,
      maLoai,
      maDonVi,
      tuNgay: dateRange?.[0]?.format('YYYY-MM-DD'),
      denNgay: dateRange?.[1]?.format('YYYY-MM-DD'),
      page: 0,
      size: params.size,
    })
  }

  const handleReset = () => {
    setTuKhoa('')
    setMaLoai(undefined)
    setMaDonVi(undefined)
    setDateRange(null)
    setParams({ page: 0, size: 20 })
  }

  const columns: ColumnsType<VanBanDenResponse> = [
    {
      title: 'Số đến',
      dataIndex: 'soDen',
      key: 'soDen',
      width: 80,
      render: (v) => v ?? '—',
    },
    {
      title: 'Số ký hiệu',
      dataIndex: 'soKyHieuVanBan',
      key: 'soKyHieuVanBan',
      width: 160,
    },
    {
      title: 'Trích yếu',
      dataIndex: 'trichYeu',
      key: 'trichYeu',
      ellipsis: true,
    },
    {
      title: 'Đơn vị gửi',
      key: 'donVi',
      width: 200,
      render: (_, r) => r.donVi?.ten ?? '—',
      ellipsis: true,
    },
    {
      title: 'Loại văn bản',
      key: 'loaiVanBan',
      width: 160,
      render: (_, r) => r.loaiVanBan ? <Tag>{r.loaiVanBan.ten}</Tag> : '—',
    },
    {
      title: 'Ngày đến',
      dataIndex: 'ngayDen',
      key: 'ngayDen',
      width: 110,
      sorter: true,
      render: (v: string) => dayjs(v).format('DD/MM/YYYY'),
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
          <Tooltip title="Xem chi tiết">
            <Button
              type="text" size="small" icon={<EyeOutlined />}
              onClick={() => navigate(`/van-ban-den/${record.maVanBan}`)}
            />
          </Tooltip>
          {canEdit && (
            <>
              <Tooltip title="Chỉnh sửa">
                <Button
                  type="text" size="small" icon={<EditOutlined />}
                  onClick={() => navigate(`/van-ban-den/${record.maVanBan}/sua`)}
                />
              </Tooltip>
              <Popconfirm
                title="Xác nhận xóa?"
                description="Hành động này không thể hoàn tác."
                okText="Xóa" cancelText="Hủy" okButtonProps={{ danger: true }}
                onConfirm={() => deleteMutation.mutate(record.maVanBan)}
              >
                <Tooltip title="Xóa">
                  <Button type="text" size="small" danger icon={<DeleteOutlined />} />
                </Tooltip>
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
        <Title level={4} style={{ margin: 0 }}>Văn bản đến</Title>
        {canEdit && (
          <Button type="primary" icon={<PlusOutlined />} onClick={() => navigate('/van-ban-den/them')}>
            Thêm văn bản đến
          </Button>
        )}
      </div>

      <Card style={{ marginBottom: 16 }}>
        <Row gutter={[16, 12]}>
          <Col xs={24} sm={12} md={6}>
            <Input
              placeholder="Tìm theo số ký hiệu, trích yếu..."
              value={tuKhoa}
              onChange={(e) => setTuKhoa(e.target.value)}
              onPressEnter={handleSearch}
              prefix={<SearchOutlined />}
              allowClear
            />
          </Col>
          <Col xs={24} sm={12} md={5}>
            <Select
              placeholder="Loại văn bản"
              style={{ width: '100%' }}
              allowClear
              value={maLoai}
              onChange={setMaLoai}
              options={loaiVanBans?.map((l) => ({ value: l.maLoai, label: l.tenLoai }))}
            />
          </Col>
          <Col xs={24} sm={12} md={6}>
            <Select
              placeholder="Đơn vị gửi"
              style={{ width: '100%' }}
              allowClear
              showSearch
              value={maDonVi}
              onChange={setMaDonVi}
              optionFilterProp="label"
              options={donVis?.map((d) => ({ value: d.maDonVi, label: d.tenDonVi }))}
            />
          </Col>
          <Col xs={24} sm={12} md={5}>
            <RangePicker
              style={{ width: '100%' }}
              value={dateRange}
              onChange={(v) => setDateRange(v as [dayjs.Dayjs | null, dayjs.Dayjs | null] | null)}
              format="DD/MM/YYYY"
              placeholder={['Từ ngày', 'Đến ngày']}
            />
          </Col>
          <Col xs={24} sm={24} md={2}>
            <Space>
              <Button type="primary" icon={<SearchOutlined />} onClick={handleSearch} />
              <Button icon={<ReloadOutlined />} onClick={handleReset} />
            </Space>
          </Col>
        </Row>
      </Card>

      <Card>
        <Table<VanBanDenResponse>
          dataSource={data?.content}
          columns={columns}
          rowKey="maVanBan"
          loading={isLoading}
          scroll={{ x: 1100 }}
          pagination={{
            current: (params.page ?? 0) + 1,
            pageSize: params.size ?? 20,
            total: data?.totalElements ?? 0,
            showSizeChanger: true,
            showTotal: (total) => `Tổng ${total} văn bản`,
            onChange: (page, size) => setParams((p) => ({ ...p, page: page - 1, size })),
          }}
          size="middle"
        />
      </Card>
    </div>
  )
}
