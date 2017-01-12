package com.diamond.AkiraBACKEND.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.diamond.AkiraBACKEND.dao.ProductDAO;
import com.diamond.AkiraBACKEND.model.Product;



@Repository("productDAO")
@Transactional
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void addProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(product);
		
	}

	@Transactional
	public void updateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
		
	}

	

	@Transactional
	public Product getProductById(int productId) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.createQuery("from Product where productId="+productId).getSingleResult();
		return product;
	}

	@Transactional
	public List<Product> listProducts() {
		Session session=sessionFactory.getCurrentSession();
		List<Product> products=session.createQuery("from Product").getResultList();
		return products;
		
	}

	public void deleteProduct(int productId) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.createQuery("from Product where productId="+productId).getSingleResult();
		session.delete(product);
		
	}
	
	

	

}
