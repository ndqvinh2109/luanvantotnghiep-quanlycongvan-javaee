import {
  Form, Input, DatePicker, Select, InputNumber, Button, Card,
  Row, Col, Space, Typography, Divider,
} from 'antd'
import { SaveOutlined, ArrowLeftOutlined } from '@ant-design/icons'
import { useNavigate, useParams } from 'react-router-dom'
import dayjs from 'dayjs'
import { useMutation, useQueryClient } from '@tanstack/react-query'
import { vanBanDiApi } from '@/api/vanBanDi'
import { useLoaiVanBan, useCapDoKhan, useCapDoBaoMat, useLinhVuc, useDonVi } from '@/hooks/useDanhMuc'
import type { VanBanDiRequest } from '@/types'
import { message } from 'antd'

const { Title } = Typography
const { TextArea } = Input

export default function VanBanDiFormPage() {
  const { id } = useParams<{ id: string }>()
  const isEdit = !!id
  const navigate = useNavigate()
  const qc = useQueryClient()
  const [form] = Form.useForm()

  const { data: loaiVanBans } = useLoaiVanBan()
  const { data: capDoKhans } = useCapDoKhan()
  const { data: capDoBaoMats } = useCapDoBaoMat()
  const { data: linhVucs } = useLinhVuc()
  const { data: donVis } = useDonVi()

  const mutation = useMutation({
    mutationFn: (data: VanBanDiRequest) =>
      isEdit ? vanBanDiApi.update(Number(id), data) : vanBanDiApi.create(data),
    onSuccess: () => {
      qc.invalidateQueries({ queryKey: ['van-ban-di'] })
      message.success(isEdit ? 'Cập nhật thành công' : 'Thêm văn bản đi thành công')
      navigate('/van-ban-di')
    },
    onError: () => message.error('Có lỗi xảy ra, vui lòng thử lại'),
  })

  const onFinish = (values: Record<string, unknown>) => {
    const payload: VanBanDiRequest = {
      ...values as VanBanDiRequest,
      ngayBanHanh: dayjs(values.ngayBanHanh as dayjs.Dayjs).format('YYYY-MM-DD'),
      ngayDi: values.ngayDi ? dayjs(values.ngayDi as dayjs.Dayjs).format('YYYY-MM-DD') : undefined,
    }
    mutation.mutate(payload)
  }

  return (
    <div>
      <div style={{ display: 'flex', alignItems: 'center', gap: 12, marginBottom: 16 }}>
        <Button icon={<ArrowLeftOutlined />} onClick={() => navigate('/van-ban-di')}>Quay lại</Button>
        <Title level={4} style={{ margin: 0 }}>
          {isEdit ? 'Chỉnh sửa văn bản đi' : 'Thêm văn bản đi mới'}
        </Title>
      </div>

      <Form form={form} layout="vertical" onFinish={onFinish}>
        <Row gutter={24}>
          <Col xs={24} lg={16}>
            <Card title="Thông tin văn bản">
              <Row gutter={16}>
                <Col xs={24} sm={12}>
                  <Form.Item name="soKyHieuVanBan" label="Số ký hiệu"
                    rules={[{ required: true, message: 'Vui lòng nhập số ký hiệu' }]}>
                    <Input placeholder="VD: 456/CV-UBND" />
                  </Form.Item>
                </Col>
                <Col xs={24} sm={12}>
                  <Form.Item name="soDi" label="Số đi">
                    <InputNumber style={{ width: '100%' }} min={1} />
                  </Form.Item>
                </Col>
                <Col xs={24} sm={12}>
                  <Form.Item name="ngayBanHanh" label="Ngày ban hành"
                    rules={[{ required: true, message: 'Vui lòng chọn ngày' }]}>
                    <DatePicker style={{ width: '100%' }} format="DD/MM/YYYY" />
                  </Form.Item>
                </Col>
                <Col xs={24} sm={12}>
                  <Form.Item name="ngayDi" label="Ngày đi">
                    <DatePicker style={{ width: '100%' }} format="DD/MM/YYYY" />
                  </Form.Item>
                </Col>
                <Col xs={24}>
                  <Form.Item name="trichYeu" label="Trích yếu nội dung"
                    rules={[{ required: true, message: 'Vui lòng nhập trích yếu' }]}>
                    <TextArea rows={4} placeholder="Nội dung trích yếu..." />
                  </Form.Item>
                </Col>
                <Col xs={24} sm={12}>
                  <Form.Item name="nguoiKy" label="Người ký">
                    <Input placeholder="Tên người ký" />
                  </Form.Item>
                </Col>
                <Col xs={24} sm={12}>
                  <Form.Item name="soTrang" label="Số trang">
                    <InputNumber style={{ width: '100%' }} min={1} />
                  </Form.Item>
                </Col>
              </Row>
            </Card>
          </Col>

          <Col xs={24} lg={8}>
            <Card title="Phân loại">
              <Form.Item name="maDonViList" label="Đơn vị nhận"
                rules={[{ required: true, message: 'Vui lòng chọn đơn vị nhận' }]}>
                <Select mode="multiple" placeholder="Chọn đơn vị nhận" showSearch optionFilterProp="label"
                  options={donVis?.map((d) => ({ value: d.maDonVi, label: d.tenDonVi }))} />
              </Form.Item>
              <Form.Item name="maLoai" label="Loại văn bản">
                <Select placeholder="Chọn loại" allowClear
                  options={loaiVanBans?.map((l) => ({ value: l.maLoai, label: l.tenLoai }))} />
              </Form.Item>
              <Divider />
              <Form.Item name="maDoKhan" label="Độ khẩn">
                <Select placeholder="Chọn độ khẩn" allowClear
                  options={capDoKhans?.map((c) => ({ value: c.maDoKhan, label: c.tenDoKhan }))} />
              </Form.Item>
              <Form.Item name="maDoMat" label="Độ mật">
                <Select placeholder="Chọn độ mật" allowClear
                  options={capDoBaoMats?.map((c) => ({ value: c.maDoMat, label: c.tenDoMat }))} />
              </Form.Item>
              <Form.Item name="maLinhVuc" label="Lĩnh vực">
                <Select placeholder="Chọn lĩnh vực" allowClear
                  options={linhVucs?.map((l) => ({ value: l.maLinhVuc, label: l.tenLinhVuc }))} />
              </Form.Item>
            </Card>

            <Card style={{ marginTop: 16 }}>
              <Space direction="vertical" style={{ width: '100%' }}>
                <Button type="primary" htmlType="submit" block size="large"
                  icon={<SaveOutlined />} loading={mutation.isPending}>
                  {isEdit ? 'Lưu thay đổi' : 'Thêm văn bản đi'}
                </Button>
                <Button block onClick={() => navigate('/van-ban-di')}>Hủy</Button>
              </Space>
            </Card>
          </Col>
        </Row>
      </Form>
    </div>
  )
}
