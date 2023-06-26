package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Request handling controller=Handler : spring bean , singleton n eager
@Controller // Mandatory
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of " + getClass());
	}

	@RequestMapping("/hello") // mandatory method level annotation to tell SC
	// following is req handling method , which can intercept :
	// GET/POST/PUT/DELETE ...
	public String sayHello() {
		System.out.println("in say hello");
		return "/welcome";// Handler(RHC) rets LVN(logical=forward view name) -->
		// D.S(Dispatcher Servlet) ---> V.R -->AVN : /WEB-INF/views/welcome.jsp
		// D.S --> chks for model(results) --> NO --> D.S --> forwards the clnt to the
		// view layer , in the SAME request .
	}

}
