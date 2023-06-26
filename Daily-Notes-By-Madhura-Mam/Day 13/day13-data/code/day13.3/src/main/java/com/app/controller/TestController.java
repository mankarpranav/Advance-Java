package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // mandatory
@RequestMapping("/test") // prefix @ class level
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to test MnV
	@GetMapping("/test1")
	public ModelAndView testModelAndView() {
		System.out.println("in test m nv ");
		// ModelAndView (String lvn, String attName,Object modelAttrVal)
		return new ModelAndView("/test/test1", "server_time", LocalDateTime.now());
		// Controller --> MnV ---> D.S --> LVN --> V.R --> AVN :
		// /WEB-INF/views/test/test1.jsp --->D.S --> chks for model attrs --> adds it
		// under req scope --> forwards to view layer
	}
}
