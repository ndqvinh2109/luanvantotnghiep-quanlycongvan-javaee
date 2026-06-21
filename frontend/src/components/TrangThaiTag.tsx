import { Tag } from 'antd'
import { TRANG_THAI_XU_LY } from '@/types'

export default function TrangThaiTag({ value }: { value: number }) {
  const info = TRANG_THAI_XU_LY[value] ?? { label: 'Không rõ', color: 'default' }
  return <Tag color={info.color}>{info.label}</Tag>
}
