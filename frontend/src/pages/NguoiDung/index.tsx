import { useState } from 'react'
import {
  Table, Button, Space, Card, Typography, Tag, Popconfirm, Modal, Form,
  Input, Select, Row, Col, Tooltip,
} from 'antd'
import { PlusOutlined, DeleteOutlined, UserOutlined } from '@ant-design/icons'
import type { ColumnsType } from 'antd/es/table'
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query'
import { nguoiDungApi } from '@/api/nguoiDung'
import { useDonVi } from '@/hooks/useDanhMuc'
import { useQuery as useRolesQuery } from '@tanstack/react-query'
import { danhMucApi } from '@/api/danhMuc'
import type { NguoiDungResponse, NguoiDungRequest } from '@/types'
import { message } from 'antd'

const { Title } = Typography

export default function NguoiDungPage() {
  const qc = useQueryClient()
  const [open, setOpen] = useState(false)
  const [form] = Form.useForm<NguoiDungRequest>()

  const { data, isLoading } = useQuery({
    queryKey: ['nguoi-dung'],
    queryFn: nguoiDungApi.getAll,
  })

  const { data: donVis } = useDonVi()
  const { data: roles } = useRolesQuery({
    queryKey: ['roles'],
    queryFn: danhMucApi.getRoles,
    staleTime: Infinity,
  })

  const createMutation = useMutation({
    mutationFn: (data: NguoiDungRequest) => nguoiDungApi.create(data),
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ['nguoi-dung'] })
      message.success('Thêm người dùng thành công')
      setOpen(false)
      form.resetFields()
    },
    onError: () => message.error('Có lỗi xảy ra, vui lòng thử lại'),
  })

  const deleteMutation = useMutation({
    mutationFn: (id: number) => nguoiDungApi.delete(id),
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ['nguoi-dung'] })
      message.success('Xóa người dùng thành công')
    },
    onError: () => message.error('Không thể xóa người dùng này'),
  })

  const columns: ColumnsType<NguoiDungResponse> = [
    { title: 'Họ tên', dataIndex: 'tenNguoiDung', key: 'tenNguoiDung' },
    { title: 'Tên đăng nhập', dataIndex: 'userName', key: 'userName', width: 160 },
    { title: 'Email', dataIndex: 'email', key: 'email', width: 200, render: (v) => v ?? '—' },
    { title: 'Điện thoại', dataIndex: 'soDienThoai', key: 'soDienThoai', width: 130, render: (v) => v ?? '—' },
    {
      title: 'Đơn vị',
      key: 'donVi',
      width: 200,
      render: (_, r) => r.donVi?.ten ?? '—',
      ellipsis: true,
    },
    {
      title: 'Vai trò',
      key: 'roles',
      width: 220,
      render: (_, r) => (
        <Space wrap size={4}>
          {r.roles.map((role) => (
            <Tag key={role.id} color="blue">{role.ten.replace('ROLE_', '')}</Tag>
          ))}
        </Space>
      ),
    },
    {
      title: 'Thao tác',
      key: 'action',
      width: 80,
      fixed: 'right',
      render: (_, record) => (
        <Popconfirm
          title="Xác nhận xóa người dùng?"
          description="Hành động này không thể hoàn tác."
          okText="Xóa" cancelText="Hủy" okButtonProps={{ danger: true }}
          onConfirm={() => deleteMutation.mutate(record.maNguoiDung)}
        >
          <Tooltip title="Xóa">
            <Button type="text" size="small" danger icon={<DeleteOutlined />} />
          </Tooltip>
        </Popconfirm>
      ),
    },
  ]

  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 16, alignItems: 'center' }}>
        <Title level={4} style={{ margin: 0 }}>Quản lý người dùng</Title>
        <Button type="primary" icon={<PlusOutlined />} onClick={() => setOpen(true)}>
          Thêm người dùng
        </Button>
      </div>

      <Card>
        <Table<NguoiDungResponse>
          dataSource={data}
          columns={columns}
          rowKey="maNguoiDung"
          loading={isLoading}
          scroll={{ x: 1000 }}
          pagination={{ pageSize: 20, showTotal: (total) => `Tổng ${total} người dùng` }}
          size="middle"
        />
      </Card>

      <Modal
        title={<Space><UserOutlined /> Thêm người dùng mới</Space>}
        open={open}
        onCancel={() => { setOpen(false); form.resetFields() }}
        onOk={() => form.submit()}
        okText="Thêm"
        cancelText="Hủy"
        confirmLoading={createMutation.isPending}
        width={620}
        destroyOnClose
      >
        <Form form={form} layout="vertical" onFinish={(values) => createMutation.mutate(values)}>
          <Row gutter={16}>
            <Col xs={24} sm={12}>
              <Form.Item name="tenNguoiDung" label="Họ và tên"
                rules={[{ required: true, message: 'Vui lòng nhập họ tên' }]}>
                <Input placeholder="Nguyễn Văn A" />
              </Form.Item>
            </Col>
            <Col xs={24} sm={12}>
              <Form.Item name="userName" label="Tên đăng nhập"
                rules={[{ required: true, message: 'Vui lòng nhập tên đăng nhập' }]}>
                <Input placeholder="nguyenvana" />
              </Form.Item>
            </Col>
            <Col xs={24} sm={12}>
              <Form.Item name="passWord" label="Mật khẩu"
                rules={[{ required: true, message: 'Vui lòng nhập mật khẩu' }, { min: 6, message: 'Tối thiểu 6 ký tự' }]}>
                <Input.Password placeholder="••••••••" />
              </Form.Item>
            </Col>
            <Col xs={24} sm={12}>
              <Form.Item name="email" label="Email"
                rules={[{ type: 'email', message: 'Email không hợp lệ' }]}>
                <Input placeholder="email@example.com" />
              </Form.Item>
            </Col>
            <Col xs={24} sm={12}>
              <Form.Item name="soDienThoai" label="Số điện thoại">
                <Input placeholder="0901234567" />
              </Form.Item>
            </Col>
            <Col xs={24} sm={12}>
              <Form.Item name="gioiTinh" label="Giới tính">
                <Select placeholder="Chọn giới tính" allowClear
                  options={[{ value: 0, label: 'Nam' }, { value: 1, label: 'Nữ' }, { value: 2, label: 'Khác' }]} />
              </Form.Item>
            </Col>
            <Col xs={24}>
              <Form.Item name="maDonVi" label="Đơn vị"
                rules={[{ required: true, message: 'Vui lòng chọn đơn vị' }]}>
                <Select placeholder="Chọn đơn vị" showSearch optionFilterProp="label"
                  options={donVis?.map((d) => ({ value: d.maDonVi, label: d.tenDonVi }))} />
              </Form.Item>
            </Col>
            <Col xs={24}>
              <Form.Item name="maRolesList" label="Vai trò"
                rules={[{ required: true, message: 'Vui lòng chọn ít nhất một vai trò' }]}>
                <Select mode="multiple" placeholder="Chọn vai trò"
                  options={roles?.map((r) => ({ value: r.maRoles, label: r.tenRoles.replace('ROLE_', '') }))} />
              </Form.Item>
            </Col>
          </Row>
        </Form>
      </Modal>
    </div>
  )
}
