package com.quangvinh.report;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;


public class PdfVanBanDenReportView extends AbstractPdfView{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<Integer,String> printData = (Map<Integer,String>) model.get("printData");
		System.out.println("ffffffffjhfkjhfsdhfksdkjfks");
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition", "inline; filename=yourExcelFile.pdf");
		Cell cell = new Cell("header");
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
		
		
		document.add(table);
		
		
		
		
	}

		
		
}
