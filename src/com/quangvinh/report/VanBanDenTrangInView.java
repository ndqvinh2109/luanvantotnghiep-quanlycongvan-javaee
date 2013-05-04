package com.quangvinh.report;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VanBanDenTrangInView extends AbstractPdfView{

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Template Export Van Ban Den
		 */
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition", "inline; filename=yourExcelFile.pdf");
		Map<Integer,String> printData = (Map<Integer,String>) model.get("printData");
		Map<Integer,Object[]> printDataVanBanDen = (Map<Integer,Object[]>) model.get("printDataVanBanDen");
		
		
		Date tungay = (Date) model.get("tungay");
		Date denngay = (Date) model.get("denngay");
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    
		Font f1;
		Font f2;
		Font f3;
		Font f4;
		Font f5;
	    BaseFont baseFont = BaseFont.createFont("c:\\WINDOWS\\fonts\\times.ttf", BaseFont.IDENTITY_H, true);
	    
	    f1 = new Font(baseFont, 10);
	    f2 = new Font(baseFont,12);
	    f3 = new Font(baseFont,16);
	    f4 = new Font(baseFont,13,Font.NORMAL,new Color(66, 66, 255));
	    f5 = new Font(baseFont,10,Font.ITALIC);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
	    
	    String text = "CHI CỤC THUẾ THÀNH PHỐ CẦN THƠ                  CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM";
	    Paragraph p = new Paragraph(text,f2);
	    p.setAlignment(Element.ALIGN_CENTER);
	    document.add(p);
	    
	    text = "                                                                                           	Độc lập - Tự do - Hạnh phúc";
	    p = new Paragraph(text,f2);
	    p.setAlignment(Element.ALIGN_CENTER);
	    document.add(p);
	    
	    text = "Cần Thơ, ngày " + day + " tháng " + month + " năm " + year;
	    p = new Paragraph(text,f1);
	    p.setAlignment(Element.ALIGN_RIGHT);
	    p.setSpacingBefore(10);
	    p.setSpacingAfter(35);
	    document.add(p);
	    
	    text = "BÁO CÁO DANH MỤC VĂN BẢN ĐẾN";
	    p = new Paragraph(text,f3);
	    p.setAlignment(Element.ALIGN_CENTER);
	    p.setSpacingAfter(25);	
	    document.add(p);
	       	
			for (Map.Entry<Integer, String> entry : printData.entrySet()) {
				Paragraph cTitle = new Paragraph(entry.getKey() + ". " +  entry.getValue(), f4);
			
				PdfPTable table = new PdfPTable(5);
			    table.setSpacingBefore(20);
			    table.setSpacingAfter(30);
			    table.setWidthPercentage(100);
			    PdfPCell cell = new PdfPCell(new Paragraph("Số Đến",f1));
			    
			    cell.setGrayFill(0.75f);
			    cell.setBackgroundColor(new Color(11, 122, 244));
			    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			    cell.setPadding(8);
			    table.addCell(cell);
			    
			    cell = new PdfPCell(new Paragraph("Ngày Đến",f1));
			    cell.setGrayFill(0.75f);
			    cell.setBackgroundColor(new Color(11, 122, 244));
			    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			    cell.setPadding(8);
			    
			    table.addCell(cell);
			    
			    cell = new PdfPCell(new Paragraph("Số Hiệu Văn Bản",f1));
			    
			    cell.setGrayFill(0.75f);
			    cell.setBackgroundColor(new Color(11, 122, 244));
			    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			    cell.setPadding(8);
			    table.addCell(cell);
			    
			    cell = new PdfPCell(new Paragraph("Ngày Ban Hành",f1));
			   
			    cell.setGrayFill(0.75f);
			    cell.setBackgroundColor(new Color(11, 122, 244));
			    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			    cell.setPadding(8);
			    table.addCell(cell);
			   
			    cell = new PdfPCell(new Paragraph("Trích Yếu Nội Dung",f1));
			    
			    cell.setGrayFill(0.75f);
			    cell.setBackgroundColor(new Color(11, 122, 244));
			    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			    cell.setPadding(8);
			    table.addCell(cell);
			    
			  
			    for (Map.Entry<Integer, Object[]> entryVanBan : printDataVanBanDen.entrySet()) {
			    	  
					 int count = entryVanBan.getValue().length;
					 Object[] tt = entryVanBan.getValue();
					 for(int i=0;i < count-1;i++){
						 Date temp = dateFormat.parse(tt[1].toString());
						 
						 if((entry.getKey() == tt[5]) && (temp.after(tungay) || temp.equals(tungay)) && (temp.before(denngay) || temp.equals(denngay)))
							table.addCell(new PdfPCell(new Paragraph(tt[i].toString(),f1)));
						 
					 }
		        }
			    
			    document.add(cTitle);
				document.add(table);
	        }
			text = "Thủ trưởng đơn vị";
	  	    p = new Paragraph(text,f1);
	  	    p.setAlignment(Element.ALIGN_RIGHT);
	  	    p.setSpacingAfter(25);	
	  	    document.add(p);
	  	    
	  	    text = "(Ký tên, đóng dấu)";
	  	    p = new Paragraph(text,f5);
	  	    p.setAlignment(Element.ALIGN_RIGHT);
	  	    p.setSpacingAfter(25);	
	  	    document.add(p);
	}

}
