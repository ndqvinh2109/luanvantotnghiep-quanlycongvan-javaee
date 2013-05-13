package com.quangvinh.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.quangvinh.model.VanBanDi;
import com.quangvinh.model.VanBanDi_DonVi;
import com.quangvinh.model.ViTriLuuTru;
import com.quangvinh.service.IBuocXuLyService;
import com.quangvinh.service.ICapDoBaoMatService;
import com.quangvinh.service.ICapDoKhanService;
import com.quangvinh.service.IDonViService;
import com.quangvinh.service.IFileDinhKemService;
import com.quangvinh.service.IHoSoLuuTruService;
import com.quangvinh.service.ILinhVucService;
import com.quangvinh.service.ILoaiVanBanService;
import com.quangvinh.service.INguoiDungService;
import com.quangvinh.service.IVanBanDenService;
import com.quangvinh.service.IVanBanDiService;
import com.quangvinh.service.IVanBanDi_DonViService;
import com.quangvinh.service.IVanBanService;
import com.quangvinh.service.IViTriLuuTruService;

@Controller
public class DanhSachVanBanDiController {
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
	private IVanBanDiService vanbandiService;
	@Autowired
	private IBuocXuLyService buocxulyService;
	@Autowired
	private IFileDinhKemService filedinhkemService;
	@Autowired
	private IVanBanDenService vanbandenService;
	@Autowired
	private INguoiDungService nguoidungService;
	@Autowired
	private IVanBanDi_DonViService vanbandi_donviService;
	
	@RequestMapping("/showvanbandi/{page}")
	public String showVanBandi(Map<String,Object> map,@PathVariable("page") int page){
		List<VanBanDi> vanbandis = vanbandiService.getVanBanDi();
		int per_page = 10;
		int count = vanbandis.size();
		int pages = Math.round(count/per_page);
		if((count%per_page)!= 0){
			pages ++;
			
		}
		map.put("vanbandiList",vanbandiService.getVanBanDiPaging(page));
		map.put("donViList",donviService.getDonViDocLap(1));
		map.put("loaiVanBanList", loaivanbanService.getLoaiVanBan());
		map.put("viTriLuuTruList", vitriluutruService.getViTriLuuTru());
		map.put("linhVucList",linhvucService.getLinhVuc());
		map.put("capDoKhanList", capdokhanService.getCapDoKhan());
		map.put("capDoBaoMatList", capdobaomatService.getCapDoBaoMat());
		map.put("hoSoLuuTruList", hosoluutruService.getHoSoLuuTru());
		map.put("filedinhkem",new FileDinhKem());
		map.put("donvidoclapList", donviService.getDonViDocLap(2));
		map.put("donviphuthuocList", donviService.getDonViDocLap(3));
		map.put("maxSoDi",vanbandiService.getMaxSoDi());
		map.put("pages", pages);
		return "danhsachvanbandi";
	}
	@RequestMapping(value="/getDonViXuLy/{mavanban}",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDonViXuLy(@PathVariable("mavanban") int maVanBan){
		Map<String,Object> map = new HashMap<String,Object>();
		List<VanBanDi_DonVi> listbxl = vanbandi_donviService.getListVBDVDaBH(maVanBan);
		List<Object> str = new ArrayList<Object>(0);
		for(VanBanDi_DonVi strnd : listbxl){
			str.add(strnd.getDonvi().getTenDonVi());
		}
		map.put("ListBXLDaXuLy", str);
		
		return map;
	}
	
	@RequestMapping("/downloadvbd/{fileDinhKemId}")
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
	
	@RequestMapping("/xemtructuyenvbd/{fileDinhKemId}")
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
	
	/*@RequestMapping(value="/getFileDinhKemJsonsvbd/{mavanban}",method = RequestMethod.GET)
	public @ResponseBody List<FileDinhKem> getFileDinhKemJsons(@PathVariable("mavanban") int mavanban){
		return filedinhkemService.getFileDinhKemVanBan(mavanban);
	}*/
	
	@RequestMapping(value="/savevanbandi", method = RequestMethod.POST)
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
        
        return "redirect:showvanbandi.html";
    }
	
	/*@RequestMapping(value="/getmavanban/{mavanban}",method=RequestMethod.GET)
	public @ResponseBody VanBandi getmavanban(@PathVariable("mavanban") int maVanBan){
		VanBandi vanbandi = new VanBandi();
		vanbandi = vanbandiService.findVanBandiID(maVanBan);
		return vanbandi;
	}*/
	
