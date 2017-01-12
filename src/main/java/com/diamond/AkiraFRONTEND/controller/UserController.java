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
public class UserController {

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
	
}
