package com.diamond.AkiraFRONTEND.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String adminPage()
	{
		return "admin";
	}
	@RequestMapping("/admin/homePage")
	public String adminhomePage()
	{
		return "adminPage";
	}
	
	
	
	/*@RequestMapping(value={"/admin/logout"})
	public String logoutPage(){
		return "homePage";
	}*/
	
}
