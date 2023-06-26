package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of " + getClass());
	}
	//add req handling method to forward the clnt to index.jsp
	@GetMapping("/") //= @RequestMapping(RequestMethod =GET) : doGet
	public String showHomePage() {
		System.out.println("in show home page");
		return "/index";//Controller --> LVN --> D.S ---> V.R --> AVN : 
		//  /WEB-INF/views/index.jsp
	}
	
}
