package com.quangvinh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.Message;
import com.quangvinh.service.IMessageService;
import com.quangvinh.service.INguoiDungService;

@Controller
public class GuiTinNhanNoiBoController {

	@Autowired
	private INguoiDungService nguoidungService;
	@Autowired
	private IMessageService messageService;
	
	@RequestMapping("/guiTinNhanNoiBo")
	public String loadPageGuiTinNhanNoiBo(Map<String, Object> map){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); 
		String tennguoidung = nguoidungService.getTenNguoiDungTheoUsername(name);
		map.put("nameNguoiDung",tennguoidung);
		map.put("userName", name);
		map.put("nguoidungList", nguoidungService.getNguoiDung());
		return "guitinnhannoibo";
	}
	@RequestMapping(value="/addMessage/{manguoidung}/{noidung}",method=RequestMethod.POST)
	public @ResponseBody boolean addMessage(@PathVariable("manguoidung") int manguoidung,
			@PathVariable("noidung") String noidung){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = new Date();
		String dateString= dateFormat.format(date);
		Date dateFormatted = null;
		try {
			dateFormatted = dateFormat.parse(dateString);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Message message = new Message();
		String tentacgia = nguoidungService.getTenNguoiDungTheoUsername(name);
		message.setNguoidung(nguoidungService.findNguoiDungID(manguoidung));
		message.setNoiDung(noidung);
		message.setTacGia(name);
		message.setThoiDiemGui(dateFormatted);
		message.setTenTacGia(tentacgia);
		messageService.saveMessage(message);
		
		
		System.out.println(dateString);
		
		return true;
	}
	
	@RequestMapping(value="/addMessageReply/{userName}/{noidung}",method=RequestMethod.POST)
	public @ResponseBody boolean addMessageReply(@PathVariable("userName") String userName,
			@PathVariable("noidung") String noidung){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = new Date();
		String dateString= dateFormat.format(date);
		Date dateFormatted = null;
		try {
			dateFormatted = dateFormat.parse(dateString);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Message message = new Message();
		String tentacgia = nguoidungService.getTenNguoiDungTheoUsername(name);
		int manguoidung = nguoidungService.getMaNguoiDungTheoUsername(userName);
		message.setNguoidung(nguoidungService.findNguoiDungID(manguoidung));
		message.setNoiDung(noidung);
		message.setTacGia(name);
		message.setThoiDiemGui(dateFormatted);
		message.setTenTacGia(tentacgia);
		messageService.saveMessage(message);
		
		
		System.out.println(dateString);
		
		return true;
	}
	
	
	
}
