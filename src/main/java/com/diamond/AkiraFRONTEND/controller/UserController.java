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
import org.springframework.web.servlet.ModelAndView;

import com.diamond.AkiraBACKEND.dao.UserDAO;
import com.diamond.AkiraBACKEND.model.ShippingAddress;
import com.diamond.AkiraBACKEND.model.User;



@Controller
public class UserController {

	
	@Autowired
	UserDAO userDAO;
		
	@RequestMapping(value = "/cart_checkout", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("shippingAddress", "shippingaddress", new ShippingAddress());
    }
 
	//////////////////////////////////////////////////////////////////
	
	
	@RequestMapping("/user/userPage")
	public String userhomePage()
	{
		return "userPage";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String userPage()
	{
		return "welcomePage";
	}
	
	
	///////////////////////////////////////////////////////////////
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String listUsers(Model model)
	{
		model.addAttribute("user",new User());
		System.out.println("inside controller");
		
		model.addAttribute("listUsers",userDAO.listUsers());
		return "register";
	}
	
	@RequestMapping(value= "/users/add", method=RequestMethod.POST)
	public String addUser( @ModelAttribute("user") User user,BindingResult result,HttpServletRequest request )
	{
		
		/*//String filename = null;
		byte[] bytes;
		
		if (!user.getUserimage().isEmpty()) {

			try {
				
				bytes = user.getUserimage().getBytes();
				userDAO.addUser(user);
				System.out.println("Data Inserted");
				String path = request.getSession().getServletContext().getRealPath("/static/images/" + user.getUserId() + ".jpg");
				System.out.println("Path = " + path);
				System.out.println("File name = " + user.getUserimage().getOriginalFilename());
				File f = new File(path);
				BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(f));
				bs.write(bytes);
				bs.close();
				System.out.println("Image uploaded");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		*/
		
		if(result.hasErrors())
		{
			return "register";
		}
		else{
			if (user.getUserId() == 0) {
				userDAO.addUser(user);
			} else {
				userDAO.updateUser(user);
			}

			return "redirect:/register";
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
