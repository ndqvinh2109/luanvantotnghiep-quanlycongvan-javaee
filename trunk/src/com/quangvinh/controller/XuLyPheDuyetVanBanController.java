package com.quangvinh.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.BuocXuLyPheDuyetVanBan;
import com.quangvinh.service.IBuocXuLyService;
import com.quangvinh.service.INguoiDungService;
import com.quangvinh.service.IQuyTrinhService;
import com.quangvinh.service.IVanBanDenService;
import com.quangvinh.service.IVanBanService;

@Controller
public class XuLyPheDuyetVanBanController {

	@Autowired
	private INguoiDungService nguoidungService;
	
	@Autowired
	private IBuocXuLyService buocxulyService;
	@Autowired
	private IVanBanService vanbanService;
	@Autowired
	private IQuyTrinhService quytrinhService;
	@Autowired
	private IVanBanDenService vanbandenService;
	
	@RequestMapping("/loadXuLyPheDuyetVanBan")
	public String pageXuLyPheDuyetVanBan(Map<String,Object> map){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); 
		int manguoidung = nguoidungService.getMaNguoiDungTheoUsername(name);
		System.out.println(manguoidung);
		map.put("buocxulyList", buocxulyService.getBuocXuLyTheoMaNguoiDung(manguoidung));
		
		System.out.println(vanbandenService.getVanBanDenChuaTiepNhan().size());
		/*map.put("countbuocxulyList", buocxulyService.getBuocXuLyTheoMaNguoiDung(manguoidung).size());*/
		map.put("vanbanListAll", vanbanService.getVanBan());
		map.put("quytrinhListAll",quytrinhService.getQuyTrinh());
		return "xulypheduyetvanban";
		
	}
	
	
	@RequestMapping("/showNhacViec")
	public @ResponseBody Map<String,Object> showNhacViec(){
		Map<String,Object> map = new HashMap<String,Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		int manguoidung = nguoidungService.getMaNguoiDungTheoUsername(name);
		map.put("numberVanBanXuLy",buocxulyService.countBuocXuLyTheoMaNguoiDung(manguoidung, true, false));
		map.put("ListVanBanChuaTiepNhan", vanbandenService.getVanBanDenChuaTiepNhan());
		map.put("ListVanBanChuaXuLy",vanbandenService.getVanBanDenTheoTrangThai(1));
		map.put("ListVanBanDangXuLy",vanbandenService.getVanBanDenTheoTrangThai(2));
		map.put("ListVanBanHoanThanh",vanbandenService.getVanBanDenTheoTrangThai(3));
		map.put("listRoles", nguoidungService.getRolesByUserName(name));
		map.put("listVanBanDenChuaXuLy", vanbandenService.getVanBanDenChuaTiepNhan());
		System.out.println("vanbanchuatiepnhan " + vanbandenService.getVanBanDenChuaTiepNhan());
		return map;
	}
	
	@RequestMapping("/showCount")
	public @ResponseBody Map<String,Object> showCount(){
		Map<String,Object> map = new HashMap<String,Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		int manguoidung = nguoidungService.getMaNguoiDungTheoUsername(name);
		map.put("numberVanBanXuLy",buocxulyService.countBuocXuLyTheoMaNguoiDung(manguoidung, true, false));
		map.put("ListVanBanChuaTiepNhan", vanbandenService.getVanBanDenChuaTiepNhan());
		map.put("ListVanBanChuaXuLy",vanbandenService.getVanBanDenTheoTrangThai(1));
		map.put("ListVanBanDangXuLy",vanbandenService.getVanBanDenTheoTrangThai(2));
		map.put("ListVanBanHoanThanh",vanbandenService.getVanBanDenTheoTrangThai(3));
		map.put("listRoles", nguoidungService.getRolesByUserName(name));
		map.put("listVanBanDenChuaXuLy", vanbandenService.getVanBanDenChuaTiepNhan());
		return map;
	}
	
	@RequestMapping(value="/showcapnhatxuly/{mavanban}/{buoc}/{maquytrinh}",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> updateNoiDungXuLy(
			@PathVariable("mavanban") int mavanban,
			@PathVariable("buoc") int buoc,
			@PathVariable("maquytrinh") int maquytrinh){
		BuocXuLyPheDuyetVanBan buocxuly = buocxulyService.getBuocXuLyTheoVbanBuoc(mavanban, buoc);
		System.out.println(mavanban);
		Map<String,Object> map = new HashMap<String,Object>();
			map.put("buocxuly", buocxuly.getPkBuocXuLy().getSoThuTu());
			map.put("thoigianbatdau", buocxuly.getThoiGianBatDau());
			map.put("mavanban", buocxuly.getVanban().getMaVanBan());
			map.put("maquytrinh", buocxuly.getPkBuocXuLy().getMaQuyTrinh());
			int buocxlchu = buocxuly.getPkBuocXuLy().getSoThuTu();
			System.out.println("fff " + buocxlchu);
			System.out.println("fffrr " + buocxulyService.countBuocXuLyTheoMaQuyTrinh(maquytrinh,mavanban));
			if(buocxlchu == buocxulyService.countBuocXuLyTheoMaQuyTrinh(maquytrinh,mavanban)){
				map.put("trangthaixuly",3);
			}
			else
			{
				
				map.put("trangthaixuly", 2);
			}
			
		
		
			
		return map;
	}
	@RequestMapping(value="/capnhatnoidungxuly/{mavanban}/{buoc}/{noidungxuly}/{maquytrinh}",method=RequestMethod.POST)
	public @ResponseBody int capNhatNoiDungXuLy(
			@PathVariable("mavanban") int mavanban,
			@PathVariable("buoc") int buoc,
			@PathVariable("noidungxuly") String noidungxuly,
			@PathVariable("maquytrinh") int maquytrinh
			){
		
		int result = buocxulyService.updateNoiDungAndValueXuLy(mavanban, buoc, noidungxuly, true);
		int ttxl;
		int capnhatvaluechuyen = 0;
		if(buoc == buocxulyService.countBuocXuLyTheoMaQuyTrinh(maquytrinh,mavanban)){
			ttxl = 3;
			
		}
		else
		{
			ttxl = 2;
			capnhatvaluechuyen = buocxulyService.updateNoiDungAndValueChuyen(mavanban, buoc + 1, true);
		}
		int result1 = vanbanService.updateTrangThaiXuLy(ttxl, mavanban);
		
		
		System.out.println(result);
		System.out.println(result1);
		System.out.println(capnhatvaluechuyen);
		
		return capnhatvaluechuyen;
	}
	
	
}
