package com.quangvinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanHanhVanBanController {

	@RequestMapping("/banHanhVanBan")
	public String loadPageBanHanhVanBan(){
		return "banhanhvanban";
	}
}
