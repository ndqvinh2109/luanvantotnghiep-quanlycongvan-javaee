package com.quangvinh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.CapDoKhan;
import com.quangvinh.service.ICapDoKhanService;

@Controller
public class DanhMucCapDoKhanController {
	
	@Autowired
	private ICapDoKhanService capdokhanService;
	
	@RequestMapping("/danhMucCapDoKhan")
	public String loadPageDanhMucCapDoKhan(Map<String, Object> map){
		
		map.put("capDoKhanList", capdokhanService.getCapDoKhan());
		return "danhmuccapdokhan";
	}
	
	@RequestMapping("/getCapDoKhanListJson")
	public @ResponseBody List<CapDoKhan> getCapDoKhanList(){
		
		return capdokhanService.getCapDoKhan();
		
	}
	
	@RequestMapping("/themCapDoKhan/{tendokhanthem}/{giatricapdothem}")
	public @ResponseBody boolean addCapDoKhan(@PathVariable("tendokhanthem") String tendokhan,
			@PathVariable("giatricapdothem") int giatricapdo){
		int oldSize = capdokhanService.getCapDoKhan().size();
		
		CapDoKhan capdokhan =  new CapDoKhan();
		capdokhan.setGiaTriCapDo(giatricapdo);
		capdokhan.setTenDoKhan(tendokhan);
		
		capdokhanService.saveCapDoKhan(capdokhan);
		return (oldSize < capdokhanService.getCapDoKhan().size());	
		
	}
	
	@RequestMapping("/suaCapDoKhan/{madokhan}/{tendokhanthem}/{giatricapdothem}")
	public @ResponseBody boolean suaCapDoKhan(@PathVariable("madokhan") int madokhan,
			@PathVariable("tendokhanthem") String tendokhan,
			@PathVariable("giatricapdothem") int giatricapdo){
			
		CapDoKhan capdokhan =  new CapDoKhan();
		capdokhan.setGiaTriCapDo(giatricapdo);
		capdokhan.setTenDoKhan(tendokhan);
		capdokhan.setMaDoKhan(madokhan);
		capdokhanService.updateCapDoKhan(capdokhan);
		return true;	
		
	}
	
	@RequestMapping("/xoaCapDoKhan/{madokhan}")
	public @ResponseBody boolean xoaCapDoKhan(@PathVariable("madokhan") int madokhan){
		int oldSize = capdokhanService.getCapDoKhan().size();
		capdokhanService.deleteCapDoKhan(madokhan);
		return (oldSize > capdokhanService.getCapDoKhan().size());	
		
	}
	
	
}
