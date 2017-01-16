package com.diamond.AkiraBACKEND.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.diamond.AkiraBACKEND.dao.CartDAO;
import com.diamond.AkiraBACKEND.model.Cart;

@Repository("cartDAO")
@Transactional
@EnableTransactionManagement
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void addCart(Cart cart) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(cart);
		
	}

	@Transactional
	public void updateCart(Cart cart) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(cart);
		
	}

	@Transactional
	public Cart getCartById(int cartId) {
		Session session=sessionFactory.getCurrentSession();
		Cart cart=(Cart)session.createQuery("from Cart where cartId="+cartId).getSingleResult();
		return cart;	
	}

	
}
