package com.quangvinh.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.CapDoBaoMat;
import com.quangvinh.model.CapDoKhan;
import com.quangvinh.model.DonVi;
import com.quangvinh.model.HoSoLuuTru;
import com.quangvinh.model.LinhVuc;
import com.quangvinh.model.LoaiVanBan;
import com.quangvinh.model.VanBanDen;
import com.quangvinh.model.ViTriLuuTru;
import com.quangvinh.service.IBuocXuLyService;
import com.quangvinh.service.ICapDoBaoMatService;
import com.quangvinh.service.ICapDoKhanService;
import com.quangvinh.service.IDonViService;
import com.quangvinh.service.IHoSoLuuTruService;
import com.quangvinh.service.ILinhVucService;
import com.quangvinh.service.ILoaiVanBanService;
import com.quangvinh.service.IVanBanDenService;
import com.quangvinh.service.IVanBanService;
import com.quangvinh.service.IViTriLuuTruService;


/**
 * 
 * VanBanDenController class
 * @author QuangVinhPc
 *
 */
@Controller
public class VanBanDenController {
	
	/**
	 * Autowired Objects
	 * Use to call functions which return list object
	 */
	
	@Autowired
	private IDonViService donviService;
	@Autowired
	private ILoaiVanBanService loaivanbanService;
	@Autowired
	private IViTriLuuTruService vitriluutruService;
	@Autowired
	private ILinhVucService linhvucService;
	@Autowired
	private ICapDoKhanService capdokhanService;
	@Autowired
	private ICapDoBaoMatService capdobaomatService;
	@Autowired
	private IHoSoLuuTruService hosoluutruService;
	@Autowired
	private IVanBanService vanbanService;
	@Autowired
	private IVanBanDenService vanbandenService;
	@Autowired
	private IBuocXuLyService buocxulyService;
	/**
	 * Model and View
	 * Used in NhapVanBanDen.jsp
	 * @param map
	 * @return Page NhapVanBanDen.jsp
	 */

