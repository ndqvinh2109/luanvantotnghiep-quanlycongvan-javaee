package com.quangvinh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.NguoiDung;
import com.quangvinh.service.IDonViService;
import com.quangvinh.service.INguoiDungService;

@Controller
public class PhanCapNguoiDungController {
	
	@Autowired
	private IDonViService donviService;
	@Autowired
	private INguoiDungService nguoidungService;
	
	@RequestMapping("/phanCapNguoiDung")
	public String loadPagePhanCapNguoiDung(Map<String, Object> map){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); 
		System.out.println(name);
		int manguoidung = nguoidungService.getMaNguoiDungTheoUsername(name);
		int madonvi = nguoidungService.getMaDonViTheoMaNguoiDung(manguoidung);
		map.put("donviptList", donviService.getDonViTheoMaDonViPhuThuoc(madonvi));
		map.put("donvi", donviService.findDonViID(madonvi));
		return "phancapnguoidung";
	}
	
	@RequestMapping(value="/getNguoiDungListTheoDonVi/{madonvi}",method=RequestMethod.GET)
	public @ResponseBody List<NguoiDung> getNguoiDungTheoDonVi(
			@PathVariable("madonvi") int madonvi
			){
		
		List<NguoiDung> nguoidungList = nguoidungService.getNguoiDungTheoMaDonVi(madonvi);
		return nguoidungList;
	}
}
