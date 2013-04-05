package com.quangvinh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.VanBanDen;
import com.quangvinh.service.IDonViService;
import com.quangvinh.service.IHoSoLuuTruService;
import com.quangvinh.service.ILinhVucService;
import com.quangvinh.service.ILoaiVanBanService;
import com.quangvinh.service.IVanBanDenService;

@Controller
public class TimKiemVanBanDenController {

	@Autowired
	private IVanBanDenService vanbandenService;
	@Autowired
	private IHoSoLuuTruService hosoluutruService;
	@Autowired
	private IDonViService donviService;
	@Autowired
	private ILoaiVanBanService loaivanbanService;
	@Autowired
	private ILinhVucService linhvucService;
	
	@RequestMapping("/timKiemVanBanDen")
	public String loadPageTimKiemVanBanDen(Map<String,Object> map){
		
		map.put("donViList",donviService.getDonVi());
		map.put("loaiVanBanList", loaivanbanService.getLoaiVanBan());
		map.put("linhVucList",linhvucService.getLinhVuc());
		map.put("hoSoLuuTruList", hosoluutruService.getHoSoLuuTru());
		
		return "timkiemvanbanden";
	}
	
	@RequestMapping(value="/timKiemNangCao/{trichyeu}/{ngayden}/{soden}/{sokyhieu}/{coquanbanhanh}/{loaivanban}/{linhvuc}/{sohoso}",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> timKiemNangCao(
			@PathVariable("trichyeu") String trichyeu,
			@PathVariable("ngayden") String ngayden,
			@PathVariable("soden") int soden,
			@PathVariable("sokyhieu") String sokyhieu,
			@PathVariable("coquanbanhanh") int coquanbanhanh,
			@PathVariable("loaivanban") int loaivanban,
			@PathVariable("linhvuc") int linhvuc,
			@PathVariable("sohoso") int sohoso){
		Map<String,Object> map = new HashMap<String,Object>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-mm-dd"); 
		Date dngayden = null;
		try {
			dngayden = dateFormat.parse(ngayden);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		List<VanBanDen> vanbanden = vanbandenService.timKiemNangCaoVanBanDen(trichyeu, dngayden, soden, sokyhieu, coquanbanhanh, loaivanban, linhvuc, sohoso);
		
		map.put("vanbandenList", vanbanden);
		
		return map;
	}
	@RequestMapping(value="/timKiemCoBan/{textInput}",method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> timKiemCoBan(@PathVariable("textInput") String textInput){
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<VanBanDen> vanbanden = vanbandenService.timKiemCoBanVanBanDen(textInput);
		map.put("vanbandenListCoBan", vanbanden);
		return map;
		
	}
}