	@RequestMapping(value="/getmavanbandi/{mavanban}",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getmavanban(@PathVariable("mavanban") int maVanBan){
		Map<String,Object> map = new HashMap<String,Object>();
		VanBanDi vanbandi = new VanBanDi();
		vanbandi = vanbandiService.findVanBanDiID(maVanBan);
		map.put("vanbandiupdate",vanbandi);
		map.put("loaivanban", vanbandi.getLoaivanban().getMaLoaiVanBan());
		map.put("vitriluutru", vanbandi.getVitriluutru().getStt());
		map.put("linhvuc", vanbandi.getVitriluutru().getStt());
		map.put("capdokhan", vanbandi.getCapdokhan().getMaDoKhan());
		map.put("capdobaomat", vanbandi.getCapdobaomat().getMaDoMat());
		map.put("sohoso", vanbandi.getHosoluutru().getSoHoSo());
		map.put("trangthaixuly", vanbandi.getTrangThaiXuLy());
		map.put("fileDinhKemList", filedinhkemService.getFileDinhKemVanBan(maVanBan));
		return map;
	}
	@RequestMapping(value="/deletevanbandi/{mavanban}",method=RequestMethod.GET)
	public @ResponseBody boolean deleteVanBandi(@PathVariable("mavanban") int maVanBan){
		int oldSize = vanbandiService.getVanBanDi().size();
		System.out.println(oldSize);
		vanbandiService.deleteVanBanDi(maVanBan);
		return (oldSize > vanbandiService.getVanBanDi().size());
	}
	
	
	/**
	 * Update VanBandi
	 * @param mavanban
	 * @param sodi
	 * @param ngaydi
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
	@RequestMapping(value="/updateVanBandi/" +
			"{sodi}/" +
			"{ngaydi}/" +
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
	public @ResponseBody boolean updateVanBandi(
			@PathVariable("sodi") int sodi,
			@PathVariable("ngaydi") String  ngaydi,
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
		
			LoaiVanBan oloaivanban = loaivanbanService.findLoaiVanBanID(loaivanban);
			ViTriLuuTru ovitriluutru = vitriluutruService.findViTriLuuTruID(vitriluutru);
			LinhVuc olinhvuc = linhvucService.findLinhVucID(linhvuc);
			CapDoKhan ocapdokhan = capdokhanService.findCapDoKhanID(capdokhan);
			CapDoBaoMat ocapdobaomat = capdobaomatService.findCapDoBaoMatID(capdobaomat);
			HoSoLuuTru ohosoluutru = hosoluutruService.findHoSoLuuTruID(sohoso);
			
			System.out.println(sotrang + "/" + sodi + '/' + ngayhieuluc + '/' + ngayketthuc + '/' + ngaybanhanh + '/' +
					ngaydi + '/' + sovakyhieu + '/' + loaivanban + '/' + vitriluutru +
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
			Date dngaydi = null;
			Date dngaynhapmay = null;
			try {
				dngaybanhanh = dateFormat.parse(ngaybanhanh);
				dngayhieuluc = dateFormat.parse(ngayhieuluc);
				dngayketthuc = dateFormat.parse(ngayketthuc);
				dngaydi = dateFormat.parse(ngaydi);
				dngaynhapmay = dateFormat.parse(ngaynhapmay);
			} catch (ParseException e) {
				
				e.printStackTrace();
			} 
			
			/**
			 * Save VanBandi with contructor function many parameters
			 */
			
			VanBanDi vanbandi= new VanBanDi(ocapdobaomat, olinhvuc, oloaivanban,
					ocapdokhan, ovitriluutru, ohosoluutru, mavanban, sovakyhieu, dngaybanhanh,
					dngayhieuluc, dngayketthuc, trichyeu, nguoiky, sotrang,
					tukhoa, dngaynhapmay, trangthaixuly, sodi, dngaydi);
			vanbandiService.updateVanBanDi(vanbandi);
			
			return true;
			
						
	}
	
	/**
	 * TODO: Test
	 * @param mavanban
	 * @param madonvi
	 * @return
	 */
	@RequestMapping(value="/addVanBanGuiDonVi/{mavanban}/{madonvi}",method=RequestMethod.POST)
	public @ResponseBody boolean addVanBanGuiDonVi(@PathVariable("mavanban") int mavanban,
			@PathVariable("madonvi") int madonvi){
		
	DonVi donvi = donviService.findDonViID(madonvi);
	VanBanDi vanbandi = vanbandiService.findVanBanDiID(mavanban);
	
	VanBanDi_DonVi vanbandi_donvi = new VanBanDi_DonVi();
	
	vanbandi_donvi.setDonvi(donvi);
	vanbandi_donvi.setVanbandi(vanbandi);
	vanbandi_donviService.saveVanBanDi_DonVi(vanbandi_donvi);
	
	return true;
	
	}
	
	@RequestMapping(value="/BanHanhVanBanDi/{mavanban}",method=RequestMethod.GET)
	public @ResponseBody boolean addVanBanGuiDonVi(@PathVariable("mavanban") int mavanban){
		System.out.println(mavanban);
		VanBan vanban = vanbanService.findVanBanID(mavanban);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); 
		int manguoidung = nguoidungService.getMaNguoiDungTheoUsername(name);
		DonVi donvi = donviService.findDonViID(nguoidungService.getMaDonViTheoMaNguoiDung(manguoidung));
		
		VanBanDen vanbanden = new VanBanDen(vanban.getCapdobaomat(), vanban.getLinhvuc(), 
				vanban.getLoaivanban(), vanban.getCapdokhan(), vanban.getVitriluutru(), 
				vanban.getHosoluutru(), vanban.getSoKyHieuVanBan(), vanban.getNgayBanHanh(), 
				vanban.getNgayHieuLuc(), vanban.getNgayHetHieuLuc(), vanban.getNgayNhapMay(), 
				vanban.getTrichYeu(), vanban.getNguoiKy(), vanban.getSoTrang(), vanban.getTuKhoa(), 
				vanban.getTrangThaiXuLy(), donvi);
		vanbandenService.saveVanBanDen(vanbanden);
		
		
		
		
		return true;
	
	}
}	
