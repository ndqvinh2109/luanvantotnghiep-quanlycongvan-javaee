package com.quangvinh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quangvinh.service.ICapDoBaoMatService;
import com.quangvinh.service.ICapDoKhanService;
import com.quangvinh.service.ILinhVucService;
import com.quangvinh.service.ILoaiVanBanService;

@Controller
public class BaoCaoVanBanDenController {

		@Autowired
		private ICapDoKhanService capdokhanService;
		@Autowired
		private ICapDoBaoMatService capdobaomatSerice;
		@Autowired
		private ILoaiVanBanService loaivanbanService;
		@Autowired
		private ILinhVucService linhvucService;
		
				
		@RequestMapping("/baoCaoVanBanDen")
		public String loadPageBaoCaoVanBanDen(){
				
			return "baocaovanbanden";
		
		}
}
