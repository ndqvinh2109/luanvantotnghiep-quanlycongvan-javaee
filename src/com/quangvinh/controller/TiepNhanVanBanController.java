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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.CapDoBaoMat;
import com.quangvinh.model.CapDoKhan;
import com.quangvinh.model.DonVi;
import com.quangvinh.model.FileDinhKem;
import com.quangvinh.model.HoSoLuuTru;
import com.quangvinh.model.LinhVuc;
import com.quangvinh.model.LoaiVanBan;
import com.quangvinh.model.VanBan;
import com.quangvinh.model.VanBanDen;
import com.quangvinh.model.ViTriLuuTru;
import com.quangvinh.service.IBuocXuLyService;
import com.quangvinh.service.ICapDoBaoMatService;
import com.quangvinh.service.ICapDoKhanService;
import com.quangvinh.service.IDonViService;
import com.quangvinh.service.IFileDinhKemService;
import com.quangvinh.service.IHoSoLuuTruService;
import com.quangvinh.service.ILinhVucService;
import com.quangvinh.service.ILoaiVanBanService;
import com.quangvinh.service.IVanBanDenService;
import com.quangvinh.service.IVanBanDiService;
import com.quangvinh.service.IVanBanService;
import com.quangvinh.service.IViTriLuuTruService;

@Controller
public class TiepNhanVanBanController {

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
	@Autowired
	private IFileDinhKemService filedinhkemService;
	@Autowired
	private IVanBanDiService vanbandiService;
	
	@RequestMapping("/tiepNhanVanBanDen")
	public String tiepNhanVanBanDen(Map<String,Object> map){
		
		map.put("ListVanBanChuaTiepNhan", vanbandenService.getVanBanDenChuaTiepNhan());
		map.put("maxsoden",vanbandenService.getMaxSoDen());
		map.put("donViList",donviService.getDonVi());
		map.put("loaiVanBanList", loaivanbanService.getLoaiVanBan());
		map.put("viTriLuuTruList", vitriluutruService.getViTriLuuTru());
		map.put("linhVucList",linhvucService.getLinhVuc());
		map.put("capDoKhanList", capdokhanService.getCapDoKhan());
		map.put("capDoBaoMatList", capdobaomatService.getCapDoBaoMat());
		map.put("hoSoLuuTruList", hosoluutruService.getHoSoLuuTru());
		return "tiepnhanvanban";
	}
	
	
	
	@RequestMapping(value="/getmavanbantiepnhan/{mavanban}",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getmavanban(@PathVariable("mavanban") int maVanBan){
		Map<String,Object> map = new HashMap<String,Object>();
		VanBanDen vanbanden = new VanBanDen();
		vanbanden = vanbandenService.findVanBanDenID(maVanBan);
		map.put("vanbandenupdate",vanbanden);
		map.put("coquanbanhanh", vanbanden.getDonvi().getMaDonVi());
		map.put("loaivanban", vanbanden.getLoaivanban().getMaLoaiVanBan());
		map.put("vitriluutru", vanbanden.getVitriluutru().getStt());
		map.put("linhvuc", vanbanden.getVitriluutru().getStt());
		map.put("capdokhan", vanbanden.getCapdokhan().getMaDoKhan());
		map.put("capdobaomat", vanbanden.getCapdobaomat().getMaDoMat());
		map.put("sohoso", vanbanden.getHosoluutru().getSoHoSo());
		map.put("trangthaixuly", vanbanden.getTrangThaiXuLy());
		map.put("fileDinhKemList", filedinhkemService.getFileDinhKemVanBan(maVanBan));
		return map;
	}
	
	
	/**
	 * Update VanBanDen
	 * @param mavanban
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
	@RequestMapping(value="/updateVanBanDenTiepNhan/" +
			"{soden}/" +
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
			"{sotrang}/" +
			"{mavanban}"
			,method=RequestMethod.POST)
	public @ResponseBody boolean updateVanBanDen(
			@PathVariable("soden") int soden,
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
			@PathVariable("sotrang") int sotrang,
			@PathVariable("mavanban") int mavanban
			){
		
			/**
			 * Get object
			 */
			DonVi odonvi = donviService.findDonViID(coquanbanhanh);
			LoaiVanBan oloaivanban = loaivanbanService.findLoaiVanBanID(loaivanban);
			ViTriLuuTru ovitriluutru = vitriluutruService.findViTriLuuTruID(vitriluutru);
			LinhVuc olinhvuc = linhvucService.findLinhVucID(linhvuc);
			CapDoKhan ocapdokhan = capdokhanService.findCapDoKhanID(capdokhan);
			CapDoBaoMat ocapdobaomat = capdobaomatService.findCapDoBaoMatID(capdobaomat);
			HoSoLuuTru ohosoluutru = hosoluutruService.findHoSoLuuTruID(sohoso);
			
			
			System.out.println(sotrang + "/" + soden + '/' + ngayhieuluc + '/' + ngayketthuc + '/' + ngaybanhanh + '/' +
					ngayden + '/' + coquanbanhanh + '/' + sovakyhieu + '/' + loaivanban + '/' + vitriluutru +
					'/' + linhvuc + '/' + capdokhan + '/' + capdobaomat + '/' + sohoso + '/' +
					trangthaixuly + '/' + trichyeu + '/' + tukhoa + '/' + nguoiky + '/' + mavanban);
			
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
			List<FileDinhKem> filedinhkemList = filedinhkemService.getFileDinhKemTheoSoKyHieu(sovakyhieu);
			VanBanDen vanbanden= new VanBanDen(ocapdobaomat, olinhvuc, oloaivanban,
					ocapdokhan, ovitriluutru, ohosoluutru, mavanban, sovakyhieu,
					dngaybanhanh, dngayhieuluc, dngayketthuc, trichyeu, nguoiky,
					sotrang, tukhoa, dngaynhapmay, trangthaixuly, odonvi, soden, dngayden);
			vanbandenService.updateVanBanDen(vanbanden);
			
			VanBan vanban =  vanbanService.findVanBanID(vanbanden.getMaVanBan());
			for (FileDinhKem filedinhkem: filedinhkemList){
				FileDinhKem filedinhkemtemp= new FileDinhKem();
				filedinhkemtemp.setKieuTapTin(filedinhkem.getKieuTapTin());
				filedinhkemtemp.setMoTa(filedinhkem.getMoTa());
				filedinhkemtemp.setNoiDung(filedinhkem.getNoiDung());
				filedinhkemtemp.setTenFile(filedinhkem.getTenFile());
				filedinhkemtemp.setVanban(vanban);
				filedinhkemService.addFileDinhKem(filedinhkemtemp);
			}
			int result1 = vanbanService.capNhatBooleanTiepNhan(true, mavanban);
			System.out.println(result1);
			
			
			
			
			return true;
			
						
	}
	
	
}
