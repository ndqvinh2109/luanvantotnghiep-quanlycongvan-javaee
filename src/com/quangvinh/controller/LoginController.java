package com.quangvinh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;
import com.quangvinh.model.BuocXuLyPheDuyetVanBan;
import com.quangvinh.model.NguoiDung;
import com.quangvinh.service.IBuocXuLyService;
import com.quangvinh.service.IMessageService;
import com.quangvinh.service.INguoiDungService;

@Controller
public class LoginController {
	
	@Autowired
	private IMessageService messageService;
	@Autowired
	private INguoiDungService nguoidungService;
	@Autowired
	private IBuocXuLyService buocxulyService;
	
	@RequestMapping("/login.action")
	public String pageLogin(Map<String, Object> map){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); 
		int manguoidung = nguoidungService.getMaNguoiDungTheoUsername(name);
		String tennguoidung = nguoidungService.getTenNguoiDungTheoUsername(name);
		map.put("nameNguoiDung",tennguoidung);
		map.put("MessageListReadYet", messageService.getMessagesReadYet(false,manguoidung));
		map.put("nguoidungList", nguoidungService.getNguoiDung());
		
		return "trangchu";
	}
	
	
	@RequestMapping(value="/thongKeHieuSuatVanBan/{nguoidung}/{tungay}/{denngay}")
	public String drawPieChart(ModelMap model,@PathVariable("nguoidung") int nguoidung,
			@PathVariable("tungay") String tungay,
			@PathVariable("denngay") String denngay,
			Map<String, Object> map){
		List<BuocXuLyPheDuyetVanBan> buocxulyList = buocxulyService.getBuocXuLyTheoMaNguoiDung(nguoidung);
		int dunghan = 0;
		int quahan = 0;
		int count = 0;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd"); 
		Date dtungay = null;
		Date ddenngay = null;
		
		try {
			dtungay = dateFormat.parse(tungay);
			ddenngay = dateFormat.parse(denngay);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		
		for(BuocXuLyPheDuyetVanBan buocxuly: buocxulyList){
			if(buocxuly.getThoiGianXuLy() != null){
				if((buocxuly.getThoiGianXuLy().after(dtungay) || buocxuly.getThoiGianXuLy().equals(dtungay)) && (buocxuly.getThoiGianXuLy().before(ddenngay) || buocxuly.getThoiGianXuLy().equals(ddenngay))){
					count++;
					if(buocxuly.getThoiGianXuLy().after(buocxuly.getThoiGianHoanThanh())){
						quahan++;
					}
					else{
						dunghan++;
					}
					
				}
			
			}
			
		}
		
		NguoiDung nguoidungo = nguoidungService.findNguoiDungID(nguoidung);
		String hoten = nguoidungo.getTenNguoiDung();
		map.put("tennguoidungPieChart", hoten);
		float perdunghan = (float) dunghan/count;
		float perquahan = (float) quahan/count;
		
		int t1 = (int)(perdunghan*100);
		int t2 = (int)(perquahan*100);
		System.out.println(t1 + "ddf" + t2 + "ffd");
		Slice s1 = Slice.newSlice(t1, Color.newColor("ABDF0E"),Math.round((Math.round(perdunghan*100.0)/100.0)*100)  + "%","Đúng hạn (" + dunghan +")");
		Slice s2 = Slice.newSlice(t2, Color.newColor("f70b0b"),Math.round((Math.round(perquahan*100.0)/100.0)*100) + "%","Quá hạn (" + quahan + ")");
		PieChart piechart = GCharts.newPieChart(s1,s2);
		piechart.setSize(720,360);
		piechart.setThreeD(true);
		model.addAttribute("barUrl",piechart.toURLString());
		
		return "showpiechart";
	}
	
	
		
	
	@RequestMapping(value="/thongKeTinhHinhXuLy/{nguoidung}/{tungay}/{denngay}")
	public @ResponseBody List<BuocXuLyPheDuyetVanBan> thongKeTinhHinhXuLy(ModelMap model,@PathVariable("nguoidung") int nguoidung,
			@PathVariable("tungay") String tungay,
			@PathVariable("denngay") String denngay){
		
				
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd"); 
		Date dtungay = null;
		Date ddenngay = null;
		
		try {
			dtungay = dateFormat.parse(tungay);
			ddenngay = dateFormat.parse(denngay);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		
			
		return buocxulyService.thongKeTinhHinhXuLy(nguoidung, dtungay, ddenngay);
	}
	
	
	
	
}
