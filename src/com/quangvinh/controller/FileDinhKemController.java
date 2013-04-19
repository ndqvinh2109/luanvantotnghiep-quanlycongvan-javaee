package com.quangvinh.controller;

import java.io.IOException;
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

import com.quangvinh.model.FileDinhKem;
import com.quangvinh.model.VanBan;
import com.quangvinh.service.IFileDinhKemService;
import com.quangvinh.service.IVanBanService;

@Controller
public class FileDinhKemController {
	
	@Autowired
	private IFileDinhKemService filedinhkemService;
	@Autowired
	private IVanBanService vanbanService;
	
	@RequestMapping(value="/showFileDinhKem/{mavanban}.action",method=RequestMethod.GET)
	public String showFileDinhKem(Map<String,Object> map,@PathVariable("mavanban") int maVanBan){
		map.put("filedinhkem",new FileDinhKem());
		map.put("mavanbanDinhKem", maVanBan);
		map.put("showFileDinhKemList", filedinhkemService.getFileDinhKemVanBan(maVanBan));
		return "redirectdinhkem";
	}
	
	
	@RequestMapping(value="/save/{mavanban}", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("filedinhkem") FileDinhKem filedinhkem,
            @RequestParam("file") MultipartFile file,
            @RequestParam("mavanban") int mavanban,
            @PathVariable("mavanban") int mavanban2,
            Map<String, Object> map
          ) {
		map.put("mavanbanDinhKem2", mavanban2);
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
        
        return "redirectdinhkem";
    }
	
	@RequestMapping("/downloaddk/{fileDinhKemId}")
    public String downloaddk(@PathVariable("fileDinhKemId")
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
	
	@RequestMapping("/xemtructuyendk/{fileDinhKemId}")
    public String xemtructuyendk(@PathVariable("fileDinhKemId")
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
	
@RequestMapping("/xoaDinhKem/{madinhkem}")
	public @ResponseBody boolean xoaDinhKem(@PathVariable("madinhkem") int madinhkem){
		
		int oldSize = filedinhkemService.getFileDinhKem().size();
		filedinhkemService.deleteFileDinhKem(madinhkem);
		return (oldSize > filedinhkemService.getFileDinhKem().size());
	}
}
