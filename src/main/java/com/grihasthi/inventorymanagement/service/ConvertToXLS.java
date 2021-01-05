package com.grihasthi.inventorymanagement.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.grihasthi.inventorymanagement.beans.*;

public class ConvertToXLS {
//extends AbstractXlsxView {

	
	private XSSFWorkbook workbook;
	
	private XSSFSheet sheet;
	
	private List<Product> listProduct;
	
	public ConvertToXLS(List<Product> listProduct) {
		
		this.listProduct = listProduct;
		workbook=new XSSFWorkbook();
		sheet= workbook.createSheet("products");
	}

	
	
	private void writeHeaderRow() {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID ");
		
		
		
		row.createCell(0).setCellValue("Name");
		row.createCell(1).setCellValue("Company");
		row.createCell(2).setCellValue("Volume");
		row.createCell(3).setCellValue("Metric");
		row.createCell(4).setCellValue("Barcode");
		row.createCell(5).setCellValue("Price");
		row.createCell(6).setCellValue("Stock");
		
		
	}
	
	private void writeDataRows() {
		
		int rowCount=1;
		
		for(Product product : listProduct) {
			
			Row row=sheet.createRow(rowCount++);
			
			row.createCell(0).setCellValue(product.getP_name());
			row.createCell(1).setCellValue(product.getP_company());
			row.createCell(2).setCellValue(product.getP_volume());
			row.createCell(3).setCellValue(product.getP_metric());
			row.createCell(4).setCellValue(product.getP_barcode());
			row.createCell(5).setCellValue(product.getProduct_details().toString());
			row.createCell(6).setCellValue(product.getProduct_details().toString());
			
			
		}
		
	}
	
	public void export(HttpServletResponse response) throws IOException {
		
		writeHeaderRow();
		writeDataRows();
		
		ServletOutputStream outputStream=response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
		
	}
	

}
