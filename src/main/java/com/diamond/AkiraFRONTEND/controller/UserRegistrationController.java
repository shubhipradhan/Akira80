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

import com.diamond.AkiraBACKEND.dao.UserDAO;
import com.diamond.AkiraBACKEND.model.User;

@Controller
public class UserRegistrationController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value={"/userRegister"})
	public String userRegisterPage(@ModelAttribute("user") User user,BindingResult result,HttpServletRequest request){
		return "userRegister";
	}
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String listUsers(Model model)
	{
		model.addAttribute("user",new User());
		System.out.println("inside controller");
		
		model.addAttribute("listUsers",userDAO.listUsers());
		return "register";
	}
	
	@RequestMapping(value= "/users/add", method = RequestMethod.POST)
	public String addUser( @ModelAttribute("user") User user,BindingResult result,HttpServletRequest request)
	{
		
		
		
		if(result.hasErrors())
		{
			return "userRegister";
		}
		else{
			if (user.getUserId() == 0) {
				userDAO.addUser(user);
			} else {
				userDAO.updateUser(user);
			}

			return "redirect:/login";
		}
	}
	
	
	@RequestMapping("/remove/{userId}")
	public String deleteUser(@PathVariable("userId") int userId)
	{
		userDAO.deleteUser(userId);
		return "redirect:/register";
	}
	
	
	@RequestMapping("/edit/{userId}")
	public String editUser(@PathVariable("userId") int userId, Model model)
	{
		model.addAttribute("user", userDAO.getUserById(userId));
		
		
        model.addAttribute("listUsers", userDAO.listUsers());
        return "register";
	}
	
	
}
