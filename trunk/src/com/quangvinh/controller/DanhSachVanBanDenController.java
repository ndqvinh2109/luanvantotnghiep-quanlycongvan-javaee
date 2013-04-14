package com.quangvinh.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
public class DanhSachVanBanDenController {

	
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
	
	@RequestMapping("/showvanbanden/{page}")
	public String showVanBanDen(Map<String,Object> map,@PathVariable("page") int page){
		List<VanBanDen> vanbandens = vanbandenService.getVanBanDen();
		int per_page = 3;
		int count = vanbandens.size();
		int pages = Math.round(count/per_page);
		if((count%per_page)!= 0){
			pages ++;
		}
		
		map.put("vanbandenList",vanbandenService.getVanBanDenPaging(page));
		map.put("donViList",donviService.getDonVi());
		map.put("loaiVanBanList", loaivanbanService.getLoaiVanBan());
		map.put("viTriLuuTruList", vitriluutruService.getViTriLuuTru());
		map.put("linhVucList",linhvucService.getLinhVuc());
		map.put("capDoKhanList", capdokhanService.getCapDoKhan());
		map.put("capDoBaoMatList", capdobaomatService.getCapDoBaoMat());
		map.put("hoSoLuuTruList", hosoluutruService.getHoSoLuuTru());
		map.put("filedinhkem",new FileDinhKem());
		map.put("fileDinhKemListAll", filedinhkemService.getFileDinhKem());
		
		map.put("pages", pages);
		/*System.out.println(pages);*/
		return "danhsachvanbanden";
	}
	
	@RequestMapping("/download/{fileDinhKemId}")
    public String download(@PathVariable("fileDinhKemId")
            int fileDinhKemId, HttpServletResponse response) {
         
        FileDinhKem doc = filedinhkemService.get(fileDinhKemId);
        response.setContentType(doc.getKieuTapTin());
        response.setContentLength(doc.getNoiDung().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" +doc.getTenFile()+ "\"");
       
        try {
			FileCopyUtils.copy(doc.getNoiDung(),response.getOutputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        return null;
    }
	
	@RequestMapping("/xemtructuyen/{fileDinhKemId}")
    public String xemtructuyen(@PathVariable("fileDinhKemId")
            int fileDinhKemId, HttpServletResponse response) {
         
        FileDinhKem doc = filedinhkemService.get(fileDinhKemId);
        response.setContentType(doc.getKieuTapTin());
        response.setContentLength(doc.getNoiDung().length);
       
        response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getTenFile()+ "\"");
        try {
			FileCopyUtils.copy(doc.getNoiDung(),response.getOutputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        return null;
    }
	
	/*@RequestMapping(value="/getFileDinhKemJsons/{mavanban}",method = RequestMethod.GET)
	public @ResponseBody List<FileDinhKem> getFileDinhKemJsons(@PathVariable("mavanban") int mavanban){
		return filedinhkemService.getFileDinhKemVanBan(mavanban);
	}*/
	
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("filedinhkem") FileDinhKem filedinhkem,
            @RequestParam("file") MultipartFile file,
            @RequestParam("mavanban") int mavanban
          ) {
        System.out.println("Name:" + filedinhkem.getTenFile());
        System.out.println("Desc:" + filedinhkem.getMoTa());
        System.out.println("File:" + file.getOriginalFilename());
        System.out.println("ContentType:" + file.getContentType());
        System.out.println(mavanban);
        
        VanBan vanban = vanbanService.findVanBanID(mavanban);
        FileDinhKem fileDinhKem = new FileDinhKem();	
        fileDinhKem.setTenFile(file.getOriginalFilename());
        fileDinhKem.setMoTa(filedinhkem.getMoTa());
        fileDinhKem.setKieuTapTin(file.getContentType());
        fileDinhKem.setVanban(vanban);
        try {
			fileDinhKem.setNoiDung(file.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        filedinhkemService.addFileDinhKem(fileDinhKem);        
        
        return "redirect:showvanbanden.html";
    }
	
	/*@RequestMapping(value="/getmavanban/{mavanban}",method=RequestMethod.GET)
	public @ResponseBody VanBanDen getmavanban(@PathVariable("mavanban") int maVanBan){
		VanBanDen vanbanden = new VanBanDen();
		vanbanden = vanbandenService.findVanBanDenID(maVanBan);
		return vanbanden;
	}*/
	
	@RequestMapping(value="/getmavanban/{mavanban}",method=RequestMethod.GET)
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
	
	
	
	@RequestMapping(value="/deletevanbanden/{mavanban}",method=RequestMethod.GET)
	public @ResponseBody boolean deleteVanBanDen(@PathVariable("mavanban") int maVanBan){
		int oldSize = vanbandenService.getVanBanDen().size();
		System.out.println(oldSize);
		vanbandenService.deleteVanBanDen(maVanBan);
		return (oldSize > vanbandenService.getVanBanDen().size());
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
	@RequestMapping(value="/updateVanBanDen/" +
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
			"{maVanBan}"
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
			@PathVariable("maVanBan") int mavanban
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
			
			VanBanDen vanbanden= new VanBanDen(ocapdobaomat, olinhvuc, oloaivanban,
					ocapdokhan, ovitriluutru, ohosoluutru, mavanban, sovakyhieu, dngaybanhanh,
					dngayhieuluc, dngayketthuc, trichyeu, nguoiky, sotrang,
					tukhoa, dngaynhapmay, trangthaixuly, odonvi, soden, dngayden);
			vanbandenService.updateVanBanDen(vanbanden);
			
			return true;
			
						
	}
	
}
