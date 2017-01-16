package com.diamond.AkiraBACKEND.dao;

import java.util.List;

import com.diamond.AkiraBACKEND.model.Item;
import com.diamond.AkiraBACKEND.model.Product;


public interface ItemDAO {
	
	

	public void addItem(Item item);
	
	public List<Item> removeAllItem();
	
	public void deleteItem(int itemId);

	public Item getItemById(int itemId);
	
	public List<Item> listItems();
	
	
}
