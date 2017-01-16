package com.diamond.AkiraBACKEND.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.diamond.AkiraBACKEND.dao.ItemDAO;
import com.diamond.AkiraBACKEND.model.Item;

@Repository("itemDAO")
@Transactional
@EnableTransactionManagement
public class ItemDAOImpl implements ItemDAO {


	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Item> removeAllItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteItem(int itemId) {
		Session session=sessionFactory.getCurrentSession();
		Item item=(Item)session.createQuery("from Item where itemId"+itemId).getSingleResult();
		session.delete(item);
		
	}

	@Override
	public Item getItemById(int itemId) {
		return null;
	}

	@Transactional
	public List<Item> listItems() {
		Session session=sessionFactory.getCurrentSession();
		List<Item> items=session.createQuery("from Item").getResultList();
		
		return items;
	}

	@Override
	public void addItem(Item item) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(item);
		
	}

}
