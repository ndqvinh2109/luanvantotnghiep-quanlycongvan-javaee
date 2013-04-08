package com.quangvinh.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.security.action.PutAllAction;

@Controller
public class WelcomeAdminController {
	
	@RequestMapping("/welcomeAdmin")
	public String loadPageWelcomeAdmin(){
		
		return "welcomeadmin";
	}
	@RequestMapping(value="/showUsername",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> showUsername(){
		Map<String,Object> map = new HashMap<String,Object>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		map.put("userName", name);
		return map;
	}
}
