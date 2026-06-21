import { useEffect } from 'react'
import {
  Form, Input, DatePicker, Select, InputNumber, Button, Card,
  Row, Col, Space, Typography, Divider, Upload, Spin,
} from 'antd'
import { SaveOutlined, ArrowLeftOutlined, UploadOutlined } from '@ant-design/icons'
import { useNavigate, useParams } from 'react-router-dom'
import dayjs from 'dayjs'
import {
  useCreateVanBanDen, useUpdateVanBanDen, useVanBanDenDetail,
} from '@/hooks/useVanBanDen'
import {
  useLoaiVanBan, useCapDoKhan, useCapDoBaoMat, useLinhVuc, useDonVi,
} from '@/hooks/useDanhMuc'
import { vanBanDenApi } from '@/api/vanBanDen'
import type { VanBanDenRequest } from '@/types'

const { Title } = Typography
const { TextArea } = Input

export default function VanBanDenFormPage() {
  const { id } = useParams<{ id: string }>()
  const isEdit = !!id
  const navigate = useNavigate()
  const [form] = Form.useForm<VanBanDenRequest>()

  const { data: existing, isLoading: loadingDetail } = useVanBanDenDetail(Number(id))
  const createMutation = useCreateVanBanDen()
  const updateMutation = useUpdateVanBanDen(Number(id))

  const { data: loaiVanBans } = useLoaiVanBan()
  const { data: capDoKhans } = useCapDoKhan()
  const { data: capDoBaoMats } = useCapDoBaoMat()
  const { data: linhVucs } = useLinhVuc()
  const { data: donVis } = useDonVi()

  useEffect(() => {
    if (existing && isEdit) {
      form.setFieldsValue({
        soKyHieuVanBan: existing.soKyHieuVanBan,
        trichYeu: existing.trichYeu,
        nguoiKy: existing.nguoiKy ?? undefined,
        soTrang: existing.soTrang ?? undefined,
        tuKhoa: existing.tuKhoa ?? undefined,
        soDen: existing.soDen ?? undefined,
        ngayBanHanh: existing.ngayBanHanh as unknown as string,
        ngayHieuLuc: existing.ngayHieuLuc as unknown as string ?? undefined,
        ngayHetHieuLuc: existing.ngayHetHieuLuc as unknown as string ?? undefined,
        ngayDen: existing.ngayDen as unknown as string,
        maDonVi: existing.donVi?.id,
        maLoai: existing.loaiVanBan?.id,
        maDoKhan: existing.capDoKhan?.id,
        maDoMat: existing.capDoBaoMat?.id,
        maLinhVuc: existing.linhVuc?.id,
      })
    }
  }, [existing, isEdit, form])

  const onFinish = (values: Record<string, unknown>) => {
    const payload: VanBanDenRequest = {
      ...values as VanBanDenRequest,
      ngayBanHanh: dayjs(values.ngayBanHanh as dayjs.Dayjs).format('YYYY-MM-DD'),
      ngayDen: dayjs(values.ngayDen as dayjs.Dayjs).format('YYYY-MM-DD'),
      ngayHieuLuc: values.ngayHieuLuc ? dayjs(values.ngayHieuLuc as dayjs.Dayjs).format('YYYY-MM-DD') : undefined,
      ngayHetHieuLuc: values.ngayHetHieuLuc ? dayjs(values.ngayHetHieuLuc as dayjs.Dayjs).format('YYYY-MM-DD') : undefined,
    }
    const onSuccess = () => navigate('/van-ban-den')
    if (isEdit) {
      updateMutation.mutate(payload, { onSuccess })
    } else {
      createMutation.mutate(payload, { onSuccess })
    }
  }

  const isPending = createMutation.isPending || updateMutation.isPending

  return (
    <Spin spinning={isEdit && loadingDetail}>
      <div style={{ marginBottom: 16, display: 'flex', alignItems: 'center', gap: 12 }}>
        <Button icon={<ArrowLeftOutlined />} onClick={() => navigate('/van-ban-den')}>
          Quay lại
        </Button>
        <Title level={4} style={{ margin: 0 }}>
          {isEdit ? 'Chỉnh sửa văn bản đến' : 'Thêm văn bản đến mới'}
        </Title>
      </div>

      <Form form={form} layout="vertical" onFinish={onFinish}>
        <Row gutter={24}>
          <Col xs={24} lg={16}>
            <Card title="Thông tin văn bản" style={{ marginBottom: 16 }}>
              <Row gutter={16}>
                <Col xs={24} sm={12}>
                  <Form.Item
                    name="soKyHieuVanBan"
                    label="Số ký hiệu văn bản"
                    rules={[{ required: true, message: 'Vui lòng nhập số ký hiệu' }]}
                  >
                    <Input placeholder="VD: 123/CV-BNV" />
                  </Form.Item>
                </Col>
                <Col xs={24} sm={12}>
                  <Form.Item
                    name="soDen"
                    label="Số đến"
                  >
                    <InputNumber style={{ width: '100%' }} placeholder="Số đến" min={1} />
                  </Form.Item>
                </Col>
                <Col xs={24} sm={12}>
                  <Form.Item
                    name="ngayBanHanh"
                    label="Ngày ban hành"
                    rules={[{ required: true, message: 'Vui lòng chọn ngày ban hành' }]}
                  >
                    <DatePicker style={{ width: '100%' }} format="DD/MM/YYYY" />
                  </Form.Item>
                </Col>
                <Col xs={24} sm={12}>
                  <Form.Item
                    name="ngayDen"
                    label="Ngày đến"
                    rules={[{ required: true, message: 'Vui lòng chọn ngày đến' }]}
                  >
                    <DatePicker style={{ width: '100%' }} format="DD/MM/YYYY" />
                  </Form.Item>
                </Col>
                <Col xs={24} sm={12}>
                  <Form.Item name="ngayHieuLuc" label="Ngày hiệu lực">
                    <DatePicker style={{ width: '100%' }} format="DD/MM/YYYY" />
                  </Form.Item>
                </Col>
                <Col xs={24} sm={12}>
                  <Form.Item name="ngayHetHieuLuc" label="Ngày hết hiệu lực">
                    <DatePicker style={{ width: '100%' }} format="DD/MM/YYYY" />
                  </Form.Item>
                </Col>
                <Col xs={24}>
                  <Form.Item
                    name="trichYeu"
                    label="Trích yếu nội dung"
                    rules={[{ required: true, message: 'Vui lòng nhập trích yếu' }]}
                  >
                    <TextArea rows={4} placeholder="Nội dung trích yếu văn bản..." />
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
                <Col xs={24}>
                  <Form.Item name="tuKhoa" label="Từ khóa">
                    <Input placeholder="Từ khóa tìm kiếm, cách nhau bằng dấu phẩy" />
                  </Form.Item>
                </Col>
              </Row>
            </Card>

            {isEdit && existing && (
              <Card title="File đính kèm">
                <Upload
                  customRequest={({ file, onSuccess: onOk, onError }) => {
                    vanBanDenApi.uploadFile(existing.maVanBan, file as File)
                      .then(() => onOk?.(null))
                      .catch(onError)
                  }}
                  showUploadList={{ showRemoveIcon: false }}
                >
                  <Button icon={<UploadOutlined />}>Tải lên file đính kèm</Button>
                </Upload>
              </Card>
            )}
          </Col>

          <Col xs={24} lg={8}>
            <Card title="Phân loại">
              <Form.Item
                name="maDonVi"
                label="Đơn vị gửi"
                rules={[{ required: true, message: 'Vui lòng chọn đơn vị' }]}
              >
                <Select
                  placeholder="Chọn đơn vị"
                  showSearch
                  optionFilterProp="label"
                  options={donVis?.map((d) => ({ value: d.maDonVi, label: d.tenDonVi }))}
                />
              </Form.Item>

              <Form.Item name="maLoai" label="Loại văn bản">
                <Select
                  placeholder="Chọn loại văn bản"
                  allowClear
                  options={loaiVanBans?.map((l) => ({ value: l.maLoai, label: l.tenLoai }))}
                />
              </Form.Item>

              <Divider />

              <Form.Item name="maDoKhan" label="Độ khẩn">
                <Select
                  placeholder="Chọn độ khẩn"
                  allowClear
                  options={capDoKhans?.map((c) => ({ value: c.maDoKhan, label: c.tenDoKhan }))}
                />
              </Form.Item>

              <Form.Item name="maDoMat" label="Độ mật">
                <Select
                  placeholder="Chọn độ mật"
                  allowClear
                  options={capDoBaoMats?.map((c) => ({ value: c.maDoMat, label: c.tenDoMat }))}
                />
              </Form.Item>

              <Form.Item name="maLinhVuc" label="Lĩnh vực">
                <Select
                  placeholder="Chọn lĩnh vực"
                  allowClear
                  options={linhVucs?.map((l) => ({ value: l.maLinhVuc, label: l.tenLinhVuc }))}
                />
              </Form.Item>
            </Card>

            <Card style={{ marginTop: 16 }}>
              <Space direction="vertical" style={{ width: '100%' }}>
                <Button
                  type="primary" htmlType="submit" block size="large"
                  icon={<SaveOutlined />} loading={isPending}
                >
                  {isEdit ? 'Lưu thay đổi' : 'Thêm văn bản đến'}
                </Button>
                <Button block onClick={() => navigate('/van-ban-den')}>
                  Hủy
                </Button>
              </Space>
            </Card>
          </Col>
        </Row>
      </Form>
    </Spin>
  )
}
