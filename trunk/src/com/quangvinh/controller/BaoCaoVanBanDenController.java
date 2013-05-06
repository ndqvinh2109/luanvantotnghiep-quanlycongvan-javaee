package com.quangvinh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.quangvinh.model.CapDoBaoMat;
import com.quangvinh.model.CapDoKhan;
import com.quangvinh.model.LinhVuc;
import com.quangvinh.model.LoaiVanBan;
import com.quangvinh.model.VanBanDen;
import com.quangvinh.service.ICapDoBaoMatService;
import com.quangvinh.service.ICapDoKhanService;
import com.quangvinh.service.ILinhVucService;
import com.quangvinh.service.ILoaiVanBanService;
import com.quangvinh.service.IVanBanDenService;

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
		@Autowired
		private IVanBanDenService vanbandenService;
				
		@RequestMapping("/baoCaoVanBanDen")
		public String loadPageBaoCaoVanBanDen(){
				
			return "baocaovanbanden";
		
		}
		
		@RequestMapping(value="/PdfVanBanDen/{madanhmuc}/{tungay}/{denngay}")
		public String PdfVanBanDenSummary(Map<String,Object> map,@PathVariable("madanhmuc") int madanhmuc,
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
			
			
			Map<Integer,String> mapTemp = new HashMap<Integer,String>();
			Map<Integer,Object[]> mapTempVanban = new HashMap<Integer,Object[]>();
				if(madanhmuc == 1){
				List<LoaiVanBan> loaivanbanList = loaivanbanService.getLoaiVanBan();
				for(LoaiVanBan loaivanban : loaivanbanList){
					mapTemp.put(loaivanban.getMaLoaiVanBan(), loaivanban.getTenLoaiVanBan());
				}
				List<VanBanDen> vanbandenList = vanbandenService.getVanBanDen();
				for(VanBanDen vanbanden : vanbandenList){
					mapTempVanban.put(vanbanden.getMaVanBan(), new Object [] {vanbanden.getSoDen(),vanbanden.getNgayDen(),vanbanden.getSoKyHieuVanBan(),vanbanden.getNgayNhapMay(),vanbanden.getTrichYeu(),vanbanden.getLoaivanban().getMaLoaiVanBan()});
				}
				map.put("printDataVanBanDen", mapTempVanban);
				map.put("printData", mapTemp);
				map.put("tungay", dtungay);
				map.put("denngay", ddenngay);
				
				
				}
				
				if(madanhmuc == 2){
					
					List<CapDoBaoMat> capdobaomatList = capdobaomatSerice.getCapDoBaoMat();
					for(CapDoBaoMat capdobaomat: capdobaomatList){
						mapTemp.put(capdobaomat.getMaDoMat(), capdobaomat.getTenDoMat());
						
					}
					List<VanBanDen> vanbandenList = vanbandenService.getVanBanDen();
					for(VanBanDen vanbanden : vanbandenList){
						mapTempVanban.put(vanbanden.getMaVanBan(), new Object [] {vanbanden.getSoDen(),vanbanden.getNgayDen(),vanbanden.getSoKyHieuVanBan(),vanbanden.getNgayNhapMay(),vanbanden.getTrichYeu(),vanbanden.getCapdobaomat().getMaDoMat()});
					}
					map.put("printDataVanBanDen", mapTempVanban);
					map.put("printData", mapTemp);
					map.put("tungay", dtungay);
					map.put("denngay", ddenngay);
				}
				
				if(madanhmuc == 3){
					List<CapDoKhan> capdokhanList = capdokhanService.getCapDoKhan();
					for(CapDoKhan capdokhan: capdokhanList){
						mapTemp.put(capdokhan.getMaDoKhan(), capdokhan.getTenDoKhan());
					}
					List<VanBanDen> vanbandenList = vanbandenService.getVanBanDen();
					for(VanBanDen vanbanden : vanbandenList){
						mapTempVanban.put(vanbanden.getMaVanBan(), new Object [] {vanbanden.getSoDen(),vanbanden.getNgayDen(),vanbanden.getSoKyHieuVanBan(),vanbanden.getNgayNhapMay(),vanbanden.getTrichYeu(),vanbanden.getCapdokhan().getMaDoKhan()});
					}
					map.put("printDataVanBanDen", mapTempVanban);
					map.put("printData", mapTemp);
					map.put("tungay", dtungay);
					map.put("denngay", ddenngay);
					
				}
				
				if(madanhmuc == 4){
					List<LinhVuc> linhvucList =  linhvucService.getLinhVuc();
					for(LinhVuc linhvuc : linhvucList){
						mapTemp.put(linhvuc.getMaLinhVuc(),linhvuc.getTenLinhVuc());
						
					}
					List<VanBanDen> vanbandenList = vanbandenService.getVanBanDen();
					for(VanBanDen vanbanden : vanbandenList){
						mapTempVanban.put(vanbanden.getMaVanBan(), new Object [] {vanbanden.getSoDen(),vanbanden.getNgayDen(),vanbanden.getSoKyHieuVanBan(),vanbanden.getNgayNhapMay(),vanbanden.getTrichYeu(),vanbanden.getLinhvuc().getMaLinhVuc()});
					}
					map.put("printDataVanBanDen", mapTempVanban);
					map.put("printData", mapTemp);
					map.put("tungay", dtungay);
					map.put("denngay", ddenngay);
				}
			
			return "virtualVanban";
			
		}	
		
		
		@RequestMapping(value="/exportPDF/{madanhmuc}/{tungay}/{denngay}")
		public String exportPDF(Map<String,Object> map,@PathVariable("madanhmuc") int madanhmuc,
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
			
			
			Map<Integer,String> mapTemp = new HashMap<Integer,String>();
			Map<Integer,Object[]> mapTempVanban = new HashMap<Integer,Object[]>();
				if(madanhmuc == 1){
				List<LoaiVanBan> loaivanbanList = loaivanbanService.getLoaiVanBan();
				for(LoaiVanBan loaivanban : loaivanbanList){
					mapTemp.put(loaivanban.getMaLoaiVanBan(), loaivanban.getTenLoaiVanBan());
				}
				List<VanBanDen> vanbandenList = vanbandenService.getVanBanDen();
				for(VanBanDen vanbanden : vanbandenList){
					mapTempVanban.put(vanbanden.getMaVanBan(), new Object [] {vanbanden.getSoDen(),vanbanden.getNgayDen(),vanbanden.getSoKyHieuVanBan(),vanbanden.getNgayNhapMay(),vanbanden.getTrichYeu(),vanbanden.getLoaivanban().getMaLoaiVanBan()});
				}
				map.put("printDataVanBanDen", mapTempVanban);
				map.put("printData", mapTemp);
				map.put("tungay", dtungay);
				map.put("denngay", ddenngay);
				
				
				}
				
				if(madanhmuc == 2){
					
					List<CapDoBaoMat> capdobaomatList = capdobaomatSerice.getCapDoBaoMat();
					for(CapDoBaoMat capdobaomat: capdobaomatList){
						mapTemp.put(capdobaomat.getMaDoMat(), capdobaomat.getTenDoMat());
						
					}
					List<VanBanDen> vanbandenList = vanbandenService.getVanBanDen();
					for(VanBanDen vanbanden : vanbandenList){
						mapTempVanban.put(vanbanden.getMaVanBan(), new Object [] {vanbanden.getSoDen(),vanbanden.getNgayDen(),vanbanden.getSoKyHieuVanBan(),vanbanden.getNgayNhapMay(),vanbanden.getTrichYeu(),vanbanden.getCapdobaomat().getMaDoMat()});
					}
					map.put("printDataVanBanDen", mapTempVanban);
					map.put("printData", mapTemp);
					map.put("tungay", dtungay);
					map.put("denngay", ddenngay);
				}
				
				if(madanhmuc == 3){
					List<CapDoKhan> capdokhanList = capdokhanService.getCapDoKhan();
					for(CapDoKhan capdokhan: capdokhanList){
						mapTemp.put(capdokhan.getMaDoKhan(), capdokhan.getTenDoKhan());
					}
					List<VanBanDen> vanbandenList = vanbandenService.getVanBanDen();
					for(VanBanDen vanbanden : vanbandenList){
						mapTempVanban.put(vanbanden.getMaVanBan(), new Object [] {vanbanden.getSoDen(),vanbanden.getNgayDen(),vanbanden.getSoKyHieuVanBan(),vanbanden.getNgayNhapMay(),vanbanden.getTrichYeu(),vanbanden.getCapdokhan().getMaDoKhan()});
					}
					map.put("printDataVanBanDen", mapTempVanban);
					map.put("printData", mapTemp);
					map.put("tungay", dtungay);
					map.put("denngay", ddenngay);
					
				}
				
				if(madanhmuc == 4){
					List<LinhVuc> linhvucList =  linhvucService.getLinhVuc();
					for(LinhVuc linhvuc : linhvucList){
						mapTemp.put(linhvuc.getMaLinhVuc(),linhvuc.getTenLinhVuc());
						
					}
					List<VanBanDen> vanbandenList = vanbandenService.getVanBanDen();
					for(VanBanDen vanbanden : vanbandenList){
						mapTempVanban.put(vanbanden.getMaVanBan(), new Object [] {vanbanden.getSoDen(),vanbanden.getNgayDen(),vanbanden.getSoKyHieuVanBan(),vanbanden.getNgayNhapMay(),vanbanden.getTrichYeu(),vanbanden.getLinhvuc().getMaLinhVuc()});
					}
					map.put("printDataVanBanDen", mapTempVanban);
					map.put("printData", mapTemp);
					map.put("tungay", dtungay);
					map.put("denngay", ddenngay);
				}
			
			return "virtualVanbanPDF";
			
		}
		
		/*@RequestMapping("/getLinhVucChart")
		public @ResponseBody List<LinhVuc> getLinhVucChart(){
			
			return linhvucService.getLinhVuc();
		}*/
		
		
}
