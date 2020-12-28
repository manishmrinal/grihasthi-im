package com.grihasthi.inventorymanagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="test_table")
@Table(name="test_table")
public class test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
test(){}

public test(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
	public test(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "test [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
