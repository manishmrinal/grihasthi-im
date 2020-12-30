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
		
		sess.close();
		return result;
	}


	@Override
	public List<Product> getProductByBarcode(String barcode) {
		// TODO Auto-generated method stub
		
		
		Session sess= em.unwrap(Session.class);
		System.out.println("firing query");
		System.out.println(barcode);
		Query<Product> tq = sess.createQuery("From product where p_barcode ='"+barcode+"'",Product.class);
//		
		//tq.setParameter("barcode",barcode);
		List<Product> result=tq.getResultList();
//		
		System.out.println(result.toString());
		
//		String hql = "FROM Employee E WHERE E.id = :employee_id";
//		Query query = session.createQuery(hql);
//		query.setParameter("employee_id",10);
//		List results = query.list();
		
		sess.close();
		
		return result;
	}


	@Override
	public List<Product> getProductByName(String p_name) {
		Session sess= em.unwrap(Session.class);
		System.out.println("firing query");
		System.out.println(p_name);
		Query<Product> tq = sess.createQuery("From product where p_name ='"+p_name+"'",Product.class);
//		
		//tq.setParameter("barcode",barcode);
		List<Product> result=tq.getResultList();
//		
		System.out.println(result.toString());
		
//		String hql = "FROM Employee E WHERE E.id = :employee_id";
//		Query query = session.createQuery(hql);
//		query.setParameter("employee_id",10);
//		List results = query.list();
		
		sess.close();
		
		return result;
	}


	@Override
	public List<Product> getProductByCompany(String p_company) {
		Session sess= em.unwrap(Session.class);
		System.out.println("firing query");
		System.out.println(p_company);
		Query<Product> tq = sess.createQuery("From product where p_company ='"+p_company+"'",Product.class);
//		
		//tq.setParameter("barcode",barcode);
		List<Product> result=tq.getResultList();
//		
		System.out.println(result.toString());
		
//		String hql = "FROM Employee E WHERE E.id = :employee_id";
//		Query query = session.createQuery(hql);
//		query.setParameter("employee_id",10);
//		List results = query.list();
		
		sess.close();
		
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
