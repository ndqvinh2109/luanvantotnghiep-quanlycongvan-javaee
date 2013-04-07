package com.quangvinh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quangvinh.service.IMessageService;
import com.quangvinh.service.INguoiDungService;

@Controller
public class LoginController {
	
	@Autowired
	private IMessageService messageService;
	@Autowired
	private INguoiDungService nguoidungService;
	
	@RequestMapping("/login.do")
	public String pageLogin(Map<String, Object> map){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); 
		int manguoidung = nguoidungService.getMaNguoiDungTheoUsername(name);
		map.put("MessageListReadYet", messageService.getMessagesReadYet(false,manguoidung));
		
		return "trangchu";
	}
	
	
	
}
