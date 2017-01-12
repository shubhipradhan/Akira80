package com.diamond.AkiraBACKEND.dao;

import com.diamond.AkiraBACKEND.model.Cart;

public interface CartDAO {

	public void addCart(Cart cart);
	public void updateCart(Cart cart);
	public Cart getCartById(int cartId);
}