	/**
	 * TODO: Hide
	 * @param map
	 * @return
	 */
	@RequestMapping("/nhapvanbanden")
	public String pageNhapVanBan(Map<String,Object> map){
		try{
			map.put("donViList",donviService.getDonViDocLap(1));
			map.put("loaiVanBanList", loaivanbanService.getLoaiVanBan());
			map.put("viTriLuuTruList", vitriluutruService.getViTriLuuTru());
			map.put("linhVucList",linhvucService.getLinhVuc());
			map.put("capDoKhanList", capdokhanService.getCapDoKhan());
			map.put("capDoBaoMatList", capdobaomatService.getCapDoBaoMat());
			map.put("hoSoLuuTruList", hosoluutruService.getHoSoLuuTru());
			map.put("maxsoden",vanbandenService.getMaxSoDen());
		}catch(Exception e){e.printStackTrace();}
		return "nhapvanbanden";
	}
	
	
	/**
	 * Save VanBanDen
	 * @param soden
	 * @param ngayden
	 * @param coquanbanhanh
	 * @param sovakyhieu
	 * @param ngaybanhanh
	 * @param ngayhieuluc
	 * @param ngayketthuc
	 * @param loaivanban
	 * @param vitriluutru
	 * @param linhvuc
	 * @param capdokhan
	 * @param capdobaomat
	 * @param sohoso
	 * @param trangthaixuly
	 * @param trichyeu
	 * @param tukhoa
	 * @param nguoiky
	 * @param sotrang
	 */
	@RequestMapping(value="/saveVanBanDen/{soden}/" +
			"{ngayden}/" +
			"{coquanbanhanh}/" +
			"{sovakyhieu}/" +
			"{ngaybanhanh}/" +
			"{ngayhieuluc}/" +
			"{ngayketthuc}/" +
			"{ngaynhapmay}/" +
			"{loaivanban}/" +
			"{vitriluutru}/" +
			"{linhvuc}/" +
			"{capdokhan}/" +
			"{capdobaomat}/" +
			"{sohoso}/" +
			"{trangthaixuly}/" +
			"{trichyeu}/" +
			"{tukhoa}/" +
			"{nguoiky}/" +
			"{sotrang}"
			,method=RequestMethod.POST)
	public @ResponseBody boolean addVanBanDen(@PathVariable("soden") int soden,
			@PathVariable("ngayden") String  ngayden,
			@PathVariable("coquanbanhanh") int coquanbanhanh,
			@PathVariable("sovakyhieu") String sovakyhieu,
			@PathVariable("ngaybanhanh") String ngaybanhanh,
			@PathVariable("ngayhieuluc") String ngayhieuluc, 
			@PathVariable("ngayketthuc") String ngayketthuc,
			@PathVariable("ngaynhapmay") String ngaynhapmay,
			@PathVariable("loaivanban") int loaivanban,
			@PathVariable("vitriluutru") int vitriluutru,
			@PathVariable("linhvuc") int linhvuc,
			@PathVariable("capdokhan") int capdokhan,
			@PathVariable("capdobaomat") int capdobaomat,
			@PathVariable("sohoso") int sohoso,
			@PathVariable("trangthaixuly") int trangthaixuly,
			@PathVariable("trichyeu") String trichyeu,
			@PathVariable("tukhoa") String tukhoa,
			@PathVariable("nguoiky") String nguoiky,
			@PathVariable("sotrang") int sotrang
			){
		
			/**
			 * Get object
			 */
			int oldSize = vanbandenService.getVanBanDen().size(); 
			DonVi odonvi = donviService.findDonViID(coquanbanhanh);
			LoaiVanBan oloaivanban = loaivanbanService.findLoaiVanBanID(loaivanban);
			ViTriLuuTru ovitriluutru = vitriluutruService.findViTriLuuTruID(vitriluutru);
			LinhVuc olinhvuc = linhvucService.findLinhVucID(linhvuc);
			CapDoKhan ocapdokhan = capdokhanService.findCapDoKhanID(capdokhan);
			CapDoBaoMat ocapdobaomat = capdobaomatService.findCapDoBaoMatID(capdobaomat);
			HoSoLuuTru ohosoluutru = hosoluutruService.findHoSoLuuTruID(sohoso);
			
			System.out.println(ngaybanhanh + '/' + ngayhieuluc + '/' + ngayketthuc + '/' + soden + '/' +
					ngayden + '/' + coquanbanhanh + '/' + sovakyhieu + '/' + loaivanban + '/' + vitriluutru +
					'/' + linhvuc + '/' + capdokhan + '/' + capdobaomat + '/' + sohoso + '/' +
					trangthaixuly + '/' + trichyeu + '/' + tukhoa + '/' + nguoiky + '/' + sotrang);
			
			/**
			 * Convert String to Date,
			 * Because jquery.$ajax funtion is not parsed Date type, so must set type Date to String.
			 */
			SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd"); 
			Date dngaybanhanh = null;
			Date dngayketthuc = null;
			Date dngayhieuluc = null;
			Date dngayden = null;
			Date dngaynhapmay = null;
			try {
				dngaybanhanh = dateFormat.parse(ngaybanhanh);
				dngayhieuluc = dateFormat.parse(ngayhieuluc);
				dngayketthuc = dateFormat.parse(ngayketthuc);
				dngayden = dateFormat.parse(ngayden);
				dngaynhapmay = dateFormat.parse(ngaynhapmay);
			} catch (ParseException e) {
				
				e.printStackTrace();
			} 
			
			/**
			 * Save VanBanDen with contructor function many parameters
			 */
			VanBanDen vanbanDen = new VanBanDen(ocapdobaomat, olinhvuc, oloaivanban,
					ocapdokhan, ovitriluutru, ohosoluutru, sovakyhieu, dngaybanhanh,
					dngayhieuluc, dngayketthuc,dngaynhapmay, trichyeu, nguoiky, sotrang,
					tukhoa, trangthaixuly, odonvi,soden, dngayden);
			vanbanDen.setEnabled(true);
			vanbandenService.saveVanBanDen(vanbanDen);
			return (oldSize < vanbandenService.getVanBanDen().size());
						
	}
	
	@RequestMapping(value="/checkExistKyHieuVanBan/{kyhieuvanban}",method=RequestMethod.GET)
	public @ResponseBody boolean checkExistKyHieuVanBan(
			@PathVariable("kyhieuvanban") String kyhieuvanban
			){
		
		return vanbanService.checkExistKyHieuVanBan(kyhieuvanban);
	}
	
		
}
