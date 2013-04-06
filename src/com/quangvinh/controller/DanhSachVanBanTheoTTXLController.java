package com.quangvinh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quangvinh.service.IVanBanDenService;

@Controller
public class DanhSachVanBanTheoTTXLController {

	@Autowired
	private IVanBanDenService vanbandenService;
	@RequestMapping("/DanhSachVanBanTheoTTXL/{trangthaixuly}")
	public String loadPageDanhSachVanBanTheoTTXL(@PathVariable("trangthaixuly") int trangthaixuly,Map<String,Object> map){
		
		if(trangthaixuly == 1){
			map.put("vanbandenttxlList", vanbandenService.getVanBanDenTheoTrangThai(1));
		}
		else if(trangthaixuly == 2){
			map.put("vanbandenttxlList", vanbandenService.getVanBanDenTheoTrangThai(2));
		}
		else{
			map.put("vanbandenttxlList", vanbandenService.getVanBanDenTheoTrangThai(2));
		}
		
		return "DanhSachVanBanTheoTTXL";
	}
	
}
