package com.quangvinh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quangvinh.model.NguoiDung;
import com.quangvinh.model.NguoiDung_Roles;
import com.quangvinh.service.INguoiDungService;
import com.quangvinh.service.IRoleService;

@Controller
public class PhanQuyenNguoiDungController {

	@Autowired
	private INguoiDungService nguoidungService;
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/phanQuyenNguoiDung/{manguoidung}")
	public String loadPagePhanQuyenNguoiDung(@PathVariable("manguoidung") int manguoidung, Map<String, Object> map){
		
		List<NguoiDung_Roles> roles = roleService.getRolesListTheoNguoiDung(manguoidung);
		NguoiDung nguoidung = nguoidungService.findNguoiDungID(manguoidung);
		map.put("roleList", roles);
		map.put("tennguoidung", nguoidung.getTenNguoiDung());
		map.put("manguoidung", nguoidung.getMaNguoiDung());
		return "phanquyennguoidung";
		
	}
	
}
