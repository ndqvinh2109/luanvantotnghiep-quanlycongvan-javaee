package com.quangvinh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quangvinh.model.Buoc;
import com.quangvinh.model.Buoc_NguoiDung;
import com.quangvinh.model.CongViec;
import com.quangvinh.model.NguoiDung;
import com.quangvinh.model.QuyTrinh;
import com.quangvinh.model.Buoc.Pk_QuyTrinh;
import com.quangvinh.service.IBuocService;
import com.quangvinh.service.IBuoc_NguoiDungService;
import com.quangvinh.service.ICongViecService;
import com.quangvinh.service.IDonViService;
import com.quangvinh.service.INguoiDungService;
import com.quangvinh.service.IQuyTrinhService;

@Controller
public class ThemBuocThuocQuyTrinhController {

	
	@Autowired
	private IQuyTrinhService quytrinhService;
	@Autowired
	private INguoiDungService nguoidungService;
	@Autowired
	private IBuocService buocService;
	@Autowired
	private ICongViecService congviecService;
	@Autowired
	private IDonViService donviService;
	@Autowired
	private IBuoc_NguoiDungService buocndService;
	
	@RequestMapping(value="/getmaxbuoc/{maquytrinh}",method=RequestMethod.GET)
	public @ResponseBody int getMaxBuoc(@PathVariable("maquytrinh") int maquytrinh){
		
		int ret = buocService.getMaxId(maquytrinh);
		return ret;
	}
	@RequestMapping("/nhapbuocthuocquytrinh")
	public String pageTaoBuocQuyTrinh(Map<String,Object> map){
		
		map.put("quytrinhList",quytrinhService.getQuyTrinh());
		map.put("donviList", donviService.getDonVi());
		map.put("nguoidungList", nguoidungService.getNguoiDung());
		map.put("congviecList", congviecService.getCongViec());
		return "thembuocthuocquytrinh";
	}
	@RequestMapping(value="/showAllCongViec", method=RequestMethod.GET)
	public @ResponseBody List<CongViec> showAllCongViec(){
		
		return congviecService.getCongViec();
	}
	@RequestMapping(value="addCongViec/{noidungcongviec}/{tencongviec}",method=RequestMethod.POST)
	public @ResponseBody boolean addCongViec(@PathVariable("noidungcongviec") String noidungcongviec
			,@PathVariable("tencongviec") String tencongviec){
		
		int oldSize = congviecService.getCongViec().size();
		CongViec congviec = new CongViec();
		congviec.setNoiDungCongViec(noidungcongviec);
		
		congviec.setTenCongViec(tencongviec);
		congviecService.saveCongViec(congviec);
		return (oldSize < congviecService.getCongViec().size());
	}
	
	@RequestMapping(value="/addBuocQuyTrinh/{maquytrinh}/{sothutu}/{songay}/{manguoidung}/{macongviec}",method=RequestMethod.POST)
	public @ResponseBody boolean addBuocQuyTrinh(@PathVariable("maquytrinh") int maquytrinh,
			@PathVariable("sothutu") int sothutu,
			@PathVariable("songay") int songay,
			@PathVariable("manguoidung") int manguoidung,
			@PathVariable("macongviec") int macongviec
			){
				
			QuyTrinh quytrinh = quytrinhService.findQuyTrinhID(maquytrinh);
			NguoiDung nguoidung = new NguoiDung();
			nguoidung = nguoidungService.findNguoiDungID(manguoidung);
			Buoc_NguoiDung buocnd = new Buoc_NguoiDung();
			buocnd.setNguoidung(nguoidung);
			buocnd.setQuytrinh(quytrinh);
			buocnd.setSothutu(sothutu);
			buocndService.saveBuocNguoiDung(buocnd);
	
				
		return true;
	}
	@RequestMapping(value="/addBuoc/{maquytrinh}/{sothutu}/{songay}/{macongviec}",method=RequestMethod.POST)
	public @ResponseBody boolean addBuoc(@PathVariable("maquytrinh") int maquytrinh,
			@PathVariable("sothutu") int sothutu,
			@PathVariable("songay") int songay,
			@PathVariable("macongviec") int macongviec
			){
			QuyTrinh quytrinh = quytrinhService.findQuyTrinhID(maquytrinh);
			Pk_QuyTrinh pkquytrinh = new Pk_QuyTrinh();
			pkquytrinh.setMaQuyTrinh(maquytrinh);
			pkquytrinh.setSoThuTu(sothutu);
			
			CongViec congviec = new CongViec();
			congviec = congviecService.findCongViecID(macongviec);
			Buoc buoc = new Buoc();
			buoc.setQuytrinh(quytrinh);
			buoc.setSoNgay(songay);
			buoc.setPkQuyTrinh(pkquytrinh);
			buoc.setCongviec(congviec);
			buocService.saveBuoc(buoc);
			
		return true;
	}
	
	
	
}
