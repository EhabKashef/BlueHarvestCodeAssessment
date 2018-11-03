package com.blue.harvest.assessment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class _AppController {

	@RequestMapping("/")
	String home(ModelMap modal) {
		modal.addAttribute("title","Blue Harvest");
		return "customer";
	}

	
 

	
	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}

}
