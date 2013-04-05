package com.quangvinh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.HoSoLuuTru;
import com.quangvinh.service.IHoSoLuuTruService;

@Controller
public class NhapHoSoLuuTruController {
	
	@Autowired
	private IHoSoLuuTruService hosoluutruService;
	@RequestMapping("/nhapHoSoLuuTru")
	public String loadPageNhapHoSoLuuTru(Map<String, Object> map){
		map.put("hosoluutruList", hosoluutruService.getHoSoLuuTru());
		return "nhaphosoluutru";
	}
	
	@RequestMapping(value="/addHoSoLuuTru/{mahosothem}/tieudehosothem}/{thoigianbatdauthem}/{thoigiankethucthem}/{thoihanbaoquanthem}",method=RequestMethod.POST)
	public @ResponseBody boolean addHoSoLuuTru(
			@PathVariable("mahosothem") String mahoso,
			@PathVariable("tieudehosothem") String tieudehoso,
			@PathVariable("thoigianbatdauthem") String thoigianbatdau,
			@PathVariable("thoigiankethucthem") String thoigiankethuc,
			@PathVariable("thoihanbaoquanthem") int thoihanbaoquan){
		int oldSize = hosoluutruService.getHoSoLuuTru().size();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-mm-dd"); 
		Date dthoigianbatdau = null;
		Date dthoigianketthuc = null;
		try {
			dthoigianbatdau = dateFormat.parse(thoigianbatdau);
			dthoigianketthuc = dateFormat.parse(thoigiankethuc);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		
		HoSoLuuTru hosoluutru = new HoSoLuuTru();
		hosoluutru.setMaHoSo(mahoso);
		hosoluutru.setTieuDeHoSo(tieudehoso);
		hosoluutru.setThoiGianBatDau(dthoigianbatdau);
		hosoluutru.setThoiGianKetThuc(dthoigianketthuc);
		hosoluutru.setThoiGianBaoQuan(thoihanbaoquan);
		
		hosoluutruService.saveHoSoLuuTru(hosoluutru);
		return (oldSize < hosoluutruService.getHoSoLuuTru().size());
	}
	
	
}
