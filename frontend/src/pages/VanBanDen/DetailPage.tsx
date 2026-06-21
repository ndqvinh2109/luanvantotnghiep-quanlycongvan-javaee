import {
  Descriptions, Card, Button, Space, Tag, Typography, Spin,
  Table, Empty, Divider,
} from 'antd'
import { ArrowLeftOutlined, EditOutlined, PaperClipOutlined, DownloadOutlined } from '@ant-design/icons'
import { useNavigate, useParams } from 'react-router-dom'
import dayjs from 'dayjs'
import { useVanBanDenDetail } from '@/hooks/useVanBanDen'
import TrangThaiTag from '@/components/TrangThaiTag'
import type { FileDinhKemResponse } from '@/types'
import { useAuthStore } from '@/store/authStore'

const { Title } = Typography

export default function VanBanDenDetailPage() {
  const { id } = useParams<{ id: string }>()
  const navigate = useNavigate()
  const hasRole = useAuthStore((s) => s.hasRole)
  const canEdit = hasRole('ROLE_VAN_THU') || hasRole('ROLE_QUAN_TRI_HE_THONG')

  const { data, isLoading } = useVanBanDenDetail(Number(id))

  const fileColumns = [
    {
      title: 'Tên file',
      dataIndex: 'tenFile',
      key: 'tenFile',
      render: (v: string) => (
        <Space>
          <PaperClipOutlined />
          {v}
        </Space>
      ),
    },
    {
      title: 'Loại',
      dataIndex: 'loaiFile',
      key: 'loaiFile',
      width: 150,
    },
    {
      title: 'Kích thước',
      dataIndex: 'kichThuoc',
      key: 'kichThuoc',
      width: 120,
      render: (v: number) => v ? `${(v / 1024).toFixed(1)} KB` : '—',
    },
    {
      title: '',
      key: 'action',
      width: 60,
      render: (_: unknown, r: FileDinhKemResponse) => (
        <Button type="link" size="small" icon={<DownloadOutlined />}
          href={`/api/files/download/${r.maFile}`} target="_blank" />
      ),
    },
  ]

  if (isLoading) return <Spin style={{ display: 'block', marginTop: 80 }} />
  if (!data) return <Empty description="Không tìm thấy văn bản" />

  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 16 }}>
        <Space>
          <Button icon={<ArrowLeftOutlined />} onClick={() => navigate('/van-ban-den')}>
            Quay lại
          </Button>
          <Title level={4} style={{ margin: 0 }}>Chi tiết văn bản đến</Title>
        </Space>
        {canEdit && (
          <Button
            type="primary" icon={<EditOutlined />}
            onClick={() => navigate(`/van-ban-den/${id}/sua`)}
          >
            Chỉnh sửa
          </Button>
        )}
      </div>

      <Card>
        <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 16 }}>
          <Title level={5} style={{ margin: 0 }}>{data.soKyHieuVanBan}</Title>
          <TrangThaiTag value={data.trangThaiXuLy} />
        </div>

        <Descriptions bordered column={{ xs: 1, sm: 2, md: 3 }} size="small">
          <Descriptions.Item label="Số đến">{data.soDen ?? '—'}</Descriptions.Item>
          <Descriptions.Item label="Ngày đến">
            {data.ngayDen ? dayjs(data.ngayDen).format('DD/MM/YYYY') : '—'}
          </Descriptions.Item>
          <Descriptions.Item label="Ngày ban hành">
            {data.ngayBanHanh ? dayjs(data.ngayBanHanh).format('DD/MM/YYYY') : '—'}
          </Descriptions.Item>
          <Descriptions.Item label="Ngày hiệu lực">
            {data.ngayHieuLuc ? dayjs(data.ngayHieuLuc).format('DD/MM/YYYY') : '—'}
          </Descriptions.Item>
          <Descriptions.Item label="Ngày hết hiệu lực">
            {data.ngayHetHieuLuc ? dayjs(data.ngayHetHieuLuc).format('DD/MM/YYYY') : '—'}
          </Descriptions.Item>
          <Descriptions.Item label="Ngày nhập máy">
            {data.ngayNhapMay ? dayjs(data.ngayNhapMay).format('DD/MM/YYYY') : '—'}
          </Descriptions.Item>
          <Descriptions.Item label="Đơn vị gửi" span={2}>
            {data.donVi?.ten ?? '—'}
          </Descriptions.Item>
          <Descriptions.Item label="Người ký">{data.nguoiKy ?? '—'}</Descriptions.Item>
          <Descriptions.Item label="Loại văn bản">
            {data.loaiVanBan ? <Tag>{data.loaiVanBan.ten}</Tag> : '—'}
          </Descriptions.Item>
          <Descriptions.Item label="Độ khẩn">
            {data.capDoKhan ? <Tag color="warning">{data.capDoKhan.ten}</Tag> : '—'}
          </Descriptions.Item>
          <Descriptions.Item label="Độ mật">
            {data.capDoBaoMat ? <Tag color="error">{data.capDoBaoMat.ten}</Tag> : '—'}
          </Descriptions.Item>
          <Descriptions.Item label="Lĩnh vực">{data.linhVuc?.ten ?? '—'}</Descriptions.Item>
          <Descriptions.Item label="Số trang">{data.soTrang ?? '—'}</Descriptions.Item>
          <Descriptions.Item label="Từ khóa">{data.tuKhoa ?? '—'}</Descriptions.Item>
          <Descriptions.Item label="Trích yếu" span={3}>
            <div style={{ whiteSpace: 'pre-wrap' }}>{data.trichYeu}</div>
          </Descriptions.Item>
        </Descriptions>

        {data.fileDinhKems.length > 0 && (
          <>
            <Divider>File đính kèm</Divider>
            <Table<FileDinhKemResponse>
              dataSource={data.fileDinhKems}
              columns={fileColumns}
              rowKey="maFile"
              pagination={false}
              size="small"
            />
          </>
        )}
      </Card>
    </div>
  )
}
