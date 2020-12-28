package com.grihasthi.inventorymanagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity(name="product_details")
@Table(name="product_details", schema="public")
public class Product_details {

	public double getPd_price() {
		return pd_price;
	}

	public void setPd_price(double pd_price) {
		this.pd_price = pd_price;
	}

	public int getPd_stock() {
		return pd_stock;
	}

	public void setPd_stock(int pd_stock) {
		this.pd_stock = pd_stock;
	}

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pd_id" )
	private int pd_id;
	
	@Column(name="pd_price")
	private double pd_price;
	
	@Column(name="pd_stock")
	private int pd_stock;
	
//	//@ManyToOne
//	@Mapp
//	private Product product;
//
////	@Override
////	public String toString() {
////		return "Product_details [pd_id=" + pd_id + ", pd_price=" + pd_price + ", pd_stock=" + pd_stock + ", product="
////				+ 
////				//product +
////				"]";
////	}

	public Product_details() {
		// TODO Auto-generated constructor stub
	}

	public Product_details(double pd_price, int pd_stock) {
		super();
		this.pd_price = pd_price;
		this.pd_stock = pd_stock;
		
	}

	public int getPd_id() {
		return pd_id;
	}

	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}

	@Override
	public String toString() {
		return "Product_details [pd_id=" + pd_id + ", pd_price=" + pd_price + ", pd_stock=" + pd_stock + "]";
	}
	
	
	
	
	
	
}
