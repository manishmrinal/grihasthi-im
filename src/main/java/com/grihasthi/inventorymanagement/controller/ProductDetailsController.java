package com.grihasthi.inventorymanagement.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.grihasthi.inventorymanagement.beans.Product;
import com.grihasthi.inventorymanagement.dao.ProductDetailsInterface;
import com.grihasthi.inventorymanagement.service.ConvertToPdfService;
import com.grihasthi.inventorymanagement.service.ConvertToXLS;
import com.grihasthi.inventorymanagement.service.MailSenderService;
import com.itextpdf.layout.Document;


@Controller
@RequestMapping(value= "/products" )
public class ProductDetailsController {
	
	private ProductDetailsInterface dao;
	
	private ConvertToPdfService pdfservice;
	
	@Autowired
	private MailSenderService mailService;
	
	public ProductDetailsController(ProductDetailsInterface daoc , ConvertToPdfService service) {
		// TODO Auto-generated constructor stub
		this.dao=daoc;
		
		this.pdfservice=service;
		
	}
	
	//generatePdf
	
	@RequestMapping(value= "/generateXLS" ,method = RequestMethod.GET )
	public void getExcel(HttpServletResponse response) throws IOException{
		
	
		
		//Document doc= service.covertToPdf();
		
		response.setContentType("application/octet-stream");
		String headerKey="Content-Disposition";
		
		DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDate=dateFormat.format(new Date());
		String fileName="Products_"+currentDate+".xlsx";
		
		String headerValue ="attachment; filename="+fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<Product> result= dao.getAll();
		
		ConvertToXLS exporter = new ConvertToXLS(result);
		exporter.export(response);

		
		
	}
	
	@RequestMapping(value= "/generatePDF" ,method = RequestMethod.GET )
	public void getPdf(HttpServletResponse response) throws IOException{
		
	
		
		//Document doc= service.covertToPdf();
		
		response.setContentType("application/pdf");
		String headerKey="Content-Disposition";
		
		DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDate=dateFormat.format(new Date());
		String fileName="Products_"+currentDate+".pdf";
		
		String headerValue ="attachment; filename="+fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<Product> result= dao.getAll();
		
		ConvertToPdfService exporter = new ConvertToPdfService(result);
		exporter.export(response);

		
		
	}
	
	
	
	@RequestMapping(value= "/all" ,method = RequestMethod.POST )
	public String getAll(Model md){
		
		List<Product> result= dao.getAll();
		
		md.addAttribute("products", result);
		
		return "list-prd";
		
	}
	
	@RequestMapping(value= "/barcodeScanResult" ,method = RequestMethod.POST )
	public String getProductByBarcode(@RequestParam String barcode, Model md){
		
		List<Product> result= dao.getProductByBarcode(barcode);
		
		md.addAttribute("products", result);
		
		return "list-prd";
		
	}
	
	@RequestMapping(value= "/barcodeScan" ,method = RequestMethod.POST )
	public String getBarcodePage(){
		
		return "barcodeScan";
		
	}
	
	//
	@RequestMapping(value= "/searchByName" ,method = RequestMethod.POST )
	public String getSearchPage(Model md){
		
		List<Product> result= dao.getAll();
		
		md.addAttribute("products", result);
		
		return "searchPage";
		
	}
	
	@RequestMapping(value= "/searchByProduct" ,method = RequestMethod.POST )
	public String getProductByName(@RequestParam String p_name,Model md){
		
		List<Product> result= dao.getProductByName(p_name);
		
		md.addAttribute("products", result);
		
		return "list-prd";
		
	}
	@RequestMapping(value= "/searchByCompany" ,method = RequestMethod.POST )
	public String getProductByCompany(@RequestParam String p_company,Model md){
		
		List<Product> result= dao.getProductByCompany(p_company);
		
		md.addAttribute("products", result);
		
		return "list-prd";
		
	}
	
	@RequestMapping(value= "/sendOnMail" ,method = RequestMethod.GET )
	public String sendMail(){
		
		try {
			mailService.sendMail();
		}
		catch(MailException me)
		{
			me.printStackTrace();
			
		}
		
	     return "health";
		
		
	}

}

