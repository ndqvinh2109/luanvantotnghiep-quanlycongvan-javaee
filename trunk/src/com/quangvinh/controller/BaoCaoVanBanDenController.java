package com.quangvinh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quangvinh.model.LoaiVanBan;
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
		
		@RequestMapping(value="/PdfVanBanDen")
		public String PdfVanBanDenSummary(Map<String,Object> map){
			Map<Integer,String> mapTemp = new HashMap<Integer,String>();
			
				List<LoaiVanBan> loaivanbanList = loaivanbanService.getLoaiVanBan();
				for(LoaiVanBan loaivanban : loaivanbanList){
					mapTemp.put(loaivanban.getMaLoaiVanBan(), loaivanban.getTenLoaiVanBan());
				}
				
				map.put("printData", mapTemp);
				
			
			
			return "pdfvanbanden";
			
		}
		
		
}
