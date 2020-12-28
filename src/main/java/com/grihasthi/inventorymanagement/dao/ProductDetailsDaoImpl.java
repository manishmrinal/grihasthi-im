package com.grihasthi.inventorymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grihasthi.inventorymanagement.beans.Product;

@Repository
public class ProductDetailsDaoImpl implements ProductDetailsInterface {

	private  EntityManager em;
	
	@Autowired
	public ProductDetailsDaoImpl(EntityManager emc) {
		// TODO Auto-generated constructor stub
	
	this.em=emc;
	
	}
	
	
	@Override
	@Transactional
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		
		Session sess= em.unwrap(Session.class);
		System.out.println("firing query");
		Query<Product> tq = sess.createQuery("From product",Product.class);
//		
		List<Product> result=tq.getResultList();
//		
		System.out.println(result.toString());
		
		
		return result;
	}


}

//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.grihasthi.inventorymanagement.beans.test;
//
//@Repository
//public class TestDAOHibernateImpl implements TestInterface {
//
//	
//	private EntityManager entityManager;
//	
//	@Autowired
//	 public TestDAOHibernateImpl(EntityManager em) {
//		// TODO Auto-generated constructor stub
//		
//		this.entityManager=em;
//	}
//	@Override
//	@Transactional
//	public List<test> findAll() {
//		// TODO Auto-generated method stub
//		
//		Session sess= entityManager.unwrap(Session.class);
//		Query<test> tq = sess.createQuery("From test_table",test.class);
//		
//		List<test> result=tq.getResultList();
//		
//		System.out.println(result.toString());
//		
//		
//		
//		
//		return result;
//	}
//
//}
