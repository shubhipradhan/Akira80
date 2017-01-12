package com.diamond.AkiraFRONTEND.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diamond.AkiraBACKEND.dao.ProductDAO;
import com.diamond.AkiraBACKEND.model.Product;

@Controller
public class ProductControllerSpring {

	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String listProducts(Model model)
	{
		model.addAttribute("product",new Product());
		System.out.println("inside controller");
		
		model.addAttribute("listProducts",productDAO.listProducts());
		return "product";
	}
	
	@RequestMapping(value= "/product/add", method = RequestMethod.POST)
	public String addProduct( @ModelAttribute("product") Product product,BindingResult result,HttpServletRequest request)
	{
		
		
		
		if(result.hasErrors())
		{
			return "product";
		}
		else{
			if (product.getProductId() == 0) {
				productDAO.addProduct(product);
			} else {
				productDAO.updateProduct(product);
			}

			return "redirect:/product";
		}
	}
	
	
	@RequestMapping("/product/remove/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId)
	{
		productDAO.deleteProduct(productId);
		return "redirect:/product";
	}
	
	
	@RequestMapping("/product/edit/{productId}")
	public String editProduct(@PathVariable("productId") int productId, Model model)
	{
		model.addAttribute("product", productDAO.getProductById(productId));
		
		
        model.addAttribute("listProducts", productDAO.listProducts());
        return "product";
	}


}
