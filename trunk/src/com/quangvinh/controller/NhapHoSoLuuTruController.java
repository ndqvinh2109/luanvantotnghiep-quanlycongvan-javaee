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
import com.quangvinh.model.VanBan;
import com.quangvinh.service.IHoSoLuuTruService;
import com.quangvinh.service.IVanBanDenService;
import com.quangvinh.service.IVanBanService;

@Controller
public class NhapHoSoLuuTruController {
	
	@Autowired
	private IHoSoLuuTruService hosoluutruService;
	@Autowired
	private IVanBanService vanbanService;
	@Autowired
	private IVanBanDenService vanbandenService;
	
	@RequestMapping("/nhapHoSoLuuTru")
	public String loadPageNhapHoSoLuuTru(Map<String, Object> map){
		map.put("hosoluutruList", hosoluutruService.getHoSoLuuTru());
		map.put("vanbanList", vanbandenService.getVanBanDen());
		return "nhaphosoluutru";
	}
	
	
	
	@RequestMapping(value="/addHoSoLuuTru/{mahosothem}/{tieudehosothem}/{thoigianbatdauthem}/{thoigianketthucthem}/{thoihanbaoquanthem}",method=RequestMethod.POST)
	public @ResponseBody boolean addHoSoLuuTru(
			@PathVariable("mahosothem") String mahoso,
			@PathVariable("tieudehosothem") String tieudehoso,
			@PathVariable("thoigianbatdauthem") String thoigianbatdau,
			@PathVariable("thoigianketthucthem") String thoigiankethuc,
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
	
	@RequestMapping(value="/xoaHoSoLuuTru/{sohoso}",method=RequestMethod.POST)
	public @ResponseBody boolean xoaHoSoLuuTru(
			@PathVariable("sohoso") int sohoso){
		
		int oldSize = hosoluutruService.getHoSoLuuTru().size();
		
		hosoluutruService.deleteHoSoLuuTru(sohoso);
		
		return (oldSize > hosoluutruService.getHoSoLuuTru().size());
		
	}
	
	@RequestMapping(value="/updateHoSoLuuTru/{sohoso}/{mahoso}/{tieudehoso}/{thoigianbatdau}/{thoigianketthuc}/{thoihanbaoquan}",method=RequestMethod.POST)
	public @ResponseBody boolean updateHoSoLuuTru(
			@PathVariable("sohoso") int sohoso,
			@PathVariable("mahoso") String mahoso,
			@PathVariable("tieudehoso") String tieudehoso,
			@PathVariable("thoigianbatdau") String thoigianbatdau,
			@PathVariable("thoigianketthuc") String thoigiankethuc,
			@PathVariable("thoihanbaoquan") int thoihanbaoquan){
		
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
		hosoluutru.setSoHoSo(sohoso);
		hosoluutruService.updateHoSoLuuTru(hosoluutru);
		return true;
	}
	
	@RequestMapping(value="/addVanBanHoSo/{getsohoso}/{mavanban}",method=RequestMethod.POST)
	public @ResponseBody boolean addVanBanHoSo(@PathVariable("getsohoso") int sohoso,
			@PathVariable("mavanban") int mavanban){
		
		VanBan vanban = vanbanService.findVanBanID(mavanban);
		
		VanBan vanbanupdate = new VanBan(vanban.getCapdobaomat(), vanban.getLinhvuc(),
				vanban.getLoaivanban(), vanban.getCapdokhan(),
				vanban.getVitriluutru(), hosoluutruService.findHoSoLuuTruID(sohoso), mavanban,
				vanban.getSoKyHieuVanBan(), vanban.getNgayBanHanh(), vanban.getNgayHieuLuc(), 
				vanban.getNgayHetHieuLuc(), vanban.getTrichYeu(), vanban.getNguoiKy(), vanban.getSoTrang(),
				vanban.getTuKhoa(), vanban.getNgayNhapMay(), vanban.getTrangThaiXuLy());
		vanbanupdate.setEnabled(vanban.isEnabled());
		vanbanService.updateVanBan(vanbanupdate);
		return true;
	}
	
	
}
