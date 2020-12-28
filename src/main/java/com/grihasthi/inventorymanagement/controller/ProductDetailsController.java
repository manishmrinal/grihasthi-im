package com.grihasthi.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grihasthi.inventorymanagement.beans.Product;
import com.grihasthi.inventorymanagement.dao.ProductDetailsInterface;


@Controller
@RequestMapping("/products")
public class ProductDetailsController {
	
	private ProductDetailsInterface dao;
	
	public ProductDetailsController(ProductDetailsInterface daoc) {
		// TODO Auto-generated constructor stub
		this.dao=daoc;
		
	}
	
	@GetMapping("/all")
	public String getAll(Model md){
		
		List<Product> result= dao.getAll();
		
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
