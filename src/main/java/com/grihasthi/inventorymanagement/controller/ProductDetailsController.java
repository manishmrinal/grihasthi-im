package com.grihasthi.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grihasthi.inventorymanagement.beans.Product;
import com.grihasthi.inventorymanagement.dao.ProductDetailsInterface;


@Controller
@RequestMapping(value= "/products" )
public class ProductDetailsController {
	
	private ProductDetailsInterface dao;
	
	public ProductDetailsController(ProductDetailsInterface daoc) {
		// TODO Auto-generated constructor stub
		this.dao=daoc;
		
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

}


//@org.springframework.web.bind.annotation.RestController
//@RequestMapping("/api")
//public class RestController {
//
//	private TestInterface testDao;
//	
//	@GetMapping("/")
//	public String sayHello() {
//		return "Hello World!";
//	}
//	
//	
//	@Autowired
//	public RestController(TestInterface tidao) {
//		// TODO Auto-generated constructor stub
//		
//		this.testDao=tidao;
//	}
//	
//	@GetMapping("/all")
//	public List<test> findAll(){
//		
//		return testDao.findAll();
//	}
//}
