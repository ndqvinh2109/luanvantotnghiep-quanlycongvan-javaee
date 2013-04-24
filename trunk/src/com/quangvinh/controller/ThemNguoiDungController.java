package com.quangvinh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.DonVi;
import com.quangvinh.model.NguoiDung;
import com.quangvinh.service.IDonViService;
import com.quangvinh.service.INguoiDungService;

@Controller
public class ThemNguoiDungController {

	@Autowired
	private IDonViService donviService;
	
	@Autowired
	private INguoiDungService nguoidungService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@RequestMapping("/themNguoiDung")
	public String loadPageThemNguoiDung(Map<String, Object> map){
		
		map.put("donviList", donviService.getDonViDocLap(2));
		map.put("donviList2", donviService.getDonViDocLap(3));
		map.put("nguoidungList", nguoidungService.getNguoiDung());
		return "themnguoidung";
	}	
	
	
	@RequestMapping(value="/themNguoiDung/{tennguoidung}/{diachi}/{email}/{sodienthoai}/{gioitinh}/{donvi}/{tendangnhap}/{password}",method=RequestMethod.POST)
	public @ResponseBody boolean themNguoiDung(
			@PathVariable("tennguoidung") String tennguoidung,
			@PathVariable("diachi") String diachi,
			@PathVariable("email") String email,
			@PathVariable("sodienthoai") String sodienthoai,
			@PathVariable("gioitinh") int gioitinh,
			@PathVariable("donvi") int madonvi,
			@PathVariable("tendangnhap") String tendangnhap,
			@PathVariable("password") String password
			){
		int oldSize = nguoidungService.getNguoiDung().size();
		String encodedPassword = passwordEncoder.encodePassword(password,null);
		NguoiDung nguoidung = new NguoiDung();
		DonVi donvi = donviService.findDonViID(madonvi);
		
		nguoidung.setTenNguoiDung(tennguoidung);
		nguoidung.setDiaChi(diachi);
		nguoidung.setEmail(email);
		nguoidung.setSoDienThoai(sodienthoai);
		nguoidung.setGioiTinh(gioitinh);
		nguoidung.setDonvi(donvi);
		nguoidung.setUserName(tendangnhap);
		nguoidung.setPassWord(encodedPassword);
		nguoidung.setMacDinh(true);
		
		nguoidungService.saveNguoiDung(nguoidung);
		return (oldSize < nguoidungService.getNguoiDung().size());
	}
	@RequestMapping(value="/themNguoiDungdv/{tennguoidung}/{diachi}/{email}/{sodienthoai}/{gioitinh}/{donvi}/{tendangnhap}/{password}",method=RequestMethod.POST)
	public @ResponseBody boolean themNguoiDungdv(
			@PathVariable("tennguoidung") String tennguoidung,
			@PathVariable("diachi") String diachi,
			@PathVariable("email") String email,
			@PathVariable("sodienthoai") String sodienthoai,
			@PathVariable("gioitinh") int gioitinh,
			@PathVariable("donvi") int madonvi,
			@PathVariable("tendangnhap") String tendangnhap,
			@PathVariable("password") String password
			){
		int oldSize = nguoidungService.getNguoiDung().size();
		String encodedPassword = passwordEncoder.encodePassword(password,null);
		NguoiDung nguoidung = new NguoiDung();
		DonVi donvi = donviService.findDonViID(madonvi);
		
		nguoidung.setTenNguoiDung(tennguoidung);
		nguoidung.setDiaChi(diachi);
		nguoidung.setEmail(email);
		nguoidung.setSoDienThoai(sodienthoai);
		nguoidung.setGioiTinh(gioitinh);
		nguoidung.setDonvi(donvi);
		nguoidung.setUserName(tendangnhap);
		nguoidung.setPassWord(encodedPassword);
		nguoidung.setMacDinh(true);
		
		nguoidungService.saveNguoiDung(nguoidung);
		return (oldSize < nguoidungService.getNguoiDung().size());
	}
	@RequestMapping(value="/suaNguoiDung1/{manguoidung}/{tennguoidung}/{diachi}/{email}/{sodienthoai}/{gioitinh}/{donvi}/{tendangnhap}",method=RequestMethod.POST)
	public @ResponseBody boolean suaNguoiDung1(
			@PathVariable("manguoidung") int manguoidung,
			@PathVariable("tennguoidung") String tennguoidung,
			@PathVariable("diachi") String diachi,
			@PathVariable("email") String email,
			@PathVariable("sodienthoai") String sodienthoai,
			@PathVariable("gioitinh") int gioitinh,
			@PathVariable("donvi") int madonvi,
			@PathVariable("tendangnhap") String tendangnhap
		
			){
		
		
		NguoiDung nguoidung = nguoidungService.findNguoiDungID(manguoidung);
		DonVi donvi = donviService.findDonViID(madonvi);
		nguoidung.setMaNguoiDung(manguoidung);
		nguoidung.setTenNguoiDung(tennguoidung);
		nguoidung.setDiaChi(diachi);
		nguoidung.setEmail(email);
		nguoidung.setSoDienThoai(sodienthoai);
		nguoidung.setGioiTinh(gioitinh);
		nguoidung.setDonvi(donvi);
		nguoidung.setUserName(tendangnhap);
		nguoidung.setMacDinh(true);
		nguoidungService.updateNguoiDung(nguoidung);
		return true;
	}
	@RequestMapping(value="/suaNguoiDung2/{manguoidung}/{tennguoidung}/{diachi}/{email}/{sodienthoai}/{gioitinh}/{donvi}/{tendangnhap}/{password}",method=RequestMethod.POST)
	public @ResponseBody boolean suaNguoiDung2(
			@PathVariable("manguoidung") int manguoidung,
			@PathVariable("tennguoidung") String tennguoidung,
			@PathVariable("diachi") String diachi,
			@PathVariable("email") String email,
			@PathVariable("sodienthoai") String sodienthoai,
			@PathVariable("gioitinh") int gioitinh,
			@PathVariable("donvi") int madonvi,
			@PathVariable("tendangnhap") String tendangnhap,
			@PathVariable("password") String password
			){
		
		String encodedPassword = passwordEncoder.encodePassword(password,null);
		NguoiDung nguoidung = nguoidungService.findNguoiDungID(manguoidung);
		DonVi donvi = donviService.findDonViID(madonvi);
		nguoidung.setMaNguoiDung(manguoidung);
		nguoidung.setTenNguoiDung(tennguoidung);
		nguoidung.setDiaChi(diachi);
		nguoidung.setEmail(email);
		nguoidung.setSoDienThoai(sodienthoai);
		nguoidung.setGioiTinh(gioitinh);
		nguoidung.setDonvi(donvi);
		nguoidung.setUserName(tendangnhap);
		nguoidung.setPassWord(encodedPassword);
		nguoidung.setMacDinh(true);
		
		nguoidungService.updateNguoiDung(nguoidung);
		return true;
	}
	
	@RequestMapping(value="/xoaNguoiDung/{manguoidung}",method=RequestMethod.GET)
	public @ResponseBody boolean xoaNguoiDung(@PathVariable("manguoidung") int manguoidung){
		int oldSize = nguoidungService.getNguoiDung().size();
		
		
		nguoidungService.deleteNguoiDung(manguoidung);
		
		return (oldSize > nguoidungService.getNguoiDung().size());
		
	}
	
	
	
}
