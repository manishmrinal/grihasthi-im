package com.grihasthi.inventorymanagement.dao;

import java.util.List;

import com.grihasthi.inventorymanagement.beans.Product;

public interface ProductDetailsInterface {
	
	
	public List<Product> getAll();
	public List<Product> getProductByBarcode(String barcode);
	public List<Product> getProductByName(String p_name);
	public List<Product> getProductByCompany(String p_company);
	

}
