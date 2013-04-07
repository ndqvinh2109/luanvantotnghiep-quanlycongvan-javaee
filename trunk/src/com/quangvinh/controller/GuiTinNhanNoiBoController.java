package com.quangvinh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quangvinh.service.INguoiDungService;

@Controller
public class GuiTinNhanNoiBoController {

	@Autowired
	private INguoiDungService nguoidungService;
	
	@RequestMapping("/guiTinNhanNoiBo")
	public String loadPageGuiTinNhanNoiBo(Map<String, Object> map){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); 
		String tennguoidung = nguoidungService.getTenNguoiDungTheoUsername(name);
		map.put("nameNguoiDung",tennguoidung);
		map.put("nguoidungList", nguoidungService.getNguoiDung());
		return "guitinnhannoibo";
	}
}
