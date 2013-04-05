package com.quangvinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeAdminController {
	
	@RequestMapping("/welcomeAdmin")
	public String loadPageWelcomeAdmin(){
		
		return "welcomeadmin";
	}
}
