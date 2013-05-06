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

import com.quangvinh.model.Buoc;
import com.quangvinh.model.BuocXuLyPheDuyetVanBan;
import com.quangvinh.model.NguoiDung;
import com.quangvinh.model.VanBan;
import com.quangvinh.model.BuocXuLyPheDuyetVanBan.Pk_BuocXuLyVanBan;
import com.quangvinh.service.IBuocService;
import com.quangvinh.service.IBuocXuLyService;
import com.quangvinh.service.IBuoc_NguoiDungService;
import com.quangvinh.service.INguoiDungService;
import com.quangvinh.service.IVanBanDenService;
import com.quangvinh.service.IVanBanService;

@Controller
public class PhanXuLyVanBanController {
	
	@Autowired
	private IVanBanDenService vanbandenService;
	@Autowired
	private IBuocXuLyService buocxulyService;
	@Autowired
	private INguoiDungService nguoidungService;
	@Autowired
	private IBuocService buocService;
	@Autowired
	private IVanBanService vanbanService;
	@Autowired
	private IBuoc_NguoiDungService buocnguoidungService;
	
	@RequestMapping("/phanxuly/{mavanban}.action")
	public String pagePhanXuLy(Map<String,Object> map,@PathVariable("mavanban") int mavanban){
		System.out.println(mavanban);
		int maquytrinh = vanbandenService.findQuyTrinh(mavanban);
		map.put("buocList",buocxulyService.getBuocXuLyPheDuyetTrongQuyTrinh(maquytrinh));
		map.put("nguoidungList", nguoidungService.getNguoiDung());
		map.put("buocnguoidungList", buocnguoidungService.getBuocndQuyTrinh(maquytrinh));
		
		map.put("maquytrinh", maquytrinh);
		map.put("mavanban", mavanban);
		map.put("checkExist", buocxulyService.checkExistVanBanTrongBuocXuLy(mavanban));
		System.out.println("ma quy trinh " + maquytrinh);
		System.out.println(buocxulyService.checkExistVanBanTrongBuocXuLy(mavanban));
		return "phanxulyvanban";
	}
	
	
	@RequestMapping(value="/addBuocXuLy/{sothutu}/{manguoidung}/{thoigianbatdau}/{thoigianhoanthanh}/{maquytrinh}/{mavanban}",method=RequestMethod.POST)
	public @ResponseBody boolean addBuocXuLy(
			@PathVariable("sothutu") int sothutu,
			@PathVariable("manguoidung") int manguoidung,
			@PathVariable("thoigianbatdau") String thoigianbatdau,
			@PathVariable("thoigianhoanthanh") String thoigianhoanthanh,
			@PathVariable("maquytrinh") int maquytrinh,
			@PathVariable("mavanban") int mavanban
			){
		int oldSize = buocxulyService.getBuocXuLyPheDuyetVanBans().size();
		Buoc buoc = buocService.findBuocID(maquytrinh, sothutu);
		NguoiDung nguoidung = nguoidungService.findNguoiDungID(manguoidung);
		VanBan vanban = vanbanService.findVanBanID(mavanban);
		BuocXuLyPheDuyetVanBan buocxuly = new BuocXuLyPheDuyetVanBan();
		buocxuly.setBuoc(buoc);
		buocxuly.setNguoidung(nguoidung);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd"); 
			Date dthoigianbatdau = null;
			Date dthoigianhoanthanh = null;
		try {
			dthoigianbatdau = dateFormat.parse(thoigianbatdau);
			dthoigianhoanthanh = dateFormat.parse(thoigianhoanthanh);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		Pk_BuocXuLyVanBan pk = new Pk_BuocXuLyVanBan();
		pk.setMaQuyTrinh(maquytrinh);
		pk.setMaVanBan(mavanban);
		pk.setSoThuTu(sothutu);
		
		buocxuly.setPkBuocXuLy(pk);
		buocxuly.setThoiGianBatDau(dthoigianbatdau);
		buocxuly.setThoiGianHoanThanh(dthoigianhoanthanh);
		buocxuly.setNoiDungXLPD(" ");
		buocxuly.setVanban(vanban);
		if(sothutu == 1)
		buocxuly.setValueChuyen(true);
		
		buocxulyService.saveBuocXuLy(buocxuly);
		
		System.out.println(thoigianbatdau + '/' + thoigianhoanthanh + '/' + sothutu + '/' + manguoidung);
		System.out.println(maquytrinh + " / " + mavanban);
		
		return (oldSize <  buocxulyService.getBuocXuLyPheDuyetVanBans().size());
		
	}
	
	
	
	
	
	
}
