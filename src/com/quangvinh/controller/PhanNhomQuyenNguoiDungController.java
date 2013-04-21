package com.quangvinh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.NguoiDung;
import com.quangvinh.model.NguoiDung_Roles;
import com.quangvinh.model.Roles;
import com.quangvinh.service.IDonViService;
import com.quangvinh.service.INguoiDungRolesService;
import com.quangvinh.service.INguoiDungService;
import com.quangvinh.service.IRoleService;

@Controller
public class PhanNhomQuyenNguoiDungController {

	@Autowired
	private IRoleService roleService;
	@Autowired
	private INguoiDungRolesService nguoidungroleService;
	@Autowired
	private INguoiDungService nguoidungService;
	@Autowired
	private IDonViService donviService;
		
	
	@RequestMapping("/phanNhomQuyen/{manguoidung}")
	public String loadPagePhanNhomQuyen(@PathVariable("manguoidung") int manguoidung,Map<String, Object> map){
		NguoiDung nguoidung = nguoidungService.findNguoiDungID(manguoidung);
		map.put("tennguoidung", nguoidung.getTenNguoiDung());
		map.put("manguoidung", manguoidung);
		map.put("roleList", roleService.getRoles());
		map.put("roleListNguoiDung", roleService.getRolesListTheoNguoiDung(manguoidung));
		return "phannhomquyennguoidung";
		
	}
	
	@RequestMapping(value="/addThemNhomQuyen/{manguoidung}/{marole}/{giatri}",method=RequestMethod.POST)
	public @ResponseBody boolean addNhomQuyen(@PathVariable("manguoidung") int manguoidung,
			@PathVariable("marole") int marole,
			@PathVariable("giatri") int giatri){
		System.out.println("ma gia tri :" + giatri);
		if(giatri == 1){
			if(nguoidungroleService.checkExistNguoiDungRoles(manguoidung, marole).size() == 0){
				System.out.println("NULL");
				NguoiDung_Roles nguoidungrole = new NguoiDung_Roles();
				NguoiDung nguoidung = nguoidungService.findNguoiDungID(manguoidung);
				Roles roles = roleService.findRoleID(marole);
				
				nguoidungrole.setNguoidung(nguoidung);
				nguoidungrole.setRoles(roles);
				
				nguoidungroleService.saveNguoiDungRoles(nguoidungrole);
			}
			
		}
		
		if(giatri == 2){
			if(nguoidungroleService.checkExistNguoiDungRoles(manguoidung, marole).size() != 0){
				nguoidungroleService.deleteNguoiDungRoles2(manguoidung, marole);
			}
			
		}
		
		
		
		return true;
	}
	
	
		
}
