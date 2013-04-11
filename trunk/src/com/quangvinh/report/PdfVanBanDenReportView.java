package com.quangvinh.report;

import java.awt.Color;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.quangvinh.service.IVanBanDenService;

public class PdfVanBanDenReportView extends AbstractPdfView{

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition", "inline; filename=yourExcelFile.pdf");*/
		 request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType ("application/pdf;charset=UTF-8");
		Map<Integer,String> printData = (Map<Integer,String>) model.get("printData");
		Map<Integer,Object[]> printDataVanBanDen = (Map<Integer,Object[]>) model.get("printDataVanBanDen");
		int madanhmuc = (int) model.get("madanhmuc");
		Date tungay = (Date) model.get("tungay");
		Date denngay = (Date) model.get("denngay");
		
		/**
		 * Loai Van Ban
		 * 
		 */
			
	    Font f1;
	    BaseFont baseFont = BaseFont.createFont("c:\\WINDOWS\\fonts\\times.ttf", BaseFont.IDENTITY_H, true); 
	    f1 = new Font(baseFont, 10);
	    
	   /* PdfPTable table = new PdfPTable(2);
	    PdfPCell cell = new PdfPCell (new Paragraph ("Nguyễn",f1));
	    table.addCell(cell);
	    cell = new PdfPCell (new Paragraph ("Đạt",f1));
	    table.addCell (cell);

        document.add(table);   	*/
			
			for (Map.Entry<Integer, String> entry : printData.entrySet()) {
				
				
				/*Cell cell = new Cell(entry.getValue());
				cell.setBackgroundColor(new Color(255,0,0));
			    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setHeader(true);
			    cell.setColspan(5);*/
			    
				
			    PdfPCell cell = new PdfPCell (new Paragraph(entry.getValue(),f1));
			    cell.setColspan(5);
			    
			    PdfPTable table = new PdfPTable(5);
			    table.addCell(cell);
			    table.addCell(new PdfPCell(new Paragraph("Số Đến",f1)));
			    table.addCell(new PdfPCell(new Paragraph("Ngày Đến",f1)));
			    table.addCell(new PdfPCell(new Paragraph("Số Hiệu Văn Bản",f1)));
			    table.addCell(new PdfPCell(new Paragraph("Ngày Ban Hành",f1)));
			    table.addCell(new PdfPCell(new Paragraph("Trích Yếu Nội Dung",f1)));
			    for (Map.Entry<Integer, Object[]> entryVanBan : printDataVanBanDen.entrySet()) {
					/*for(Object obj: entryVanBan.getValue()){
						table.addCell(new PdfPCell(new Paragraph(obj.toString(),f1)));
					}*/
					 int count = entryVanBan.getValue().length;
					 Object[] tt = entryVanBan.getValue();
					 for(int i=0;i < count-1;i++){
						 if(entry.getKey() == tt[5] )
						 table.addCell(new PdfPCell(new Paragraph(tt[i].toString(),f1)));
						 
					 }
					
					
		        }
			    
			    
				/*Table table = new Table(5);
				table.setBorderWidth(1);
			    table.setPadding(10);
				table.addCell(cell);
				table.addCell("Số Đến");
				table.addCell("Ngày Đến");
				table.addCell("Số Hiệu Văn Bản");
				table.addCell("Ngày Ban Hành");
				table.addCell("Trích Yếu Nội Dung");
				for (Map.Entry<Integer, Object[]> entryVanBan : printDataVanBanDen.entrySet()) {
					for(Object obj: entryVanBan.getValue()){
						table.addCell(obj.toString());
					}
		        }*/
				
				
				document.add(table);
	        }
			
			
		
		
			
	
		
		/*Cell cell = new Cell("header");
		cell.setBackgroundColor(new Color(255,0,0));
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setHeader(true);
	    cell.setColspan(2);
		Table table = new Table(2);
		table.setBorderWidth(1);
	    table.setPadding(10);
		table.addCell(cell);
		table.addCell("Ma");
		table.addCell("Ten");	
		for (Map.Entry<Integer, String> entry : printData.entrySet()) {
			table.addCell(entry.getKey().toString());
			table.addCell(entry.getValue());
        }
		
		
		document.add(table);*/
		
		
		
		
	}

		
		
}
