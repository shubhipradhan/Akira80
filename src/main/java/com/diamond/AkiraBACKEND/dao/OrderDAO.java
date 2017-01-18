package com.diamond.AkiraBACKEND.dao;

import java.util.List;

import com.diamond.AkiraBACKEND.model.Order;


public interface OrderDAO {

public void addOrder(Order order);
	
	public void updateOrder(Order order);
	
	public void deleteOrder(int orderId);
	
	public Order getOrderById(int orderId);
	
	public List<Order> listOrders();
	
}
