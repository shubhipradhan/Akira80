package com.diamond.AkiraBACKEND.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.diamond.AkiraBACKEND.dao.OrderDAO;
import com.diamond.AkiraBACKEND.model.Order;


@Repository("orderDAO")
@Transactional
@EnableTransactionManagement
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void addOrder(Order order) {
	
		Session session=sessionFactory.getCurrentSession();
		session.persist(order);
	}


	@Transactional
	public void updateOrder(Order order) {
		Session session=sessionFactory.getCurrentSession();
		session.update(order);
		
	}


	@Transactional
	public void deleteOrder(int orderId) {
		Session session=sessionFactory.getCurrentSession();
		Order order=(Order)session.createQuery("from order where orderId="+orderId).getSingleResult();
		session.delete(order);
		
	}


	@Transactional
	public Order getOrderById(int orderId) {
		Session session=sessionFactory.getCurrentSession();
		Order order=(Order)session.createQuery("from Order where orderId="+orderId).getSingleResult();
		return order;
	}


	@Transactional
	public List<Order> listOrders() {
		Session session=sessionFactory.getCurrentSession();
		List<Order> orders=session.createQuery("from Order").getResultList();
		return orders;
	}

}
