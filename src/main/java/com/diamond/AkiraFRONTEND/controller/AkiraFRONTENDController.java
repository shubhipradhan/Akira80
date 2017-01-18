package com.diamond.AkiraFRONTEND.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diamond.AkiraBACKEND.dao.UserDAO;


@Controller
//@RequestMapping("/app")
public class AkiraFRONTENDController {
	
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping(value={"/homePage","/"})
	public String homePagePage(){
		return "homePage";
	}
	
	@RequestMapping("/about")
	public String aboutPage(){
		return "about";
	}
	
	@RequestMapping("/login")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "userPage";
    }
	
	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "adminPage";
    }
	
	 @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        return "redirect:/login?logout";
	    }
	 
	    private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }
	    
	    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "accessDenied";
	    }
	    
	    @RequestMapping("/home")
		public String homePage(){
			return "home";
		}
	    
	   /* @RequestMapping("/cart_checkout")
		public String initiateFlow()
		{
			return "redirect:/demoFlow";
		}*/
	    
	    
	//////////////////////////////////////////////////////////////////////////////////
/*	@RequestMapping("/home")
	public String homePage(){
		return "home";
	}
	
	@RequestMapping("/img")
	public String imgPage(){
		return "img";
	}
	
	
	
	@RequestMapping("/login")
	public String loginPage(){
		return "login";
	}*/
	
	
	/* @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	    public String adminPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "adminPage";
	    }
	
	@RequestMapping(value={"/userRegister"})
	public String userResgisterPage(){
		return "userRegister";
	}
	
	@RequestMapping("/logout")
	public String logoutPage(){
		
		return "homePage";
	}*/
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	 /*@RequestMapping(value = { "/welcomePage" }, method = RequestMethod.GET)
	    public String welcomePage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "welcomePage";
	    }
	 
	    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	    public String adminPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "adminPage";
	    }
	    
	    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
	    public String userPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "userPage";
	    }
	    
	    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "accessDenied";
	    }
	 */
	   /* @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage() {
	        return "login";
	    }*/
	 
	   
	/*@RequestMapping(value={"/", "/home","/logout"})
	public String homePage(){
		return "home";
	}
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage()
	{
		return "login";
	}
	*/
	
	/*@RequestMapping(value="/userDetail",method=RequestMethod.GET)
	public String userDetailPage(Model model)
	{
		model.addAttribute("user",new User());
		System.out.println("inside controller");
		
		model.addAttribute("listUsers",userDAO.listUsers());
		return "userDetail";
	}
	
	@RequestMapping(value="/welcomePage",method=RequestMethod.GET)
	public String welcomePage()
	{
		return "welcomePage";
	}
		
		
		@RequestMapping(value="/authfailure",method=RequestMethod.GET)
		public String accessDeniedPage()
		{
			return "accessDenied";
		}
		*/
	
/*	/// CRSF Code
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcomePage");
		return model;
	}

	@RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("homePage");
		return model;
	}
	
	@RequestMapping(value = {"/userPage"}, method = RequestMethod.GET)
	public ModelAndView userPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("userPage");
		return model;
	}
	
	@RequestMapping(value = {"/adminPage"}, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("adminPage");
		return model;
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from JournalDEV successfully.");
		}

		model.setViewName("loginPage");
		return model;
	}

*/
	/* @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	    public String homePage(Model model) {
	        
	        return "home";
	    }
	 

	 
		
		@RequestMapping(value="/login",method=RequestMethod.GET)
		public String loginPage()
		{
			return "login";
		}
		
		@RequestMapping(value="/user",method=RequestMethod.GET)
		public String userPage()
		{
			return "user";
		}
		*/
		
	/*// Sir wla
		@RequestMapping("/")
	public String indexPage()
	{
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage()
	{
		return "login";
	}
		@RequestMapping("/admin")
		public String adminPage()
		{
			return "admin";
		}
		
		@RequestMapping(value="/authfailure",method=RequestMethod.GET)
		public String accessDeniedPage()
		{
			return "accessDenied";
		}
		
	/////////////////////// RAM wla /app/admin
	@RequestMapping("/adminPage")
	public @ResponseBody String getAdminInfo() {
		String msg ="Welcome to Admin.";
		return msg;
	}
	@RequestMapping("/adminPage/admin")
	public String adminPage()
	{
		return "admin";
	}
	@RequestMapping("/user")
	public @ResponseBody String getUserInfo() {
		String msg ="Welcome to User.";
		return msg;
	}*/
}
