package com.quangvinh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.CapDoBaoMat;
import com.quangvinh.model.CapDoKhan;
import com.quangvinh.model.HoSoLuuTru;
import com.quangvinh.model.LinhVuc;
import com.quangvinh.model.LoaiVanBan;
import com.quangvinh.model.VanBanDi;
import com.quangvinh.model.ViTriLuuTru;
import com.quangvinh.service.IBuocXuLyService;
import com.quangvinh.service.ICapDoBaoMatService;
import com.quangvinh.service.ICapDoKhanService;
import com.quangvinh.service.IDonViService;
import com.quangvinh.service.IHoSoLuuTruService;
import com.quangvinh.service.ILinhVucService;
import com.quangvinh.service.ILoaiVanBanService;
import com.quangvinh.service.IVanBanDiService;

import com.quangvinh.service.IVanBanService;
import com.quangvinh.service.IViTriLuuTruService;

@Controller
public class VanBanDiController {
	
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
	private IBuocXuLyService buocxulyService;
	@Autowired
	private IVanBanDiService vanbandiService;
	
	@RequestMapping("/nhapvanbandi")
	public String pageNhapVanBanDi(Map<String,Object> map){
		try{
			map.put("donViList",donviService.getDonVi());
			map.put("loaiVanBanList", loaivanbanService.getLoaiVanBan());
			map.put("viTriLuuTruList", vitriluutruService.getViTriLuuTru());
			map.put("linhVucList",linhvucService.getLinhVuc());
			map.put("capDoKhanList", capdokhanService.getCapDoKhan());
			map.put("capDoBaoMatList", capdobaomatService.getCapDoBaoMat());
			map.put("hoSoLuuTruList", hosoluutruService.getHoSoLuuTru());
			map.put("maxSoDi",vanbandiService.getMaxSoDi());
		}catch(Exception e){e.printStackTrace();}
		return "nhapvanbandi";
	}
	
	/**
	 * Save VanBanDi
	 * @param sodi
	 * @param ngaydi
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
	@RequestMapping(value="/saveVanBanDi/" +
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
	public @ResponseBody boolean addVanBanDi(
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
			int oldSize = vanbanService.getVanBan().size(); 
			LoaiVanBan oloaivanban = loaivanbanService.findLoaiVanBanID(loaivanban);
			ViTriLuuTru ovitriluutru = vitriluutruService.findViTriLuuTruID(vitriluutru);
			LinhVuc olinhvuc = linhvucService.findLinhVucID(linhvuc);
			CapDoKhan ocapdokhan = capdokhanService.findCapDoKhanID(capdokhan);
			CapDoBaoMat ocapdobaomat = capdobaomatService.findCapDoBaoMatID(capdobaomat);
			HoSoLuuTru ohosoluutru = hosoluutruService.findHoSoLuuTruID(sohoso);
			
			System.out.println(ngaybanhanh + '/' + ngayhieuluc + '/' + ngayketthuc + '/' +  coquanbanhanh + '/' + sovakyhieu + '/' + loaivanban + '/' + vitriluutru +
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
			/*Date dngaydi = null;*/
			Date dngaynhapmay = null;
			try {
				dngaybanhanh = dateFormat.parse(ngaybanhanh);
				dngayhieuluc = dateFormat.parse(ngayhieuluc);
				dngayketthuc = dateFormat.parse(ngayketthuc);
//				dngaydi = dateFormat.parse(ngaydi);
				dngaynhapmay = dateFormat.parse(ngaynhapmay);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			/**
			 * Save VanBanDi with contructor function many parameters
			 */
			VanBanDi vanbanDi = new VanBanDi(ocapdobaomat, olinhvuc, oloaivanban,
					ocapdokhan, ovitriluutru, ohosoluutru, sovakyhieu, dngaybanhanh,
					dngayhieuluc, dngayketthuc,dngaynhapmay, trichyeu, nguoiky, sotrang,
					tukhoa, trangthaixuly);
		
			vanbandiService.saveVanBanDi(vanbanDi);
			
			/*VanBan vanban = new VanBan(ocapdobaomat, olinhvuc, oloaivanban, ocapdokhan,
					ovitriluutru, ohosoluutru, sovakyhieu, dngaybanhanh, dngayhieuluc,
					dngayketthuc, dngaynhapmay, trichyeu, nguoiky, sotrang, tukhoa, trangthaixuly);
			
			VanBanDi vanbandi = new VanBanDi(vanban.getMaVanBan());
			vanbandiService.saveVanBanDi(vanbandi);
			vanbanService.saveVanBan(vanban);*/
			return (oldSize < vanbanService.getVanBan().size());
			
	}
	
}
