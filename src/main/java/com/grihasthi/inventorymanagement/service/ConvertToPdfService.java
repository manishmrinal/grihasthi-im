package com.grihasthi.inventorymanagement.service;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.grihasthi.inventorymanagement.beans.Product;
import com.grihasthi.inventorymanagement.dao.ProductDetailsInterface;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
//import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Service
public class ConvertToPdfService {

	
	private List<Product> listProduct;
	
	
	public ConvertToPdfService(List<Product> result) {
		
		this.listProduct = result;
	}

	
	private void writeTableheader(PdfPTable table) {
		
		PdfPCell cell =new PdfPCell();
		
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("Name",font));
		table.addCell(cell);
			
		
		cell.setPhrase(new Phrase("Company",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Volume",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Metric",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Barcode",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Price",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Stock",font));
		table.addCell(cell);
		
		
	}
	
	private void writeTableData(PdfPTable table) {
		
		for(Product product:listProduct) {
			
			table.addCell(product.getP_name());
			table.addCell(product.getP_company());
			table.addCell(String.valueOf(product.getP_volume()));
			table.addCell(product.getP_metric());
			table.addCell(product.getP_barcode());
			table.addCell(product.getProduct_details().toString());
			table.addCell(product.getProduct_details().toString());
			
			
		}
		
	}
	
	
	public void export( HttpServletResponse response) throws IOException {
		
		
		Document document=new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
	
	
//	public void export( OutputStream outputStream) throws IOException {
//		
//		
//		Document document=new Document(PageSize.A4);
//		
//		PdfWriter.getInstance(document, outputStream);
//		document.open();
		
		document.add(new Paragraph("List of all the products"));
		
		PdfPTable table= new PdfPTable(7);
		table.setWidthPercentage(100);
		
		table.setSpacingBefore(15);
		
		writeTableheader(table);
		writeTableData(table);
		
		document.add(table);
		
		document.close();
		
	}


//	public Document covertToPdf() {
//		
//		List<Product> result= prodDao.getAll();
//		
//		String stock="D://stock.pdf";
//		Document document = null;
//		
//		try {
//			PdfWriter pw=new PdfWriter(stock);
//			
//			PdfDocument pdfdoc= new PdfDocument(pw);
//			
//			pdfdoc.addNewPage();
//			
//			document=new  Document(pdfdoc);
//			
//			document.close();
//			
//			
//			
//			
//		} catch (FileNotFoundException e) {
//			
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return document;
//		
//		
		
		
	}
	
	

