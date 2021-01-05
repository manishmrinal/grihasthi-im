package com.grihasthi.inventorymanagement.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="product")
@Table(name="product", schema= "public")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="p_id")
	private int p_id;
	
	@Column(name="p_name")
	private String p_name;
	
	@Column(name="p_company")
	private String p_company;
	
	@Column(name="p_volume")
	private int p_volume;
	
	@Column(name="p_metric")
	private String p_metric;
	
	@Column(name="p_barcode")
	private String p_barcode;
	
//	//when joining columns
//	@JoinTable(name="product_details" , joinColumns= {@JoinColumn(name="pd_product_id",referencedColumnName = "p_id")})
//	//@JoinColumn(name="pd_product_id" )
	
		@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
		@JoinColumn(name="pd_product_id")
		private List<Product_details> product_details;
	
	
	public Product(int p_id, String p_name, String p_company, int p_volume, String p_metric, String p_barcode,
			List<Product_details> product_details) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_company = p_company;
		this.p_volume = p_volume;
		this.p_metric = p_metric;
		this.p_barcode = p_barcode;
		this.product_details = product_details;
	}

	public Product( String p_name, String p_company, int p_volume, String p_metric, String p_barcode,
			List<Product_details> product_details) {
		super();
		
		this.p_name = p_name;
		this.p_company = p_company;
		this.p_volume = p_volume;
		this.p_metric = p_metric;
		this.p_barcode = p_barcode;
		this.product_details = product_details;
	}
	
	public Product() {}

	public int getP_id() {
		return p_id;
	}


	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public String getP_company() {
		return p_company;
	}


	public void setP_company(String p_company) {
		this.p_company = p_company;
	}


	public int getP_volume() {
		return p_volume;
	}


	public void setP_volume(int p_volume) {
		this.p_volume = p_volume;
	}


	public String getP_metric() {
		return p_metric;
	}


	public void setP_metric(String p_metric) {
		this.p_metric = p_metric;
	}


	public String getP_barcode() {
		return p_barcode;
	}


	public void setP_barcode(String p_barcode) {
		this.p_barcode = p_barcode;
	}


	public List<Product_details> getProduct_details() {
		return product_details;
	}


	public void setProduct_details(List<Product_details> product_details) {
		this.product_details = product_details;
	}

	public void addProductDetails(Product_details pd) {
		
		if(product_details==null) {
			
			product_details=new ArrayList<>();
			
		}
		
		product_details.add(pd);
		//pd.setProduct(this);
	}
	


	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_company=" + p_company + ", p_volume=" + p_volume
				+ ", p_metric=" + p_metric + ", p_barcode=" + p_barcode + "]";
	}
	
	public String toStringPricewise() {
		
		String newString="Price = ";
		return newString;
	}
	
	


}
