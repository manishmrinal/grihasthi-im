package com.grihasthi.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grihasthi.inventorymanagement.beans.test;
import com.grihasthi.inventorymanagement.dao.TestInterface;


@Controller
@RequestMapping("/")
public class RestController {

	private TestInterface testDao;
	
	@RequestMapping("/")
	public String sayHello() {
		return "health";
	}
	
	
	
	@Autowired
	public RestController(TestInterface tidao) {
		// TODO Auto-generated constructor stub
		
		this.testDao=tidao;
	}
	
	@GetMapping("/all")
	public List<test> findAll(){
		
		return testDao.findAll();
	}
}
