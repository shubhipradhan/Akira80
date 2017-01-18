package com.diamond.AkiraFRONTEND.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diamond.AkiraBACKEND.dao.CartDAO;
import com.diamond.AkiraBACKEND.dao.ItemDAO;
import com.diamond.AkiraBACKEND.dao.ProductDAO;
import com.diamond.AkiraBACKEND.dao.UserDAO;
import com.diamond.AkiraBACKEND.model.Cart;
import com.diamond.AkiraBACKEND.model.Item;
import com.diamond.AkiraBACKEND.model.Product;
import com.diamond.AkiraBACKEND.model.User;
import com.google.gson.Gson;

@Controller
public class CartController {
	
	@Autowired
	ItemDAO itemDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping("/AddtoCart/{productId}")
	public ModelAndView cart(@PathVariable(name="productId")int productId,Principal principal){
		
		/*ModelAndView model=new ModelAndView("cart");
		Product product=productDAO.getProductById(productId);
		List<Item> items=new ArrayList<Item>();
		//items.add(product);
		
		return model;
		*/
		
		
		ModelAndView model=new ModelAndView("cart");
		System.out.println(principal.getName());
		User user=userDAO.getUserByUsername(principal.getName());
		model.addObject("user",user);
		
		Cart cart=user.getCart();
		/// Displaying the cart id in console
		System.out.println(cart);
		
		Product product=productDAO.getProductById(productId);
		
		// Displaying the productId in console
		System.out.println(productId);
		
		//List<Item> items=itemDAO.listItems();
		
		List<Item> items=cart.getItems();
		
		for(int i=0;i<items.size();i++)
			if(product.getProductId()==items.get(i).getProduct().getProductId()){
				Item item=items.get(i);
				item.setQuantity(item.getQuantity()+1);
				item.setItemTotal(product.getPrice()*item.getQuantity());
				
				itemDAO.addItem(item);
				
			}
			else{
				
				Item item=new Item();
				item.setProduct(productDAO.getProductById(productId));
				item.setQuantity(item.getQuantity()+1);
				item.setCart(cart);
                item.setItemTotal(product.getPrice()*item.getQuantity());
                itemDAO.addItem(item);
                
			}
		return model;
		//model.addObject("itemList",items);
	//
}
	
	/////////////////////////////////////////
	
	/*@RequestMapping("/cart")
	public ModelAndView products()
	{
		List<Item> items=itemDAO.listItems();
		String itemList=new Gson().toJson(items);
		ModelAndView model=new ModelAndView("order");
		model.addObject("itemList", itemList);
		
		return model;
		
	}*/
	
	
	/*@RequestMapping("/cart/{cartId}")
	public ModelAndView productPage(@PathVariable("cartId") int cartId){
		
		
		Cart cart=cartDAO.getCartById(cartId);
		ModelAndView model=new ModelAndView("order");
		model.addObject("cart",cart);
		return model;
	}*/
}
