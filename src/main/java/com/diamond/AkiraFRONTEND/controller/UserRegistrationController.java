package com.diamond.AkiraFRONTEND.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
	
	
	
	
	
	@RequestMapping(value= "userregister/users/add", method=RequestMethod.POST)
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
	
	
	
}
