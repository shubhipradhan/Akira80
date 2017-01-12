package com.diamond.AkiraFRONTEND.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diamond.AkiraBACKEND.dao.ProductDAO;
import com.diamond.AkiraBACKEND.model.Product;
import com.google.gson.Gson;

@Controller
public class ProductController {

	

	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping("/productDetails")
	public ModelAndView products()
	{
		List<Product> products=productDAO.listProducts();
		String productList=new Gson().toJson(products);
		ModelAndView model=new ModelAndView("productDetails");
		model.addObject("productList", productList);
		
		return model;
		
	}
	
	@RequestMapping("/productInfo/{productId}")
	public ModelAndView productPage(@PathVariable("productId") int productId){
		
		
		Product product=productDAO.getProductById(productId);
		ModelAndView model=new ModelAndView("productInfo");
		model.addObject("product",product);
		return model;
	}
	
	/*@RequestMapping("/productDetails/{productId}" )
	public String getProductById(@PathVariable("productId") int productId, Model model)
	{
		productDAO.getProductById(productId);
		
		return "redirect:/productDetails";
	}*/
	
	/*@RequestMapping("/add")
	public String addProduct()
	{
		Product product=new Product();
		product.setProductName("S114");
		product.setPrice(105000);
		product.setCategory("Necklace");
		productDAO.addProduct(product);
		
		
		
		return "redirect:/productDetails";
		
	}*/
	
}
